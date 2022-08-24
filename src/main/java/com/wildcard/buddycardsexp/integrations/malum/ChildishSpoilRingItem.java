package com.wildcard.buddycardsexp.integrations.malum;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.sammy.malum.common.item.equipment.curios.MalumCurioItem;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class ChildishSpoilRingItem extends MalumCurioItem {
    private static final UUID ATTRIBUTE_UUID = UUID.fromString("eb349588-6811-11ec-90d6-0242ac120003");
    public ChildishSpoilRingItem(Properties builder, double odds) {
        super(builder);
        ODDS = odds;
    }

    private final double ODDS;

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(String identifier, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = HashMultimap.create();
        map.put(MalumIntegration.CHILDISH_SPOIL.get(), new AttributeModifier(ATTRIBUTE_UUID, "Curio childish spoils", ODDS, AttributeModifier.Operation.ADDITION));
        return map;
    }

    @Override
    public boolean isOrnate() {
        return true;
    }
}