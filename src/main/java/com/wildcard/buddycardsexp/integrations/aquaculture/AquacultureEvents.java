package com.wildcard.buddycardsexp.integrations.aquaculture;

import com.teammetallurgy.aquaculture.item.AquaFishingRodItem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class AquacultureEvents {
    @SubscribeEvent
    public void onItemFished(ItemFishedEvent event) {
        ItemStack rod = event.getPlayer().getMainHandItem();
        if(!(rod.getItem() instanceof AquaFishingRodItem))
            rod = event.getPlayer().getOffhandItem();
        if(rod.getItem() instanceof AquaFishingRodItem && AquaFishingRodItem.getHookType(rod).equals(AquacultureIntegration.HOOK)) {
            Random rand = event.getPlayer().getLevel().random;
            if(rand.nextFloat() < .05) {
                ItemStack stack = new ItemStack(rand.nextFloat() < .4 ? AquacultureIntegration.PACK.get() : AquacultureIntegration.CARDFISH.get());
                ItemEntity itementity = new ItemEntity(event.getHookEntity().level, event.getHookEntity().getX(), event.getHookEntity().getY(), event.getHookEntity().getZ(), stack);
                double d0 = event.getPlayer().getX() - event.getHookEntity().getX();
                double d1 = event.getPlayer().getY() - event.getHookEntity().getY();
                double d2 = event.getPlayer().getZ() - event.getHookEntity().getZ();
                itementity.setDeltaMovement(d0 * 0.1D, d1 * 0.1D + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.08D, d2 * 0.1D);
                event.getHookEntity().level.addFreshEntity(itementity);
            }
        }
    }
}
