package net.posdaca.end.resourcepack;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.neoforge.event.AddPackFindersEvent;

public class ModResourcePack {
    public static void onAddPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            event.addPackFinders(
                    ResourceLocation.fromNamespaceAndPath("end", "resourcepacks/packI18ncn"),
                    PackType.CLIENT_RESOURCES,
                    Component.literal("整合包专用D老师精翻"),
                    PackSource.BUILT_IN,
                    true,
                    Pack.Position.TOP
            );
            event.addPackFinders(
                    ResourceLocation.fromNamespaceAndPath("end", "resourcepacks/huh"),
                    PackType.CLIENT_RESOURCES,
                    Component.literal("huh?"),
                    PackSource.BUILT_IN,
                    false,
                    Pack.Position.TOP
            );
        }
    }
}
