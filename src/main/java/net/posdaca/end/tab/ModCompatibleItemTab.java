package net.posdaca.end.tab;

import net.posdaca.end.END;
import net.posdaca.end.item.ModCompatibleItem;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCompatibleItemTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, END.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> END_ITEM_TAB = CREATIVE_MODE_TABS.register("end_compatible_item_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("end.CompatibleItemTab"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModCompatibleItem.SULFUR_POWDER.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
            }).build());

    public static void addItemsToTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == END_ITEM_TAB.getKey()) {
            event.accept(ModCompatibleItem.SULFUR_POWDER);
            event.accept(ModCompatibleItem.ANDESITE_POWDER);
        }
    }
}