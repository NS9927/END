package net.posdaca.end.item;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class ModNewItem {
    public static ItemEntry<Item> STEEL_WIRE;

    public static void registerNewItems(CreateRegistrate registrate) {
        STEEL_WIRE = registrate.item("steel_wire", Item::new).register();
    }
}
