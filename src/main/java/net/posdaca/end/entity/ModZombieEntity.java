package net.posdaca.end.entity;

import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.posdaca.end.entity.zombie.HawkeyeZombieMod;
import net.posdaca.end.entity.zombie.OrdinaryZombieMod;
import net.posdaca.end.register.ModEntityRegister;

//用于暴露实体类型的注册结果给其他模块引用
public class ModZombieEntity {

    //普通丧尸
    public static final DeferredHolder<EntityType<?>, EntityType<OrdinaryZombieMod>> ORDINARY_ZOMBIE =
            ModEntityRegister.ORDINARY_ZOMBIE;

    //鹰眼丧尸
    public static final DeferredHolder<EntityType<?>, EntityType<HawkeyeZombieMod>> HAWKEYE_ZOMBIE =
            ModEntityRegister.HAWKEYE_ZOMBIE;
}
