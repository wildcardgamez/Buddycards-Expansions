package com.wildcard.buddycardsexp.integrations.malum;

import com.mojang.blaze3d.vertex.PoseStack;
import com.sammy.malum.client.screen.codex.BookEntry;
import com.sammy.malum.client.screen.codex.ProgressionBookScreen;
import com.sammy.malum.client.screen.codex.objects.EntryObject;
import com.wildcard.buddycardsexp.BuddycardsExpansions;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

public class BuddycardsEntryObject extends EntryObject {
    static final ResourceLocation BUDDYCARDS_FRAME_TEXTURE = new ResourceLocation(BuddycardsExpansions.MOD_ID, "textures/gui/book/frame.png");

    public BuddycardsEntryObject(BookEntry entry, int posX, int posY) {
        super(entry, posX, posY);
    }

    @Override
    public void render(Minecraft minecraft, PoseStack poseStack, float xOffset, float yOffset, int mouseX, int mouseY, float partialTicks) {
        int posX = this.offsetPosX(xOffset);
        int posY = this.offsetPosY(yOffset);
        ProgressionBookScreen.renderTexture(BUDDYCARDS_FRAME_TEXTURE, poseStack, posX, posY, 0, 0, this.width, this.height,32, 32);
        minecraft.getItemRenderer().renderAndDecorateItem(this.entry.iconStack, posX + 8, posY + 8);
    }
}
