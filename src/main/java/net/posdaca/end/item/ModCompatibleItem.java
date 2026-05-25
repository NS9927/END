package net.posdaca.end.item;

import net.posdaca.end.END;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCompatibleItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(END.MOD_ID);
    public static final DeferredItem<Item> SULFUR_POWDER = ITEMS.register("sulfur_powder", () -> new Item(new Item.Properties()));//硫磺粉
    public static final DeferredItem<Item> ANDESITE_POWDER = ITEMS.register("andesite_powder", () -> new Item(new Item.Properties()));//安山岩粉
}
