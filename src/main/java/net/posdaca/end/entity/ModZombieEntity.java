package net.posdaca.end.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.posdaca.end.register.ModEntityRegister;

import java.util.EnumSet;
import java.util.List;

public class ModZombieEntity extends Zombie {

    public static final DeferredHolder<EntityType<?>, EntityType<ModZombieEntity>> ORDINARY_ZOMBIE =
            (DeferredHolder) ModEntityRegister.ORDINARY_ZOMBIE;

    private int signalCooldown = 0;

    public ModZombieEntity(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new ModZombieAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(1, new SignalAndChaseGoal());
    }

    @Override
    public void tick() {
        super.tick();
        if (signalCooldown > 0) {
            signalCooldown--;
        }
    }

    private static class ModZombieAttackGoal extends MeleeAttackGoal {
        public ModZombieAttackGoal(ModZombieEntity zombie, double speedModifier, boolean followingTargetEvenIfNotSeen) {
            super(zombie, speedModifier, followingTargetEvenIfNotSeen);
        }
    }

    private class SignalAndChaseGoal extends Goal {
        private static final double RADIUS = 15.0;
        private static final int COOLDOWN_TICKS = 20;

        public SignalAndChaseGoal() {
            setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return true;
        }

        @Override
        public void tick() {
            if (signalCooldown > 0) return;

            Player nearestPlayer = level().getNearestPlayer(ModZombieEntity.this, RADIUS);
            if (nearestPlayer == null) return;

            setTarget(nearestPlayer);

            List<ModZombieEntity> nearbyZombies = level().getEntitiesOfClass(
                    ModZombieEntity.class,
                    getBoundingBox().inflate(RADIUS),
                    other -> other != ModZombieEntity.this && other.getTarget() == null
            );

            for (ModZombieEntity other : nearbyZombies) {
                other.setTarget(nearestPlayer);
            }

            signalCooldown = COOLDOWN_TICKS;
        }
    }
}
