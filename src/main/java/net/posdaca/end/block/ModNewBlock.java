package net.posdaca.end.block;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;

public class ModNewBlock {
    public static BlockEntry<IronBarsBlock> BARRED_WIRE;

    public static void registerNewBlocks(CreateRegistrate registrate) {
        BARRED_WIRE = registrate.block("new_block/barred_wire_block", IronBarsBlock::new)
                .initialProperties(() -> Blocks.IRON_BARS)
                .simpleItem()
                .register();
    }
}
