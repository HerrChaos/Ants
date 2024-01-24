package charten.ant.entites.custom;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class AntEntity extends PathAwareEntity {

    private static final TrackedData<Integer> AGE = DataTracker.registerData(AntEntity.class, TrackedDataHandlerRegistry.INTEGER);;
    public AntEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean isQueen() {
        return false;
    }

    public boolean canBeLeashedBy(PlayerEntity player) {
        return false;
    }
    public boolean cannotDespawn() {
        return true;
    }


}
