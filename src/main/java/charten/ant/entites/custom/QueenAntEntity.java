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

    public QueenAntEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.collonie = new Collonie(this.getUuid());
    }
    public QueenAntEntity(World world, int age) {
        super(ModEntities.QUEEN_ANT, world, age, null);
        this.setHealth(30);
        this.collonie = new Collonie(this.getUuid());
        this.setFood(20);
    }
    @Override
    public boolean isQueen() {
        return true;
    }
    public Collonie getCollonie() {
        return this.collonie;
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

    public void LayWorkerEgg() {
        if (!this.getWorld().isClient()) {
            AntEntity Ant = new WorkerAntEntity(this.getWorld(), 0, this);
            Ant.setPosition(this.getPos().add(0,1,0));
            this.getWorld().spawnEntity(Ant);
            this.getCollonie().addAnt(Ant.getUuid());
        }
    }
    public void LayQueenEgg() {
        AntEntity Ant = new QueenAntEntity(this.getWorld(), 0);
        Ant.setPosition(this.getPos());
        this.getWorld().spawnEntity(Ant);
    }
    public void tick() {
        if (this.collonie != null) {
            if (!this.getWorld().isClient()) {
                if (this.getFood() > 10 && this.getRandom().nextInt(100) == 1) {
                    this.LayWorkerEgg();
                    this.setFood(this.getFood() - 5);
                    System.out.println("Food at: " + this.getFood());
                }
            }
        }
        super.tick();
    }
}
