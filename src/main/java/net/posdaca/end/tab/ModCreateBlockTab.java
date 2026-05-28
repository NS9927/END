package net.posdaca.end.tab;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTabs;
import net.posdaca.end.block.ModCreateBlock;
import net.posdaca.end.item.ModCompatibleItem;

public class ModCreateBlockTab {
    public static void registerCreateTab(CreateRegistrate registrate) {
        registrate.defaultCreativeTab("create_block_tab", builder -> builder
                        .title(Component.translatable("end.CreateBlockTab"))
                        .withTabsBefore(CreativeModeTabs.COMBAT)
                        .icon(() -> ModCompatibleItem.SULFUR_POWDER.asStack()))
                .register();
        ModCreateBlock.registerCreateBlocks(registrate);
    }
}
