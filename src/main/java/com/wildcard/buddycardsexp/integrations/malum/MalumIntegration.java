package com.wildcard.buddycardsexp.integrations.malum;

import com.sammy.malum.common.item.spirit.MalumSpiritItem;
import com.sammy.malum.core.setup.content.SpiritRiteRegistry;
import com.sammy.malum.core.setup.content.SpiritTypeRegistry;
import com.sammy.malum.core.setup.content.block.BlockRegistry;
import com.sammy.malum.core.setup.content.item.tabs.MalumSplinterTab;
import com.sammy.malum.core.systems.rites.MalumRiteType;
import com.sammy.malum.core.systems.spirit.MalumSpiritType;
import com.sammy.malum.core.systems.spirit.SpiritTypeProperty;
import com.wildcard.buddycards.Buddycards;
import com.wildcard.buddycards.block.BuddycardBoosterBoxBlock;
import com.wildcard.buddycards.block.CardDisplayBlock;
import com.wildcard.buddycards.item.BuddycardBinderItem;
import com.wildcard.buddycards.item.BuddycardBoosterBoxItem;
import com.wildcard.buddycards.item.BuddycardPackItem;
import com.wildcard.buddycards.item.BuddysteelSetMedalItem;
import com.wildcard.buddycards.registries.BuddycardsBlocks;
import com.wildcard.buddycards.registries.BuddycardsItems;
import com.wildcard.buddycardsexp.util.ExtendedMedalTypes;
import com.wildcard.buddycardsexp.util.RegistryHandler;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

import static com.wildcard.buddycards.registries.BuddycardsItems.DEFAULT_PROPERTIES;

public class MalumIntegration {
    public static void init() {
        BOOSTER_BOX = RegistryHandler.BLOCKS.register("buddycard_booster_box_malum", () -> new BuddycardBoosterBoxBlock(RegistryHandler.MALUM_REQUIREMENT, BuddycardsBlocks.BOOSTER_BOX_PROPERTIES));
        PACK = RegistryHandler.ITEMS.register("buddycard_pack_malum", MalumBuddycardPackItem::new);
        BINDER = RegistryHandler.ITEMS.register("buddycard_binder_malum", () -> new BuddycardBinderItem(RegistryHandler.MALUM_REQUIREMENT, BuddycardsItems.DEFAULT_BINDER_PROPERTIES));
        MEDAL = RegistryHandler.ITEMS.register("buddysteel_medal_malum", () -> new BuddysteelSetMedalItem(RegistryHandler.MALUM_REQUIREMENT, ExtendedMedalTypes.MALUM_SET, RegistryHandler.MALUM_SET, BuddycardsItems.DEFAULT_CURIO_PROPERTIES));
        BOOSTER_BOX_ITEM = RegistryHandler.ITEMS.register("buddycard_booster_box_malum", () -> new BuddycardBoosterBoxItem(BOOSTER_BOX.get(), PACK, BuddycardsItems.DEFAULT_UNCOMMON_PROPERTIES));

        RUNEWOOD_DISPLAY = RegistryHandler.BLOCKS.register("runewood_card_display", () -> new CardDisplayBlock(BlockRegistry.RUNEWOOD_PROPERTIES()));
        SOULWOOD_DISPLAY = RegistryHandler.BLOCKS.register("soulwood_card_display", () -> new CardDisplayBlock(BlockRegistry.SOULWOOD_PROPERTIES()));

        BuddycardsBlocks.DISPLAY_BLOCKS.add(RUNEWOOD_DISPLAY);
        BuddycardsBlocks.DISPLAY_BLOCKS.add(SOULWOOD_DISPLAY);

        RegistryHandler.ITEMS.register("runewood_card_display", () -> new BlockItem(RUNEWOOD_DISPLAY.get(), DEFAULT_PROPERTIES));
        RegistryHandler.ITEMS.register("soulwood_card_display", () -> new BlockItem(SOULWOOD_DISPLAY.get(), DEFAULT_PROPERTIES));

        SPIRIT_ITEM = RegistryHandler.ITEMS.register("childish_spirit", () -> new MalumSpiritItem(new Item.Properties().tab(MalumSplinterTab.INSTANCE), SPIRIT));
        SPIRIT = SpiritTypeRegistry.create("childish", SPIRIT_COLOR, SPIRIT_ITEM);
        SpiritTypeRegistry.SPIRIT_TYPE_PROPERTY = new SpiritTypeProperty("spirit_type", SpiritTypeRegistry.SPIRITS.values());

        CHILDISH_SPOIL = RegistryHandler.ATTRIBUTES.register("childish_spoils", () -> new RangedAttribute("attribute.name.buddycardsexp.childish_spoils", 0.0D, 0.0D, 2048.0D));
        CHILDISH_RING = RegistryHandler.ITEMS.register("childish_ring", () -> new ChildishSpoilRingItem(new Item.Properties().tab(Buddycards.TAB).stacksTo(1), 0.2));
        YOUTHFUL_RING = RegistryHandler.ITEMS.register("ring_of_youthful_spoil", () -> new ChildishSpoilRingItem(new Item.Properties().tab(Buddycards.TAB).stacksTo(1), 1.2));

        AURA = RegistryHandler.EFFECTS.register("childish_aura", ChildishAura::new);
        CORRUPTED_AURA = RegistryHandler.EFFECTS.register("corrupted_childish_aura", CorruptedChildishAura::new);
        RITE = SpiritRiteRegistry.create(new ChildishRiteType());
        ELDRITCH_RITE = SpiritRiteRegistry.create(new EldritchChildishRiteType());
    }

    public static RegistryObject<BuddycardPackItem> PACK;
    public static RegistryObject<BuddycardBinderItem> BINDER;
    public static RegistryObject<BuddysteelSetMedalItem> MEDAL;
    public static RegistryObject<BuddycardBoosterBoxBlock> BOOSTER_BOX;
    public static RegistryObject<BuddycardBoosterBoxItem> BOOSTER_BOX_ITEM;

    public static RegistryObject<CardDisplayBlock> RUNEWOOD_DISPLAY;
    public static RegistryObject<CardDisplayBlock> SOULWOOD_DISPLAY;

    public static final Color SPIRIT_COLOR = new Color(152, 232, 255);
    public static MalumSpiritType SPIRIT;
    public static RegistryObject<Item> SPIRIT_ITEM;

    public static RegistryObject<Attribute> CHILDISH_SPOIL;
    public static RegistryObject<Item> CHILDISH_RING;
    public static RegistryObject<Item> YOUTHFUL_RING;

    public static RegistryObject<MobEffect> AURA;
    public static RegistryObject<MobEffect> CORRUPTED_AURA;
    public static MalumRiteType RITE;
    public static MalumRiteType ELDRITCH_RITE;
}
