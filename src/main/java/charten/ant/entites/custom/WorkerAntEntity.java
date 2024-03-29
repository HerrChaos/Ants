package charten.ant.entites.custom;

import charten.ant.entites.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class WorkerAntEntity extends AntEntity {

    private String activity;
    public WorkerAntEntity(EntityType<? extends AntEntity> entityType, World world) {
        super(entityType ,world);
        this.activity = "idle";
        this.setHealth(6);
    }
    public WorkerAntEntity(World world, int age, QueenAntEntity queenAnt) {
        super(ModEntities.WORKER_ANT, world, age, queenAnt);
        this.activity = "idle";
        this.setHealth(6);
    }
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putString("activity", this.getActivity());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("activity")) {
            this.activity = nbt.getString("activity");
        }
    }
    @Override
    public boolean isWorker() {
        return true;
    }

    public String getActivity() {
        return this.activity;
    }

    public boolean isFoodStorage() {
        return Objects.equals(this.getActivity(), "storage");
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    @Override
    public void tick() {
        super.tick();
        this.moveToQueenAnt();
    }
}
