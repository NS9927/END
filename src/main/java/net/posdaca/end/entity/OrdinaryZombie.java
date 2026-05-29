package net.posdaca.end.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.posdaca.end.entity.ai.OrdinaryZombieAI;

public class OrdinaryZombie extends Zombie {
    public OrdinaryZombie(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        OrdinaryZombieAI.init(this);
    }
}
