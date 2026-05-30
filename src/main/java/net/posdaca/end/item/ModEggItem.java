package net.posdaca.end.item;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.posdaca.end.entity.ModZombieEntity;

public class ModEggItem {
    public static ItemEntry<DeferredSpawnEggItem> ORDINARY_ZOMBIE_EGG;

    public static void registerEggItems(CreateRegistrate registrate) {
        ORDINARY_ZOMBIE_EGG = registrate.item("ordinary_zombie_spawn_egg", p ->
                        new DeferredSpawnEggItem(ModZombieEntity.ORDINARY_ZOMBIE, 0xC1B06D, 0x3B7929, p))
                .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), ResourceLocation.withDefaultNamespace("item/template_spawn_egg")))
                .register();
    }
}
