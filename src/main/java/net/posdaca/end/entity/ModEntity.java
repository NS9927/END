package net.posdaca.end.entity;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.EntityEntry;
import net.minecraft.world.entity.MobCategory;

public class ModEntity {
    public static EntityEntry<OrdinaryZombie> ORDINARY_ZOMBIE;

    public static void registerEntities(CreateRegistrate registrate) {
        ORDINARY_ZOMBIE = registrate.entity("ordinary_zombie", OrdinaryZombie::new, MobCategory.MONSTER)
                .properties(b -> b.sized(0.6f, 1.95f).clientTrackingRange(8))
                .attributes(OrdinaryZombie::createAttributes)
                .register();
    }
}
