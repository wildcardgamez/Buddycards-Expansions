package com.wildcard.buddycardsexp.integrations.malum;

import com.sammy.malum.client.screen.codex.BookEntry;
import com.sammy.malum.client.screen.codex.ProgressionBookScreen;
import com.sammy.malum.client.screen.codex.objects.RiteEntryObject;
import com.sammy.malum.client.screen.codex.pages.*;
import com.sammy.malum.common.events.SetupMalumCodexEntriesEvent;
import com.sammy.malum.compability.tetra.TetraCompat;
import com.sammy.malum.core.helper.SpiritHelper;
import com.sammy.malum.core.setup.content.SpiritRiteRegistry;
import com.sammy.malum.core.setup.content.item.ItemRegistry;
import com.sammy.malum.core.setup.content.item.ItemTagRegistry;
import com.wildcard.buddycards.registries.BuddycardsItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;

public class MalumEvents {
    @SubscribeEvent
    public void onEntityKill(LivingDeathEvent event) {
        if(event.getSource().getEntity() instanceof LivingEntity source && source.getAttributeValue(MalumIntegration.CHILDISH_SPOIL.get()) > 0) {
            ItemStack weapon = source.getMainHandItem();
            if (weapon.m_204117_(ItemTagRegistry.SOUL_HUNTER_WEAPON) || TetraCompat.LOADED && TetraCompat.LoadedOnly.hasSoulStrike(weapon)) {
                if(event.getEntityLiving() instanceof Monster entity && entity.isBaby()) {
                    ArrayList<ItemStack> spirits = new ArrayList<>();
                    double childishSpoil = source.getAttributeValue(MalumIntegration.CHILDISH_SPOIL.get()) - entity.getRandom().nextFloat();
                    while(childishSpoil > 0) {
                        spirits.add(new ItemStack(MalumIntegration.SPIRIT_ITEM.get()));
                        childishSpoil -= 1;
                    }
                    spirits.add(new ItemStack(MalumIntegration.SPIRIT_ITEM.get()));
                    SpiritHelper.createSpiritEntities(spirits, entity, source);
                }
            }
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void setupCodex(SetupMalumCodexEntriesEvent event) {
        ProgressionBookScreen.ENTRIES.add((new BookEntry("childish_ring", MalumIntegration.CHILDISH_RING.get(), -4, 0))
                .setObjectSupplier(BuddycardsEntryObject::new)
                .addPage(new HeadlineTextPage("childish_ring", "childish_ring"))
                .addPage(CraftingBookPage.ringPage(MalumIntegration.CHILDISH_RING.get(), Items.LEATHER, BuddycardsItems.BUDDYSTEEL_INGOT.get()))
                .addPage(SpiritInfusionPage.fromOutput(MalumIntegration.YOUTHFUL_RING.get())));
        ProgressionBookScreen.ENTRIES.add((new BookEntry("childish_spirit", MalumIntegration.SPIRIT_ITEM.get(), -3, -1))
                .setObjectSupplier(BuddycardsEntryObject::new)
                .addPage(new HeadlineTextItemPage("childish_spirit", "childish_spirit_a", MalumIntegration.SPIRIT_ITEM.get()))
                .addPage(new TextPage("childish_spirit_b")));
        ProgressionBookScreen.ENTRIES.add((new BookEntry("buddycard_set", MalumIntegration.PACK.get(), -2, -2))
                .setObjectSupplier(BuddycardsEntryObject::new)
                .addPage(new HeadlineTextPage("buddycard_set", "buddycard_set"))
                .addPage(SpiritInfusionPage.fromOutput(MalumIntegration.PACK.get())));
        ProgressionBookScreen.ENTRIES.add((new BookEntry("childish_rite", MalumIntegration.SPIRIT_ITEM.get(), -4, -2))
                .setObjectSupplier(BuddycardsRiteEntryObject::new).setDark()
                .addPage(new SpiritRiteTextPage(MalumIntegration.RITE, "childish_rite"))
                .addPage(new SpiritRiteRecipePage(MalumIntegration.RITE))
                .addPage(new SpiritRiteTextPage(MalumIntegration.ELDRITCH_RITE, "childish_rite.greater"))
                .addPage(new SpiritRiteRecipePage(MalumIntegration.ELDRITCH_RITE)));
        ProgressionBookScreen.ENTRIES.add((new BookEntry("corrupt_childish_rite", MalumIntegration.SPIRIT_ITEM.get(), -5, -2))
                .setObjectSupplier(BuddycardsRiteEntryObject::new).setSoulwood().setDark()
                .addPage(new SpiritRiteTextPage(MalumIntegration.RITE, "corrupt_childish_rite"))
                .addPage(new SpiritRiteRecipePage(MalumIntegration.RITE))
                .addPage(new SpiritRiteTextPage(MalumIntegration.ELDRITCH_RITE, "corrupt_childish_rite.greater"))
                .addPage(new SpiritRiteRecipePage(MalumIntegration.ELDRITCH_RITE)));

    }
}
