package com.wildcard.buddycardsexp.integrations.aquaculture;

import com.wildcard.buddycards.item.BuddycardSetPackItem;
import com.wildcard.buddycards.registries.BuddycardsItems;
import com.wildcard.buddycardsexp.util.RegistryHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CardfishItem extends BuddycardSetPackItem {
    public CardfishItem() {
        super(RegistryHandler.AQUACULTURE_REQUIREMENT, RegistryHandler.AQUACULTURE_SET, 1, 0, BuddycardsItems.DEFAULT_RARITY_WEIGHTS, BuddycardsItems.DEFAULT_PROPERTIES);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(new TranslatableComponent(getDescriptionId() + ".desc").withStyle(ChatFormatting.GRAY));
    }
}
