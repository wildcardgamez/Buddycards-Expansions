package com.wildcard.buddycardsexp.integrations.malum;

import com.sammy.malum.common.block.totem.TotemPoleBlock;
import com.sammy.malum.core.systems.spirit.MalumSpiritType;
import com.wildcard.buddycardsexp.BuddycardsExpansions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;

public class ChildishSpiritType extends MalumSpiritType {
    public ChildishSpiritType() {
        super("childish", MalumIntegration.SPIRIT_COLOR, MalumIntegration.SPIRIT_ITEM);
    }

    @Override
    public BlockState getBlockState(boolean isCorrupt, BlockHitResult hit) {
        Block base = !isCorrupt ? MalumIntegration.TOTEM.get() : MalumIntegration.CORRUPTED_TOTEM.get();
        return base.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, hit.getDirection()).setValue(TotemPoleBlock.SPIRIT_TYPE, 0);
    }

    @Override
    public ResourceLocation getOverlayTexture() {
        return new ResourceLocation(BuddycardsExpansions.MOD_ID, "block/childish_glow");
    }
}
