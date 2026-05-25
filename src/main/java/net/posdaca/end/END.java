package net.posdaca.end;

import net.posdaca.end.register.ModBlockRegister;
import net.posdaca.end.register.ModItemRegister;
import net.posdaca.end.register.ModTabRegister;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
@Mod(END.MOD_ID)
public class END {
    public static final String MOD_ID = "end";
    public static final Logger LOGGER = LogUtils.getLogger();

    public END(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModBlockRegister.register(modEventBus);
        ModItemRegister.register(modEventBus);
        ModTabRegister.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
}
