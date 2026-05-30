package net.posdaca.end.item;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.posdaca.end.entity.ModZombieEntity;

public class ModEggItem {

    public static ItemEntry<DeferredSpawnEggItem> ORDINARY_ZOMBIE_EGG;

    public static ItemEntry<DeferredSpawnEggItem> HAWKEYE_ZOMBIE_EGG;

    public static void registerEggItems(CreateRegistrate registrate) {
        //普通丧尸生物蛋
        ORDINARY_ZOMBIE_EGG = registrate.item("ordinary_zombie_spawn_egg", p ->
                        new DeferredSpawnEggItem(ModZombieEntity.ORDINARY_ZOMBIE, 0xC1B06D, 0x3B7929, p))
                .register();

        //鹰眼丧尸生物蛋
        HAWKEYE_ZOMBIE_EGG = registrate.item("hawkeye_zombie_spawn_egg", p ->
                        new DeferredSpawnEggItem(ModZombieEntity.HAWKEYE_ZOMBIE, 0x4A7B9D, 0x2D5A7A, p))
                .register();
    }
}
