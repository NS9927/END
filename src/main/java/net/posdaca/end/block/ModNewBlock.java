package net.posdaca.end.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.posdaca.end.END;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.posdaca.end.item.ModCompatibleItem;

public class ModNewBlock {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(END.MOD_ID);

    public static final DeferredBlock<IronBarsBlock> BARRED_WIRE =
            registerBlocks("barred_wire_block", () -> new IronBarsBlock(Block.Properties.ofFullCopy(Blocks.IRON_BARS)));//铁丝网

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModCompatibleItem.ITEMS.register(name, () -> new BlockItem(block.get(), new net.minecraft.world.item.Item.Properties()));
    }
    private static <T extends Block> DeferredBlock<T> registerBlocks(String name, java.util.function.Supplier<T> block) {
        DeferredBlock<T> blocks = BLOCKS.register(name, block);
        registerBlockItem(name, blocks);
        return blocks;
    }
}
