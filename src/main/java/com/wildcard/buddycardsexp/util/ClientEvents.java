package com.wildcard.buddycardsexp.util;

import com.wildcard.buddycards.client.renderer.MedalRenderer;
import com.wildcard.buddycardsexp.BuddycardsExpansions;
import com.wildcard.buddycardsexp.integrations.CreateIntegration;
import com.wildcard.buddycardsexp.integrations.aquaculture.AquacultureIntegration;
import com.wildcard.buddycardsexp.integrations.farmersdelight.FarmersDelightIntegration;
import com.wildcard.buddycardsexp.integrations.malum.MalumIntegration;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = BuddycardsExpansions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        if(ModList.get().isLoaded("create"))
            CuriosRendererRegistry.register(CreateIntegration.MEDAL.get(), () -> new MedalRenderer(getDefaultMedalTexture("buddysteel_medal_create")));
        if(ModList.get().isLoaded("aquaculture2"))
            CuriosRendererRegistry.register(AquacultureIntegration.MEDAL.get(), () -> new MedalRenderer(getDefaultMedalTexture("buddysteel_medal_aquaculture")));
        if(ModList.get().isLoaded("farmersdelight")) {
            event.enqueueWork(() -> ItemBlockRenderTypes.setRenderLayer(FarmersDelightIntegration.BUDDYBEANS.get(), RenderType.cutout()));
            CuriosRendererRegistry.register(FarmersDelightIntegration.MEDAL.get(), () -> new MedalRenderer(getDefaultMedalTexture("buddysteel_medal_farmers")));
        }
        if(ModList.get().isLoaded("malum"))
            CuriosRendererRegistry.register(MalumIntegration.MEDAL.get(), () -> new MedalRenderer(getDefaultMedalTexture("buddysteel_medal_malum")));
    }

    @SubscribeEvent
    public static void setItemColors(ColorHandlerEvent.Item event) {
        if(ModList.get().isLoaded("malum"))
            event.getItemColors().register((a, b) -> 10021119, MalumIntegration.SPIRIT_ITEM.get());
    }

    protected static ResourceLocation getDefaultMedalTexture(String name) {
        return new ResourceLocation(BuddycardsExpansions.MOD_ID, "textures/models/medal/" + name + ".png");
    }
}
