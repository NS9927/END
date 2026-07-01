package net.posdaca.end.block;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;

public class ModNewBlock {
    public static BlockEntry<IronBarsBlock> WIRE_FENCE_BLOCK;

    public static void registerNewBlocks(CreateRegistrate registrate) {
        //铁丝栅栏
        WIRE_FENCE_BLOCK = registrate.block("new_block/wire_fence_block", IronBarsBlock::new)
                .initialProperties(() -> Blocks.IRON_BARS)
                .simpleItem()
                .register();
    }
}

