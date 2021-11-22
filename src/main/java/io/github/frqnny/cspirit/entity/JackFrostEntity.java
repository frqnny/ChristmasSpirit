package io.github.frqnny.cspirit.entity;

import io.github.frqnny.cspirit.data.NaughtyListFile;
import io.github.frqnny.cspirit.init.ModEntityTypes;
import io.github.frqnny.cspirit.init.ModItems;
import io.github.frqnny.cspirit.util.ItemHelper;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class JackFrostEntity extends PathAwareEntity implements Angerable {

    private static final UniformIntProvider randomTime = TimeHelper.betweenSeconds(20, 39);
    private int attackTimer;
    private int angerTime;
    private UUID angerTarget;

    public JackFrostEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.FROSTMOURNE));

    }

    public JackFrostEntity(World world, int x, int y, int z) {
        super(ModEntityTypes.JACK_FROST_ENTITY, world);
        this.refreshPositionAndAngles(x, y, z, 0, 0);
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.FROSTMOURNE));
    }

    public static DefaultAttributeContainer.Builder createJackFrostAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 60D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.41D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(2, new WanderNearTargetGoal(this, 0.9D, 32.0F));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(2, new RevengeGoal(this));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAngerAt));
        this.targetSelector.add(4, new UniversalAngerGoal<>(this, false));
    }

    @Override
    public void tickMovement() {
        super.tickMovement();

        if (world.isDay()) {
            addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 20, 4));
        } else {
            addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 20));
            addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 20));
        }

        if (getY() > 300) {
            remove(RemovalReason.DISCARDED);
        }

        if (this.attackTimer > 0) {
            --this.attackTimer;
        }

        if (!this.world.isClient) {
            this.tickAngerLogic((ServerWorld) this.world, true);
        }

        if (!world.isClient) {

            if (angerTarget != null && world.getPlayerByUuid(angerTarget) != null) {
                if (NaughtyListFile.isOnNaughtyList(Objects.requireNonNull(world.getPlayerByUuid(angerTarget)))) {
                    angerTarget = null;
                }
            }

            int radius = 35;

            List<PlayerEntity> closePlayers = world.getEntitiesByClass(PlayerEntity.class, new Box(getPos().getX() - radius, getPos().getY() - radius, getPos().getZ() - radius, getPos().getX() + radius, getPos().getY() + radius, getPos().getZ() + radius), (player) -> true);

            for (PlayerEntity player : closePlayers) {

                if (!NaughtyListFile.isOnNaughtyList(player)) {
                    angerTarget = player.getUuid();
                    break;
                }
            }
        }
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!world.isClient) {

            if (hand == Hand.OFF_HAND) {
                return ActionResult.FAIL;
            }

            if (NaughtyListFile.isOnNaughtyList(player)) {

                if (getEquippedStack(EquipmentSlot.OFFHAND).isEmpty()) {

                    ItemStack heldStack = player.getMainHandStack();

                    if (heldStack.getItem() == ModItems.LUMP_OF_COAL) {

                        if (heldStack.getCount() >= 5) {

                            Random random = new Random();
                            ItemHelper.spawnStack(world, getX(), getY(), getZ(), (random.nextDouble() / 2) - 0.25D, 0.2D, (random.nextDouble() / 2) - 0.25D, new ItemStack(ModItems.FROST_INGOT));

                            heldStack.decrement(5);

                            return ActionResult.SUCCESS;
                        }
                    }
                }
            }
        }

        return ActionResult.FAIL;
    }

    @Override
    public int getAngerTime() {
        return angerTime;
    }

    @Override
    public void setAngerTime(int ticks) {
        this.angerTime = ticks;
    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return this.angerTarget;
    }

    @Override
    public void setAngryAt(@Nullable UUID uuid) {
        this.angerTarget = uuid;
    }

    @Override
    public void chooseRandomAngerTime() {
        this.angerTime = randomTime.get(this.random);
    }

    @Override
    public boolean shouldAngerAt(LivingEntity entity) {
        if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(entity)) {
            return false;
        } else {
            return entity.getType() == EntityType.PLAYER && this.isUniversallyAngry(entity.world) || entity.getUuid().equals(this.angerTarget);
        }
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PILLAGER_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PILLAGER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PILLAGER_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_ZOMBIE_STEP, 0.15F, 1);
    }

    @Override
    protected int getXpToDrop(PlayerEntity player) {
        return 40;
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }
}
