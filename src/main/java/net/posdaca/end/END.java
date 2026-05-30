package net.posdaca.end;

import com.mojang.logging.LogUtils;

import org.slf4j.Logger;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.posdaca.end.register.ModEntityRegister;
import net.posdaca.end.register.ModTabRegister;

@Mod(END.MOD_ID)
public class END {
    public static final String MOD_ID = "end";
    public static final Logger LOGGER = LogUtils.getLogger();

    public END(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        //注册创造模式标签页
        ModTabRegister.register(modEventBus);

        //注册实体类型和属性
        ModEntityRegister.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
}
