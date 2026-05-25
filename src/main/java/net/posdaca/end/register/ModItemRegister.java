package net.posdaca.end.register;

import net.neoforged.bus.api.IEventBus;
import net.posdaca.end.item.ModCompatibleItem;
import net.posdaca.end.item.ModNewItem;

public class ModItemRegister {
    public static void register(IEventBus eventBus){
        ModNewItem.ITEMS.register(eventBus);
        ModCompatibleItem.ITEMS.register(eventBus);
    }
}
