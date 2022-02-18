package com.wildcard.buddycardsexp.integrations.aquaculture;

import com.teammetallurgy.aquaculture.api.fishing.Hook;
import com.wildcard.buddycards.block.BuddycardBoosterBoxBlock;
import com.wildcard.buddycards.item.*;
import com.wildcard.buddycards.registries.BuddycardsBlocks;
import com.wildcard.buddycards.registries.BuddycardsItems;
import com.wildcard.buddycardsexp.integrations.aquaculture.CardfishItem;
import com.wildcard.buddycardsexp.util.ExtendedMedalTypes;
import com.wildcard.buddycardsexp.util.RegistryHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;

public class AquacultureIntegration {
    public static void init() {
        BOOSTER_BOX = RegistryHandler.BLOCKS.register("buddycard_booster_box_aquaculture", () -> new BuddycardBoosterBoxBlock(RegistryHandler.AQUACULTURE_REQUIREMENT, BuddycardsBlocks.BOOSTER_BOX_PROPERTIES));
        PACK = RegistryHandler.ITEMS.register("buddycard_pack_aquaculture", () -> new BuddycardSetPackItem(RegistryHandler.AQUACULTURE_REQUIREMENT, RegistryHandler.AQUACULTURE_SET, 3, 1, BuddycardsItems.DEFAULT_RARITY_WEIGHTS, BuddycardsItems.DEFAULT_PACK_PROPERTIES));
        BINDER = RegistryHandler.ITEMS.register("buddycard_binder_aquaculture", () -> new BuddycardBinderItem(RegistryHandler.AQUACULTURE_REQUIREMENT, BuddycardsItems.DEFAULT_BINDER_PROPERTIES));
        MEDAL = RegistryHandler.ITEMS.register("buddysteel_medal_aquaculture", () -> new BuddysteelSetMedalItem(RegistryHandler.AQUACULTURE_REQUIREMENT, ExtendedMedalTypes.AQUACULTURE_SET, RegistryHandler.AQUACULTURE_SET, BuddycardsItems.DEFAULT_MEDAL_PROPERTIES));
        BOOSTER_BOX_ITEM = RegistryHandler.ITEMS.register("buddycard_booster_box_aquaculture", () -> new BuddycardBoosterBoxItem(BOOSTER_BOX.get(), PACK, BuddycardsItems.DEFAULT_UNCOMMON_PROPERTIES));

        HOOK = new Hook.HookBuilder("buddysteel").setModID("buddycardsexp").setColor(ChatFormatting.AQUA).setDurabilityChance(0.20).build();
        CARDFISH = RegistryHandler.ITEMS.register("cardfish", CardfishItem::new);
    }

    public static RegistryObject<CardfishItem> CARDFISH;
    public static Hook HOOK;

    public static RegistryObject<BuddycardPackItem> PACK;
    public static RegistryObject<BuddycardBinderItem> BINDER;
    public static RegistryObject<BuddysteelSetMedalItem> MEDAL;
    public static RegistryObject<BuddycardBoosterBoxBlock> BOOSTER_BOX;
    public static RegistryObject<BuddycardBoosterBoxItem> BOOSTER_BOX_ITEM;
}
