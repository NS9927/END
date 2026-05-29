package net.posdaca.end.tab;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.posdaca.end.block.ModCreateBlock;

public class ModCreateBlockTab {
    public static void registerCreateTab(CreateRegistrate registrate) {
        registrate.defaultCreativeTab("create_block_tab", builder -> builder
                        .withTabsBefore(ResourceLocation.fromNamespaceAndPath("end", "new_block_tab")))
                .register();
        ModCreateBlock.registerCreateBlocks(registrate);
    }
}
