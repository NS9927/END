package net.posdaca.end.item;

import net.posdaca.end.END;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModNewItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(END.MOD_ID);
    public static final DeferredItem<Item> STEEL_WIRE = ITEMS.register("steel_wire", () -> new Item(new Item.Properties()));//钢丝
}
