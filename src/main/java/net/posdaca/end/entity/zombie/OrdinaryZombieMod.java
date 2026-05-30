package net.posdaca.end.entity.zombie;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.posdaca.end.register.ModEntityRegister;

//普通丧尸，检测半径15格，信号传播半径15格
public class OrdinaryZombieMod extends ModBaseZombie {

    //普通丧尸的实体类型注册
    public static final DeferredHolder<EntityType<?>, EntityType<OrdinaryZombieMod>> REGISTRY =
            ModEntityRegister.ENTITY_TYPES.register("ordinary_zombie",
                    () -> EntityType.Builder.of(OrdinaryZombieMod::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.95f)
                            .clientTrackingRange(8)
                            .build("ordinary_zombie"));

    //玩家检测半径
    private static final double DETECT_RANGE = 15.0;

    //信号传播半径
    private static final double SIGNAL_RANGE = 15.0;

    public OrdinaryZombieMod(EntityType<? extends Zombie> entityType, Level level) {
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
