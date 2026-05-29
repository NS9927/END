package net.posdaca.end.entity.modZombie;

import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.posdaca.end.register.ModEntityRegister;

public class ModZombieEntity {
    public static final DeferredHolder<EntityType<?>, EntityType<OrdinaryZombie>> ORDINARY_ZOMBIE =
            ModEntityRegister.ORDINARY_ZOMBIE;
}
