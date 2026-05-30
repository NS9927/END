package net.posdaca.end.entity.zombie;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.List;

public abstract class ModBaseZombie extends Zombie {

    //最大追逐半径，超过后放弃目标
    private static final double MAX_CHASE_DISTANCE = 50.0;

    //信号冷却计数器
    private int signalCooldown = 0;

    //检测半径（由子类决定）
    protected abstract double getDetectRange();

    //信号传播半径（由子类决定）
    protected abstract double getSignalRange();

    public ModBaseZombie(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new BaseZombieAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(1, new SignalAndChaseGoal());
    }

    //白天点不着
    @Override
    public boolean isSunBurnTick() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        if (signalCooldown > 0) {
            signalCooldown--;
        }
        //超出最大追逐半径则放弃目标
        LivingEntity target = getTarget();
        if (target != null && distanceToSqr(target) > MAX_CHASE_DISTANCE * MAX_CHASE_DISTANCE) {
            setTarget(null);
        }
    }

    private static class BaseZombieAttackGoal extends MeleeAttackGoal {
        public BaseZombieAttackGoal(ModBaseZombie zombie, double speedModifier, boolean followingTargetEvenIfNotSeen) {
            super(zombie, speedModifier, followingTargetEvenIfNotSeen);
        }
    }

    //信号与追踪AI
    private class SignalAndChaseGoal extends Goal {
        //信号发送冷却（tick），1秒发送一次
        private static final int COOLDOWN_TICKS = 20;

        public SignalAndChaseGoal() {
        }

        @Override
        public boolean canUse() {
            return true;
        }

        @Override
        public void tick() {
            if (signalCooldown > 0) return;

            double detectRange = getDetectRange();
            Player nearestPlayer = level().getNearestPlayer(ModBaseZombie.this, detectRange);
            if (nearestPlayer == null) return;

            setTarget(nearestPlayer);

            double signalRange = getSignalRange();
            //向范围内所有没有目标的同族发送信号，通知它们一起追逐
            List<ModBaseZombie> nearbyZombies = level().getEntitiesOfClass(
                    ModBaseZombie.class,
                    getBoundingBox().inflate(signalRange),
                    other -> other != ModBaseZombie.this && other.getTarget() == null
            );

            for (ModBaseZombie other : nearbyZombies) {
                other.setTarget(nearestPlayer);
            }

            signalCooldown = COOLDOWN_TICKS;
        }
    }
}
