package net.posdaca.end.tab;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTabs;
import net.posdaca.end.item.ModEggItem;

public class ModEggItemTab {
    public static void registerEggItemTab(CreateRegistrate registrate) {
        registrate.defaultCreativeTab("egg_item_tab", builder -> builder
                        .title(Component.translatable("end.EggItemTab"))
                        .withTabsBefore(CreativeModeTabs.COMBAT)
                        .icon(() -> ModEggItem.ORDINARY_ZOMBIE_EGG.asStack()))
                .register();
        ModEggItem.registerEggItems(registrate);
    }
}
