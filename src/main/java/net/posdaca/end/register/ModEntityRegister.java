package net.posdaca.end.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.posdaca.end.END;
import net.posdaca.end.entity.zombie.HawkeyeZombieMod;
import net.posdaca.end.entity.zombie.OrdinaryZombieMod;

//实体注册中心
public class ModEntityRegister {

    //实体注册表
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, END.MOD_ID);

    //注册实体类型和属性创建事件
    public static void register(IEventBus modEventBus) {
        //提前加载实体类，确保 REGISTRY 在绑定事件总线前完成注册
        OrdinaryZombieMod.REGISTRY.hashCode();
        HawkeyeZombieMod.REGISTRY.hashCode();

        ENTITY_TYPES.register(modEventBus);
        modEventBus.addListener(ModEntityRegister::onEntityAttributeCreation);
    }

    //注册实体属性
    private static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(OrdinaryZombieMod.REGISTRY.get(), OrdinaryZombieMod.createAttributes().build());
        event.put(HawkeyeZombieMod.REGISTRY.get(), HawkeyeZombieMod.createAttributes().build());
    }
}
