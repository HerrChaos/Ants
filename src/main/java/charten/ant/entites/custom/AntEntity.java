package charten.ant.entites.custom;

import charten.ant.entites.ModEntities;
import charten.ant.util.Collonie;
import charten.ant.util.GeneralUtil;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.data.client.Model;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;


public class AntEntity extends PathAwareEntity {
    public final AnimationState walkingAnimationState = new AnimationState();
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private UUID queenUUID;

    private int AGE;
    private float food;
    private final double movement_speed = 1;
    protected AntEntity(EntityType<? extends AntEntity> entityType, World world) {
        super(entityType, world);
        if (entityType == ModEntities.QUEEN_ANT) {
            this.food = 30;
        } else {
            this.food = 5;
        }
        this.AGE = 0;
    }

    public AntEntity(EntityType<? extends AntEntity> entityType, World world, int age, QueenAntEntity queenAnts) {
        super(entityType, world);
        this.food = 5;
        this.AGE = age;
        this.queenUUID = queenAnts.getUuid();
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(4, new WanderAroundGoal(this, this.getMovement_speed()));
        this.goalSelector.add(5, new LookAtEntityGoal(this, QueenAntEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAntAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.contains("food")) {
            this.food = nbt.getFloat("food");
        }
        if (nbt.contains("queen_ant")) {
            this.queenUUID = nbt.getUuid("queen_ant");
        }
        if (nbt.contains("age")) {
            this.AGE = nbt.getInt("age");
        }
        super.readCustomDataFromNbt(nbt);
    }
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putFloat("food", this.food);
        if (!this.isQueen() && this.getQueenUUID() != null) {
            nbt.putUuid("queen_ant", this.getQueenUUID());
        }
        nbt.putInt("age", this.AGE);
        super.writeCustomDataToNbt(nbt);
    }
    public final boolean canBeLeashedBy(PlayerEntity player) {
        return false;
    }
    public final boolean cannotDespawn() {
        return true;
    }
    public void setFood(float foody) {
        this.food = foody;
    }
    public float getFood() {
        return this.food;
    }
    public boolean isQueen() {
        return false;
    }
    public boolean isMajor() {
        return false;
    }
    public boolean isWorker() {
        return false;
    }
    public QueenAntEntity getQueen() {
        return this.getQueenBYUUID();
    }
    public QueenAntEntity getQueenBYUUID() {
        if (!this.getWorld().isClient()) {
            Entity queen = GeneralUtil.getEntityByUUID((ServerWorld) this.getWorld(), this.queenUUID);
            if (queen instanceof QueenAntEntity) {
                return (QueenAntEntity) queen;
            }
        }
        return null;
    }
    public UUID getQueenUUID() {
        return this.queenUUID;
    }
    public double getMovement_speed() {
        return this.movement_speed;
    }

    @Override
    protected void applyMovementEffects(BlockPos pos) {
        super.applyMovementEffects(pos);
        if (this.getWorld().isClient()) {

        }
        //this.setFood(this.getFood() - 0.01f);
    }
    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        if (!this.isQueen() && this.getQueen() != null) {
            this.getQueen().getCollonie().removeAnt(this.getUuid());
        }
    }

    public void moveToQueenAnt() {
        QueenAntEntity queenAnt = this.getQueen();

        if (queenAnt != null) {
            this.getNavigation().startMovingTo(queenAnt, this.movement_speed);
        }
    }

    @Override
    public void tick() {
        if(this.getWorld().isClient()) {
            SetupAnimationStates();
        }
        super.tick();
    }

    private void SetupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }
}
