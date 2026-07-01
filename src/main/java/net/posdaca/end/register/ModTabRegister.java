package net.posdaca.end.register;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.neoforged.bus.api.IEventBus;
import net.posdaca.end.tab.*;

public class ModTabRegister {
    public static void register(IEventBus modEventBus) {
        CreateRegistrate registrate = ModRegistrate.REGISTRATE;
        registrate.registerEventListeners(modEventBus);

        ModNewItemTab.registerNewItemTab(registrate);
        ModNewBlockTab.registerNewBlockTab(registrate);
        ModCreateBlockTab.registerCreateTab(registrate);
        ModEggItemTab.registerEggItemTab(registrate);
    }
}
