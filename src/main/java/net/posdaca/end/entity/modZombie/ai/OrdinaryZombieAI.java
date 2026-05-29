package net.posdaca.end.entity.modZombie.ai;

import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.posdaca.end.entity.modZombie.OrdinaryZombie;

public class OrdinaryZombieAI {
    public static void init(OrdinaryZombie zombie) {
        zombie.goalSelector.addGoal(2, new OrdinaryZombieAttackGoal(zombie, 1.0, false));
    }

    private static class OrdinaryZombieAttackGoal extends MeleeAttackGoal {
        public OrdinaryZombieAttackGoal(OrdinaryZombie zombie, double speedModifier, boolean followingTargetEvenIfNotSeen) {
            super(zombie, speedModifier, followingTargetEvenIfNotSeen);
        }
    }
}
