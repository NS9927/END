package net.posdaca.end.tab;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTabs;
import net.posdaca.end.block.ModNewBlock;

public class ModNewBlockTab {
    public static void registerNewBlockTab(CreateRegistrate registrate) {
        registrate.defaultCreativeTab("new_block_tab", builder -> builder
                        .title(Component.translatable("end.NewBlockTab"))
                        .withTabsBefore(CreativeModeTabs.COMBAT)
                        .icon(() -> ModNewBlock.BARRED_WIRE.asStack()))
                .register();
        ModNewBlock.registerNewBlocks(registrate);
    }
}
