package com.wildcard.buddycardsexp.util;

import com.wildcard.buddycards.block.entity.CardDisplayBlockEntity;
import com.wildcard.buddycards.core.BuddycardSet;
import com.wildcard.buddycards.item.BuddycardItem;
import com.wildcard.buddycards.registries.BuddycardsItems;
import com.wildcard.buddycardsexp.BuddycardsExpansions;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class RegistryHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BuddycardsExpansions.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BuddycardsExpansions.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, BuddycardsExpansions.MOD_ID);
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BuddycardsExpansions.MOD_ID);
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, BuddycardsExpansions.MOD_ID);

    public static void registerAll() {
        RegistryHandler.registerCards(CREATE_SET, 1, 12, Rarity.COMMON, BuddycardsItems.DEFAULT_CARD_PROPERTIES, CREATE_REQUIREMENT);
        RegistryHandler.registerCards(CREATE_SET, 13, 9, Rarity.UNCOMMON, BuddycardsItems.DEFAULT_CARD_PROPERTIES, CREATE_REQUIREMENT);
        RegistryHandler.registerCards(CREATE_SET, 22, 4, Rarity.RARE, BuddycardsItems.DEFAULT_CARD_PROPERTIES, CREATE_REQUIREMENT);
        RegistryHandler.registerCards(CREATE_SET, 26, 2, Rarity.EPIC, BuddycardsItems.DEFAULT_CARD_PROPERTIES, CREATE_REQUIREMENT);
        RegistryHandler.registerCards(AQUACULTURE_SET, 1, 7, Rarity.COMMON, BuddycardsItems.DEFAULT_CARD_PROPERTIES, AQUACULTURE_REQUIREMENT);
        RegistryHandler.registerCards(AQUACULTURE_SET, 8, 6, Rarity.UNCOMMON, BuddycardsItems.DEFAULT_CARD_PROPERTIES, AQUACULTURE_REQUIREMENT);
        RegistryHandler.registerCards(AQUACULTURE_SET, 14, 3, Rarity.RARE, BuddycardsItems.DEFAULT_CARD_PROPERTIES, AQUACULTURE_REQUIREMENT);
        RegistryHandler.registerCards(AQUACULTURE_SET, 17, 2, Rarity.EPIC, BuddycardsItems.DEFAULT_CARD_PROPERTIES, AQUACULTURE_REQUIREMENT);
        RegistryHandler.registerCards(FARMERS_SET, 1, 7, Rarity.COMMON, BuddycardsItems.DEFAULT_CARD_PROPERTIES, FARMERS_REQUIREMENT);
        RegistryHandler.registerCards(FARMERS_SET, 8, 6, Rarity.UNCOMMON, BuddycardsItems.DEFAULT_CARD_PROPERTIES, FARMERS_REQUIREMENT);
        RegistryHandler.registerCards(FARMERS_SET, 14, 3, Rarity.RARE, BuddycardsItems.DEFAULT_CARD_PROPERTIES, FARMERS_REQUIREMENT);
        RegistryHandler.registerCards(FARMERS_SET, 17, 2, Rarity.EPIC, BuddycardsItems.DEFAULT_CARD_PROPERTIES, FARMERS_REQUIREMENT);
        RegistryHandler.registerCards(MALUM_SET, 1, 7, Rarity.COMMON, BuddycardsItems.DEFAULT_CARD_PROPERTIES, MALUM_REQUIREMENT);
        RegistryHandler.registerCards(MALUM_SET, 8, 6, Rarity.UNCOMMON, BuddycardsItems.DEFAULT_CARD_PROPERTIES, MALUM_REQUIREMENT);
        RegistryHandler.registerCards(MALUM_SET, 14, 3, Rarity.RARE, BuddycardsItems.DEFAULT_CARD_PROPERTIES, MALUM_REQUIREMENT);
        RegistryHandler.registerCards(MALUM_SET, 17, 2, Rarity.EPIC, BuddycardsItems.DEFAULT_CARD_PROPERTIES, MALUM_REQUIREMENT);

        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Item> SHREDDED_BUDDYCARD = ITEMS.register("shredded_buddycard", () -> new Item(BuddycardsItems.DEFAULT_PROPERTIES));
    //Sets
    public static final BuddycardSet CREATE_SET = new BuddycardSet("create");
    public static final BuddycardSet AQUACULTURE_SET = new BuddycardSet("aquaculture");
    public static final BuddycardSet FARMERS_SET = new BuddycardSet("farmers");
    public static final BuddycardSet MALUM_SET = new BuddycardSet("malum");
    //Requirements
    public static final BuddycardsItems.BuddycardRequirement CREATE_REQUIREMENT = () -> ModList.get().isLoaded("create");
    public static final BuddycardsItems.BuddycardRequirement AQUACULTURE_REQUIREMENT = () -> ModList.get().isLoaded("aquaculture");
    public static final BuddycardsItems.BuddycardRequirement FARMERS_REQUIREMENT = () -> ModList.get().isLoaded("farmersdelight");
    public static final BuddycardsItems.BuddycardRequirement MALUM_REQUIREMENT = () -> ModList.get().isLoaded("malum");

    //Card registration
    public static void registerCards(BuddycardSet set, int startValue, int amount, Rarity rarity, Item.Properties properties, BuddycardsItems.BuddycardRequirement requirement) {
        Objects.requireNonNull(set);
        for (int i = startValue; i < amount + startValue; i++) {
            ITEMS.register("buddycard_" + set.getName() + i, new BuddycardItem(requirement, set, i, rarity, properties).delegate);
        }
    }
}
