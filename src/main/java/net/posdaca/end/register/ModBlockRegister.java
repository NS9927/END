package net.posdaca.end.register;

import net.neoforged.bus.api.IEventBus;
import net.posdaca.end.block.ModNewBlock;

public class ModBlockRegister {
    public static void register(IEventBus  eventBus){
        ModNewBlock.BLOCKS.register(eventBus);
    }
}
