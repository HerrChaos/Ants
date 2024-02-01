package charten.ant.entites.custom;

import charten.ant.entites.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

import java.util.Objects;

public class MajorAntEntity extends AntEntity {

    private String activity;
    public MajorAntEntity(EntityType<? extends AntEntity> entityType, World world) {
        super(entityType, world);
        this.activity = "idle";
    }
    public MajorAntEntity(World world, int age, QueenAntEntity queenAnt) {
        super(ModEntities.MAJOR_ANT, world, age, queenAnt);
        this.activity = "idle";
    }

    @Override
    public boolean isMajor() {
        return true;
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

    public String getActivity() {
        return this.activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    @Override
    public void tick() {
        super.tick();
        if (this.getActivity().equals("royal_guard")) {
            this.moveToQueenAnt();
        }
    }
}
