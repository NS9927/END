package net.posdaca.end;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.posdaca.end.register.ModEntityRegister;
import net.posdaca.end.resourcepack.ModResourcePack;

import java.util.Objects;

@Mod(value = END.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = END.MOD_ID, value = Dist.CLIENT)
public class ENDClient {

    public ENDClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        Objects.requireNonNull(container.getEventBus()).addListener(ModResourcePack::onAddPackFinders);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        END.LOGGER.info("HELLO FROM CLIENT SETUP");
        END.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityRegister.ORDINARY_ZOMBIE.get(), ZombieRenderer::new);
    }
}
