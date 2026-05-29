package net.posdaca.end.item;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class ModCompatibleItem {
    public static ItemEntry<Item> SULFUR_POWDER;
    public static ItemEntry<Item> ANDESITE_POWDER;

    public static void registerCompatibleItems(CreateRegistrate registrate) {
        SULFUR_POWDER = registrate.item("sulfur_powder", Item::new).register();
        ANDESITE_POWDER = registrate.item("andesite_powder", Item::new).register();
    }
}
