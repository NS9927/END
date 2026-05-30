package net.posdaca.end.entity.zombie;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

//鹰眼丧尸，看得更远，信号覆盖更广
public class HawkeyeZombieMod extends ModBaseZombie {

    //玩家检测半径
    private static final double DETECT_RANGE = 25.0;

    //信号传播半径
    private static final double SIGNAL_RANGE = 20.0;

    public HawkeyeZombieMod(EntityType<? extends Zombie> entityType, Level level) {
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
