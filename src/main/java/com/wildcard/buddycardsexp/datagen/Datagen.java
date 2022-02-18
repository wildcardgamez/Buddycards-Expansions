package com.wildcard.buddycardsexp.datagen;

import com.wildcard.buddycardsexp.BuddycardsExpansions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = BuddycardsExpansions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Datagen {
    @SubscribeEvent
    static void onGatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(new CardModelGen(event.getGenerator(), BuddycardsExpansions.MOD_ID, event.getExistingFileHelper()));
    }
}
