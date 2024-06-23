package com.wildcard.buddycardsexp.integrations.malum;

import com.mojang.blaze3d.vertex.PoseStack;
import com.sammy.malum.client.screen.codex.ArcanaCodexHelper;
import com.sammy.malum.client.screen.codex.BookEntry;
import com.sammy.malum.client.screen.codex.ProgressionBookScreen;
import com.sammy.malum.client.screen.codex.objects.EntryObject;
import com.wildcard.buddycardsexp.BuddycardsExpansions;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

public class BuddycardsRiteEntryObject extends EntryObject {
    static final ResourceLocation BUDDYCARDS_FRAME_TEXTURE = new ResourceLocation(BuddycardsExpansions.MOD_ID, "textures/gui/book/frame.png");

    public BuddycardsRiteEntryObject(BookEntry entry, int posX, int posY) {
        super(entry, posX, posY);
    }

    @Override
    public void render(Minecraft minecraft, PoseStack poseStack, float xOffset, float yOffset, int mouseX, int mouseY, float partialTicks) {
        int posX = this.offsetPosX(xOffset);
        int posY = this.offsetPosY(yOffset);
        ArcanaCodexHelper.renderTransparentTexture(ProgressionBookScreen.FADE_TEXTURE, poseStack, posX - 13, posY - 13, 1.0F, 252.0F, 58, 58, 512, 512);
        ArcanaCodexHelper.renderTexture(BUDDYCARDS_FRAME_TEXTURE, poseStack, posX, posY, 0, 0, this.width, this.height,32, 32);
        ArcanaCodexHelper.renderTexture(ProgressionBookScreen.FRAME_TEXTURE, poseStack, posX, posY, 100.0F, (float)this.getBackgroundTextureV(), this.width, this.height, 512, 512);
        ArcanaCodexHelper.renderRiteIcon(MalumIntegration.RITE, poseStack, this.entry.isSoulwood, posX + 8, posY + 8);
    }
}
