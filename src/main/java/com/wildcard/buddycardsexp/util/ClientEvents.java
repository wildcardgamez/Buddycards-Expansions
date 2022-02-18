package com.wildcard.buddycardsexp.util;

import com.sammy.malum.client.renderer.block.TotemPoleRenderer;
import com.wildcard.buddycards.client.renderer.CardDisplayBlockRenderer;
import com.wildcard.buddycards.registries.BuddycardsEntities;
import com.wildcard.buddycardsexp.BuddycardsExpansions;
import com.wildcard.buddycardsexp.integrations.farmersdelight.FarmersDelightIntegration;
import com.wildcard.buddycardsexp.integrations.malum.MalumIntegration;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = BuddycardsExpansions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        if(ModList.get().isLoaded("farmersdelight"))
            event.enqueueWork(() -> ItemBlockRenderTypes.setRenderLayer(FarmersDelightIntegration.BUDDYBEANS.get(), RenderType.cutout()));
    }

    @SubscribeEvent
    public static void setItemColors(ColorHandlerEvent.Item event) {
        if(ModList.get().isLoaded("malum"))
            event.getItemColors().register((a, b) -> 10021119, MalumIntegration.SPIRIT_ITEM.get());
    }

    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        if(ModList.get().isLoaded("malum"))
            event.registerBlockEntityRenderer(MalumIntegration.TOTEMS.get(), TotemPoleRenderer::new);
    }
}
