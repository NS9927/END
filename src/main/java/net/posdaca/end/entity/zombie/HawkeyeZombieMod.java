package net.posdaca.end.entity.zombie;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.posdaca.end.register.ModEntityRegister;

//鹰眼丧尸，看得更远，检测半径25格，信号覆盖20格
public class HawkeyeZombieMod extends ModBaseZombie {

    //鹰眼丧尸的实体类型注册
    public static final DeferredHolder<EntityType<?>, EntityType<HawkeyeZombieMod>> REGISTRY =
            ModEntityRegister.ENTITY_TYPES.register("hawkeye_zombie",
                    () -> EntityType.Builder.of(HawkeyeZombieMod::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.95f)
                            .clientTrackingRange(8)
                            .build("hawkeye_zombie"));

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
