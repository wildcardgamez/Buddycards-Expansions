package com.wildcard.buddycardsexp.integrations;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.wildcard.buddycards.Buddycards;
import com.wildcard.buddycards.block.BuddycardBoosterBoxBlock;
import com.wildcard.buddycards.item.*;
import com.wildcard.buddycards.registries.BuddycardsBlocks;
import com.wildcard.buddycards.registries.BuddycardsItems;
import com.wildcard.buddycardsexp.util.ExtendedMedalTypes;
import com.wildcard.buddycardsexp.util.RegistryHandler;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class CreateIntegration {
    public static void init() {
        BOOSTER_BOX = RegistryHandler.BLOCKS.register("buddycard_booster_box_create", () -> new BuddycardBoosterBoxBlock(RegistryHandler.CREATE_REQUIREMENT, BuddycardsBlocks.BOOSTER_BOX_PROPERTIES));
        PACK = RegistryHandler.ITEMS.register("buddycard_pack_create", () -> new BuddycardSetPackItem(RegistryHandler.CREATE_REQUIREMENT, RegistryHandler.CREATE_SET, 4, 1, BuddycardsItems.DEFAULT_RARITY_WEIGHTS, BuddycardsItems.DEFAULT_PACK_PROPERTIES));
        BINDER = RegistryHandler.ITEMS.register("buddycard_binder_create", () -> new BuddycardBinderItem(RegistryHandler.CREATE_REQUIREMENT, BuddycardsItems.DEFAULT_BINDER_PROPERTIES, RegistryHandler.CREATE_SET));
        MEDAL = RegistryHandler.ITEMS.register("buddysteel_medal_create", () -> new BuddysteelSetMedalItem(RegistryHandler.CREATE_REQUIREMENT, ExtendedMedalTypes.CREATE_SET, RegistryHandler.CREATE_SET, BuddycardsItems.DEFAULT_CURIO_PROPERTIES));
        BOOSTER_BOX_ITEM = RegistryHandler.ITEMS.register("buddycard_booster_box_create", () -> new BuddycardBoosterBoxItem(BOOSTER_BOX.get(), PACK, BuddycardsItems.DEFAULT_UNCOMMON_PROPERTIES));

        RECYCLED_BUDDYCARD = RegistryHandler.ITEMS.register("recycled_buddycard", () -> new Item(new Item.Properties().tab(Buddycards.TAB)));
        UNFINISHED_PACK = RegistryHandler.ITEMS.register("unfinished_buddycard_pack", () -> new SequencedAssemblyItem(new Item.Properties().tab(Buddycards.TAB)));
    }

    public static RegistryObject<Item> RECYCLED_BUDDYCARD;
    public static RegistryObject<Item> UNFINISHED_PACK;

    public static RegistryObject<BuddycardPackItem> PACK;
    public static RegistryObject<BuddycardBinderItem> BINDER;
    public static RegistryObject<BuddysteelSetMedalItem> MEDAL;
    public static RegistryObject<BuddycardBoosterBoxBlock> BOOSTER_BOX;
    public static RegistryObject<BuddycardBoosterBoxItem> BOOSTER_BOX_ITEM;
}
