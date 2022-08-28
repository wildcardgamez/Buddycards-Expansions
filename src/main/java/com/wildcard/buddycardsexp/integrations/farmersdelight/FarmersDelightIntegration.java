package com.wildcard.buddycardsexp.integrations.farmersdelight;

import com.wildcard.buddycards.Buddycards;
import com.wildcard.buddycards.block.BuddycardBoosterBoxBlock;
import com.wildcard.buddycards.item.*;
import com.wildcard.buddycards.registries.BuddycardsBlocks;
import com.wildcard.buddycards.registries.BuddycardsItems;
import com.wildcard.buddycardsexp.util.ExtendedMedalTypes;
import com.wildcard.buddycardsexp.util.RegistryHandler;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class FarmersDelightIntegration {
    public static void init() {
        BOOSTER_BOX = RegistryHandler.BLOCKS.register("buddycard_booster_box_farmers", () -> new BuddycardBoosterBoxBlock(RegistryHandler.FARMERS_REQUIREMENT, BuddycardsBlocks.BOOSTER_BOX_PROPERTIES));
        PACK = RegistryHandler.ITEMS.register("buddycard_pack_farmers", FarmersBuddycardPackItem::new);
        BINDER = RegistryHandler.ITEMS.register("buddycard_binder_farmers", () -> new BuddycardBinderItem(RegistryHandler.FARMERS_REQUIREMENT, BuddycardsItems.DEFAULT_BINDER_PROPERTIES));
        MEDAL = RegistryHandler.ITEMS.register("buddysteel_medal_farmers", () -> new BuddysteelSetMedalItem(RegistryHandler.FARMERS_REQUIREMENT, ExtendedMedalTypes.FARMERS_SET, RegistryHandler.FARMERS_SET, BuddycardsItems.DEFAULT_CURIO_PROPERTIES));
        BOOSTER_BOX_ITEM = RegistryHandler.ITEMS.register("buddycard_booster_box_farmers", () -> new BuddycardBoosterBoxItem(BOOSTER_BOX.get(), PACK, BuddycardsItems.DEFAULT_UNCOMMON_PROPERTIES));

        BUDDYBEANS = RegistryHandler.BLOCKS.register("buddybeans", () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.POTATOES)));
        BUDDYBEANS_ITEM = RegistryHandler.ITEMS.register("buddybeans", () ->  new BlockItem(BUDDYBEANS.get(), new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2F).build()).tab(Buddycards.TAB)));
        BUDDYBEAN_CRATE = RegistryHandler.BLOCKS.register("buddybean_crate", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
        BUDDYBEAN_CRATE_ITEM = RegistryHandler.ITEMS.register("buddybean_crate", () ->  new BlockItem(BUDDYBEAN_CRATE.get(), new Item.Properties().tab(Buddycards.TAB)));
        DICED_BUDDYBEANS = RegistryHandler.ITEMS.register("diced_buddybeans", () -> new Item(new Item.Properties().tab(Buddycards.TAB)));
        BUDDYBEAN_PASTE = RegistryHandler.ITEMS.register("buddybean_paste", () -> new Item(new Item.Properties().tab(Buddycards.TAB).craftRemainder(Items.BOWL)));
        BUDDYGUMMIES = RegistryHandler.ITEMS.register("buddygummies", () -> new Item(new Item.Properties().tab(Buddycards.TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2F).fast().build())));
        BUDDYBEAN_PIE_SLICE = RegistryHandler.ITEMS.register("buddybean_pie_slice", () -> new Item((new Item.Properties()).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.5F).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0F).build()).tab(Buddycards.TAB)));
        BUDDYCOOKIE = RegistryHandler.ITEMS.register("buddycookie", () ->  new Item((new Item.Properties()).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build()).tab(Buddycards.TAB)));
        BUDDYBEAN_PIE = RegistryHandler.BLOCKS.register("buddybean_pie", () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), BUDDYBEAN_PIE_SLICE));
        BUDDYBEAN_PIE_ITEM = RegistryHandler.ITEMS.register("buddybean_pie", () -> new BlockItem(BUDDYBEAN_PIE.get(), new Item.Properties().tab(Buddycards.TAB)));
    }

    public static RegistryObject<Block> BUDDYBEANS;
    public static RegistryObject<BlockItem> BUDDYBEANS_ITEM;
    public static RegistryObject<Block> BUDDYBEAN_CRATE;
    public static RegistryObject<BlockItem> BUDDYBEAN_CRATE_ITEM;
    public static RegistryObject<Item> DICED_BUDDYBEANS;
    public static RegistryObject<Item> BUDDYBEAN_PASTE;
    public static RegistryObject<Item> BUDDYGUMMIES;
    public static RegistryObject<Item> BUDDYCOOKIE;
    public static RegistryObject<Item> BUDDYBEAN_PIE_SLICE;
    public static RegistryObject<Block> BUDDYBEAN_PIE;
    public static RegistryObject<BlockItem> BUDDYBEAN_PIE_ITEM;

    public static RegistryObject<BuddycardPackItem> PACK;
    public static RegistryObject<BuddycardBinderItem> BINDER;
    public static RegistryObject<BuddysteelSetMedalItem> MEDAL;
    public static RegistryObject<BuddycardBoosterBoxBlock> BOOSTER_BOX;
    public static RegistryObject<BuddycardBoosterBoxItem> BOOSTER_BOX_ITEM;
}
