package net.posdaca.end.tab;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTabs;
import net.posdaca.end.item.ModNewItem;

public class ModNewItemTab {
    public static void registerNewItemTab(CreateRegistrate registrate) {
        registrate.defaultCreativeTab("new_item_tab", builder -> builder
                        .title(Component.translatable("end.NewItemTab"))
                        .withTabsBefore(CreativeModeTabs.COMBAT)
                        .icon(() -> ModNewItem.STEEL_WIRE.asStack()))
                .register();
        ModNewItem.registerNewItems(registrate);
    }
}
