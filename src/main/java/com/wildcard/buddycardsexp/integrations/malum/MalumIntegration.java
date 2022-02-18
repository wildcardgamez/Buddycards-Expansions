package com.wildcard.buddycardsexp.integrations.malum;

import com.sammy.malum.common.block.totem.TotemPoleBlock;
import com.sammy.malum.common.blockentity.totem.TotemPoleTileEntity;
import com.sammy.malum.common.item.spirit.MalumSpiritItem;
import com.sammy.malum.core.setup.block.BlockRegistry;
import com.sammy.malum.core.setup.content.SpiritRiteRegistry;
import com.sammy.malum.core.setup.content.SpiritTypeRegistry;
import com.sammy.malum.core.setup.item.tabs.MalumSplinterTab;
import com.sammy.malum.core.systems.rites.MalumRiteType;
import com.sammy.malum.core.systems.spirit.MalumSpiritType;
import com.wildcard.buddycards.Buddycards;
import com.wildcard.buddycards.block.BuddycardBoosterBoxBlock;
import com.wildcard.buddycards.item.*;
import com.wildcard.buddycards.registries.BuddycardsBlocks;
import com.wildcard.buddycards.registries.BuddycardsItems;
import com.wildcard.buddycardsexp.util.ExtendedMedalTypes;
import com.wildcard.buddycardsexp.util.RegistryHandler;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class MalumIntegration {
    public static void init() {
        BOOSTER_BOX = RegistryHandler.BLOCKS.register("buddycard_booster_box_malum", () -> new BuddycardBoosterBoxBlock(RegistryHandler.MALUM_REQUIREMENT, BuddycardsBlocks.BOOSTER_BOX_PROPERTIES));
        PACK = RegistryHandler.ITEMS.register("buddycard_pack_malum", MalumBuddycardPackItem::new);
        BINDER = RegistryHandler.ITEMS.register("buddycard_binder_malum", () -> new BuddycardBinderItem(RegistryHandler.MALUM_REQUIREMENT, BuddycardsItems.DEFAULT_BINDER_PROPERTIES));
        MEDAL = RegistryHandler.ITEMS.register("buddysteel_medal_malum", () -> new BuddysteelSetMedalItem(RegistryHandler.MALUM_REQUIREMENT, ExtendedMedalTypes.MALUM_SET, RegistryHandler.MALUM_SET, BuddycardsItems.DEFAULT_MEDAL_PROPERTIES));
        BOOSTER_BOX_ITEM = RegistryHandler.ITEMS.register("buddycard_booster_box_malum", () -> new BuddycardBoosterBoxItem(BOOSTER_BOX.get(), PACK, BuddycardsItems.DEFAULT_UNCOMMON_PROPERTIES));

        SPIRIT_ITEM = RegistryHandler.ITEMS.register("childish_spirit", () -> new MalumSpiritItem(new Item.Properties().tab(MalumSplinterTab.INSTANCE), SPIRIT));
        SPIRIT = new ChildishSpiritType();
        SpiritTypeRegistry.SPIRITS.add(SPIRIT);

        TOTEM = RegistryHandler.BLOCKS.register("childish_totem_pole", () -> new TotemPoleBlock(BlockRegistry.RUNEWOOD_PROPERTIES().noOcclusion(), BlockRegistry.RUNEWOOD_LOG, false));
        CORRUPTED_TOTEM = RegistryHandler.BLOCKS.register("corrupted_childish_totem_pole", () -> new TotemPoleBlock(BlockRegistry.SOULWOOD_PROPERTIES().noOcclusion(), BlockRegistry.SOULWOOD_LOG, true));
        TOTEMS = RegistryHandler.BLOCK_ENTITIES.register("childish_totem_pole", () -> BlockEntityType.Builder.of((a, b) -> new TotemPoleTileEntity(TOTEMS.get(), a, b), TOTEM.get(), CORRUPTED_TOTEM.get()).build(null));

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
    
    public static final Color SPIRIT_COLOR = new Color(152, 232, 255);
    public static MalumSpiritType SPIRIT;
    public static RegistryObject<Item> SPIRIT_ITEM;

    public static RegistryObject<Attribute> CHILDISH_SPOIL;
    public static RegistryObject<Item> CHILDISH_RING;
    public static RegistryObject<Item> YOUTHFUL_RING;

    public static RegistryObject<TotemPoleBlock> TOTEM;
    public static RegistryObject<TotemPoleBlock> CORRUPTED_TOTEM;
    public static RegistryObject<BlockEntityType<TotemPoleTileEntity>> TOTEMS;

    public static RegistryObject<MobEffect> AURA;
    public static RegistryObject<MobEffect> CORRUPTED_AURA;
    public static MalumRiteType RITE;
    public static MalumRiteType ELDRITCH_RITE;
}
