package net.posdaca.end.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.posdaca.end.END;
import net.posdaca.end.entity.ModZombieEntity;

public class ModEntityRegister {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, END.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<ModZombieEntity>> ORDINARY_ZOMBIE =
            ENTITY_TYPES.register("ordinary_zombie",
                    () -> EntityType.Builder.of(ModZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.95f)
                            .clientTrackingRange(8)
                            .build("ordinary_zombie"));

    public static void register(IEventBus modEventBus) {
        ENTITY_TYPES.register(modEventBus);
        modEventBus.addListener(ModEntityRegister::onEntityAttributeCreation);
    }

    private static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(ORDINARY_ZOMBIE.get(), ModZombieEntity.createAttributes().build());
    }
}
