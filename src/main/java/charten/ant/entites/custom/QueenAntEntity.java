package charten.ant.entites.custom;

import charten.ant.entites.ModEntities;
import charten.ant.util.Collonie;
import charten.ant.util.GeneralUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class QueenAntEntity extends AntEntity {

    private Collonie collonie;

    public QueenAntEntity(EntityType<? extends AntEntity> entityType, World world) {
        super(entityType, world);
        this.collonie = new Collonie(this.getUuid());
    }
    public QueenAntEntity(World world, int age) {
        super(ModEntities.QUEEN_ANT, world, age, null);
        this.collonie = new Collonie(this.getUuid());
    }
    @Override
    public boolean isQueen() {
        return true;
    }
    public Collonie getCollonie() {
        return this.collonie;
    }

    public ServerWorld getServerWorld() {
        if (this.getWorld() instanceof ServerWorld) {
            return (ServerWorld) this.getWorld();
        }
        return this.getCommandSource().getWorld();
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        if (!this.getWorld().isClient() && this.getCollonie() != null) {
             nbt.put("collonie", this.getCollonie().toNbt((ServerWorld) this.getWorld()));
        }
        super.writeCustomDataToNbt(nbt);
    }
    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.contains("collonie")) {
            if (!this.getWorld().isClient()) {
                this.collonie = Collonie.fromNbt(nbt, (ServerWorld) this.getWorld(), this);
                System.out.println("read this from nbt: " + nbt.getCompound("collonie"));
            }
        }
        super.readCustomDataFromNbt(nbt);
    }

    public WorkerAntEntity LayWorkerEgg() {
        WorkerAntEntity workerAnt = new WorkerAntEntity(this.getWorld(), 0, this);
        workerAnt.setPosition(this.getPos().add(0,1,0));
        this.getWorld().spawnEntity(workerAnt);
        this.getCollonie().addAnt(workerAnt.getUuid());
        return workerAnt;
    }
    public WorkerAntEntity prepWorkerEgg() {
        WorkerAntEntity workerAnt = new WorkerAntEntity(this.getWorld(), 0, this);
        workerAnt.setPosition(this.getPos().add(0,1,0));
        this.getCollonie().addAnt(workerAnt.getUuid());
        return workerAnt;
    }
    public QueenAntEntity LayQueenEgg() {
        QueenAntEntity queenAnt = new QueenAntEntity(this.getWorld(), 0);
        queenAnt.setPosition(this.getPos());
        this.getWorld().spawnEntity(queenAnt);
        return queenAnt;
    }
    public MajorAntEntity LayMajorEgg() {
        MajorAntEntity MajorAnt = new MajorAntEntity(this.getWorld(), 0, this);
        MajorAnt.setPosition(this.getPos());
        this.getWorld().spawnEntity(MajorAnt);
        this.getCollonie().addAnt(MajorAnt.getUuid());
        return MajorAnt;
    }
    public MajorAntEntity prepMajorEgg() {
        MajorAntEntity MajorAnt = new MajorAntEntity(this.getWorld(), 0, this);
        MajorAnt.setPosition(this.getPos());
        this.getCollonie().addAnt(MajorAnt.getUuid());
        return MajorAnt;
    }

    public void tick() {
        if (this.collonie != null) {
            if (!this.getWorld().isClient()) {
                if (this.getCollonie().getFoodAverage(this.getServerWorld()) > 10) {
                    List<AntEntity> ants = this.getCollonie().getAnts(this.getServerWorld());
                    for (AntEntity Ant: ants) {
                        if (Ant instanceof WorkerAntEntity && ((WorkerAntEntity) Ant).getActivity().equals("idle")) {
                            ((WorkerAntEntity) Ant).setActivity("storage");
                            break;
                        }
                    }
                }
                if (this.getFood() > 10 && this.getRandom().nextInt(100) == 1) {
                    if (this.getRandom().nextInt(3) == 1) {
                        this.LayMajorEgg().setActivity("royal_guard");
                    } else {
                        this.LayWorkerEgg();
                    }
                    this.setFood(this.getFood() - 5);
                    System.out.println("Food at: " + this.getFood());
                }
            }
        }
        super.tick();
    }

    public AntEntity chooseEggToLay() {
        if (this.getCollonie().getSize(this.getServerWorld()) > 15 &&
                this.getRandom().nextInt(3) == 1) {
            MajorAntEntity major = this.prepMajorEgg();
            if (this.getCollonie().getRoyalGuard(this.getServerWorld()).size() <= 2) {
                major.setActivity("royal_guard");
            }
        }
        return this.prepWorkerEgg();
    }
}
