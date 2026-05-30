package net.posdaca.end.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.posdaca.end.END;
import net.posdaca.end.entity.zombie.HawkeyeZombieMod;
import net.posdaca.end.entity.zombie.OrdinaryZombieMod;

//实体注册中心
public class ModEntityRegister {

    //实体注册表
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, END.MOD_ID);

    //普通丧尸
    public static final DeferredHolder<EntityType<?>, EntityType<OrdinaryZombieMod>> ORDINARY_ZOMBIE =
            ENTITY_TYPES.register("ordinary_zombie",
                    () -> EntityType.Builder.of(OrdinaryZombieMod::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.95f)
                            .clientTrackingRange(8)
                            .build("ordinary_zombie"));

    //鹰眼丧尸
    public static final DeferredHolder<EntityType<?>, EntityType<HawkeyeZombieMod>> HAWKEYE_ZOMBIE =
            ENTITY_TYPES.register("hawkeye_zombie",
                    () -> EntityType.Builder.of(HawkeyeZombieMod::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.95f)
                            .clientTrackingRange(8)
                            .build("hawkeye_zombie"));

    public static void register(IEventBus modEventBus) {
        ENTITY_TYPES.register(modEventBus);
        modEventBus.addListener(ModEntityRegister::onEntityAttributeCreation);
    }

    //注册实体属性
    private static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(ORDINARY_ZOMBIE.get(), OrdinaryZombieMod.createAttributes().build());
        event.put(HAWKEYE_ZOMBIE.get(), HawkeyeZombieMod.createAttributes().build());
    }
}
