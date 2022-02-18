package com.wildcard.buddycardsexp;

import com.wildcard.buddycardsexp.integrations.aquaculture.AquacultureEvents;
import com.wildcard.buddycardsexp.integrations.aquaculture.AquacultureIntegration;
import com.wildcard.buddycardsexp.integrations.CreateIntegration;
import com.wildcard.buddycardsexp.integrations.farmersdelight.FarmersDelightIntegration;
import com.wildcard.buddycardsexp.integrations.malum.MalumIntegration;
import com.wildcard.buddycardsexp.integrations.malum.MalumEvents;
import com.wildcard.buddycardsexp.util.RegistryHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod("buddycardsexp")
public class BuddycardsExpansions
{
    public static final String MOD_ID = "buddycardsexp";

    public BuddycardsExpansions() {
        if(ModList.get().isLoaded("create"))
            CreateIntegration.init();
        if(ModList.get().isLoaded("aquaculture")) {
            AquacultureIntegration.init();
            MinecraftForge.EVENT_BUS.register(new AquacultureEvents());
        }
        if(ModList.get().isLoaded("farmersdelight"))
            FarmersDelightIntegration.init();
        if(ModList.get().isLoaded("malum")) {
            MalumIntegration.init();
            MinecraftForge.EVENT_BUS.register(new MalumEvents());
        }

        RegistryHandler.registerAll();
        MinecraftForge.EVENT_BUS.register(this);
    }

}
