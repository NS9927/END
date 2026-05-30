package net.posdaca.end.entity.zombie;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.EnumSet;
import java.util.List;

public abstract class BaseSignalZombie extends Zombie {

    private int signalCooldown = 0;

    protected abstract double getDetectRange();
    protected abstract double getSignalRange();

    public BaseSignalZombie(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new BaseZombieAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(1, new SignalAndChaseGoal());
    }

    @Override
    public void tick() {
        super.tick();
        if (signalCooldown > 0) {
            signalCooldown--;
        }
    }

    private static class BaseZombieAttackGoal extends MeleeAttackGoal {
        public BaseZombieAttackGoal(BaseSignalZombie zombie, double speedModifier, boolean followingTargetEvenIfNotSeen) {
            super(zombie, speedModifier, followingTargetEvenIfNotSeen);
        }
    }

    private class SignalAndChaseGoal extends Goal {
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

            double detectRange = getDetectRange();
            Player nearestPlayer = level().getNearestPlayer(BaseSignalZombie.this, detectRange);
            if (nearestPlayer == null) return;

            setTarget(nearestPlayer);

            double signalRange = getSignalRange();
            List<BaseSignalZombie> nearbyZombies = level().getEntitiesOfClass(
                    BaseSignalZombie.class,
                    getBoundingBox().inflate(signalRange),
                    other -> other != BaseSignalZombie.this && other.getTarget() == null
            );

            for (BaseSignalZombie other : nearbyZombies) {
                other.setTarget(nearestPlayer);
            }

            signalCooldown = COOLDOWN_TICKS;
        }
    }
}
