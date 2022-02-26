package com.wildcard.buddycardsexp.integrations.malum;

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
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class MalumBuddycardPackItem extends BuddycardSetPackItem {
    double[][] rates = {{.6,.9,.975},{.5,.85,.95},{.45,.8,.925}};

    public MalumBuddycardPackItem() {
        super(RegistryHandler.MALUM_REQUIREMENT, RegistryHandler.MALUM_SET, 3, 1, BuddycardsItems.DEFAULT_RARITY_WEIGHTS, BuddycardsItems.DEFAULT_PACK_PROPERTIES);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level instanceof ServerLevel serverLevel) {
            int aura = 0, corruptedAura = 0;
            if(player.hasEffect(MalumIntegration.AURA.get()))
                aura += player.getEffect(MalumIntegration.AURA.get()).getAmplifier() + 1;
            if(player.hasEffect(MalumIntegration.CORRUPTED_AURA.get()))
                corruptedAura += player.getEffect(MalumIntegration.CORRUPTED_AURA.get()).getAmplifier() + 1;

            player.getItemInHand(hand).shrink(1);
            NonNullList<ItemStack> cards = NonNullList.create();
            for(int i = 0; i < 3 + corruptedAura; ++i) {
                ItemStack card = new ItemStack(this.rollCard(level.getRandom(), aura, corruptedAura));
                if (i >= 3 + corruptedAura - 1)
                    BuddycardItem.setShiny(card);
                cards.add(card);
            }
            cards.forEach((cardx) -> {
                ItemHandlerHelper.giveItemToPlayer(player, cardx);
                BuddycardCollectionSaveData.get(serverLevel).addPlayerCardFound(player.getUUID(), ((BuddycardItem)cardx.getItem()).getSet(), ((BuddycardItem)cardx.getItem()).getCardNumber());
            });
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    public BuddycardItem rollCard(Random random, int aura, int corruptedAura) {
        if(aura == 0 && corruptedAura == 0)
            return super.rollCard(random);
        float rand = random.nextFloat();
        Rarity rarity;
        if(corruptedAura >= aura)
            rarity = Rarity.COMMON;
        else if (rand < rates[aura][0])
            rarity = Rarity.COMMON;
        else if (rand < rates[aura][1])
            rarity = Rarity.UNCOMMON;
        else if (rand < rates[aura][3])
            rarity = Rarity.RARE;
        else
            rarity = Rarity.EPIC;
        return Optional.of(rarity)
                .map(this::getPossibleCards)
                .map(cards -> cards.get(random.nextInt(cards.size())))
                .orElseThrow(() -> new IllegalStateException("Cardpack " + getRegistryName() + " does not contain cards for rarity"));
    }
}
