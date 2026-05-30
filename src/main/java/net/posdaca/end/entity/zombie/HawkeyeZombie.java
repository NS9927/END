package net.posdaca.end.entity.zombie;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class HawkeyeZombie extends BaseSignalZombie {

    private static final double DETECT_RANGE = 25.0;
    private static final double SIGNAL_RANGE = 20.0;

    public HawkeyeZombie(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected double getDetectRange() {
        return DETECT_RANGE;
    }

    @Override
    protected double getSignalRange() {
        return SIGNAL_RANGE;
    }
}
