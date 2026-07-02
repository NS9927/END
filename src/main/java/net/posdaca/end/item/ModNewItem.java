package net.posdaca.end.item;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class ModNewItem {
    public static ItemEntry<Item> SULFUR_POWDER;
    public static ItemEntry<Item> ANDESITE_POWDER;
    public static ItemEntry<Item> STEEL_WIRE;

    public static void registerNewItems(CreateRegistrate registrate) {
        //钢丝
        STEEL_WIRE = registrate.item("new_item/steel_wire", Item::new).register();
        //硫磺粉
        SULFUR_POWDER = registrate.item("new_item/sulfur_powder", Item::new).register();
        //安山岩粉
        ANDESITE_POWDER = registrate.item("new_item/andesite_powder", Item::new).register();
    }
}
