package com.wildcard.buddycardsexp.util;

import com.wildcard.buddycardsexp.BuddycardsExpansions;
import com.wildcard.buddycardsexp.integrations.malum.MalumIntegration;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BuddycardsExpansions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributeHandler {
    @SubscribeEvent
    public static void modifyEntityAttributes(EntityAttributeModificationEvent event) {
        event.getTypes().forEach(e -> {
            if(ModList.get().isLoaded("malum"))
                event.add(e, MalumIntegration.CHILDISH_SPOIL.get());
        });
    }
}
