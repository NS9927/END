package net.posdaca.end.register;

import net.neoforged.bus.api.IEventBus;
import net.posdaca.end.tab.ModCompatibleItemTab;
import net.posdaca.end.tab.ModNewBlockTab;
import net.posdaca.end.tab.ModNewItemTab;

public class ModTabRegister {
    public static void register(IEventBus eventBus) {
        ModNewBlockTab.CREATIVE_MODE_TABS.register(eventBus);
        ModCompatibleItemTab.CREATIVE_MODE_TABS.register(eventBus);
        ModNewItemTab.CREATIVE_MODE_TABS.register(eventBus);

        eventBus.addListener(ModNewBlockTab::addItemsToTab);
        eventBus.addListener(ModCompatibleItemTab::addItemsToTab);
        eventBus.addListener(ModNewItemTab::addItemsToTab);
    }
}
