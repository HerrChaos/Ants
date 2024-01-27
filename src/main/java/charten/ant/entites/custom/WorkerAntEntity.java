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
    public WorkerAntEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType ,world);
        //activity = "idle";
        this.setHealth(6);
    }
    public WorkerAntEntity(World world, int age, QueenAntEntity queenAnt) {
        super(ModEntities.WORKER_ANT, world, age, queenAnt);
        //activity = "idle";
        this.setHealth(6);
    }
    @Override
    public boolean isWorker() {
        return true;
    }

    public String getActivity() {
        return this.activity;
    }

    public boolean isFoodStorage() {
        return Objects.equals(this.getActivity(), "Storage");
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
