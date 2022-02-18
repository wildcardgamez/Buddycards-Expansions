package com.wildcard.buddycardsexp.integrations.farmersdelight;

import com.wildcard.buddycards.item.BuddycardItem;
import com.wildcard.buddycards.item.BuddycardPackItem;
import com.wildcard.buddycards.item.BuddycardSetPackItem;
import com.wildcard.buddycards.registries.BuddycardsItems;
import com.wildcard.buddycards.savedata.BuddycardCollectionSaveData;
import com.wildcard.buddycardsexp.util.RegistryHandler;
import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemHandlerHelper;

public class FarmersBuddycardPackItem extends BuddycardSetPackItem {
    public FarmersBuddycardPackItem() {
        super(RegistryHandler.FARMERS_REQUIREMENT, RegistryHandler.FARMERS_SET, 3, 1, BuddycardsItems.DEFAULT_RARITY_WEIGHTS, BuddycardsItems.DEFAULT_PROPERTIES);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level instanceof ServerLevel) {
            super.use(level, player, hand);
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(FarmersDelightIntegration.BUDDYGUMMIES.get()));
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
