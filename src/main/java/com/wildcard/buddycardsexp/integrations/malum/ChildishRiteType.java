package com.wildcard.buddycardsexp.integrations.malum;

import com.sammy.malum.common.packets.particle.MagicParticlePacket;
import com.sammy.malum.core.setup.content.SpiritTypeRegistry;
import com.sammy.malum.core.setup.server.PacketRegistry;
import com.sammy.malum.core.systems.rites.MalumRiteType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PacketDistributor;

public class ChildishRiteType extends MalumRiteType {
    public ChildishRiteType() {
        super("childish_rite", SpiritTypeRegistry.ARCANE_SPIRIT, MalumIntegration.SPIRIT, MalumIntegration.SPIRIT);
    }

    public void riteEffect(Level level, BlockPos pos) {
        if (!level.isClientSide) {
            this.getNearbyEntities(Player.class, level, pos, false).forEach((e) -> {
                if (e.getEffect(MalumIntegration.AURA.get()) == null)
                    PacketRegistry.INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> e), new MagicParticlePacket(MalumIntegration.SPIRIT_COLOR, e.blockPosition().getX(), e.blockPosition().getY() + e.getBbHeight() / 2.0F, e.blockPosition().getZ()));
                e.addEffect(new MobEffectInstance(MalumIntegration.AURA.get(), 100, 0));
            });
        }
    }

    public void corruptedRiteEffect(Level level, BlockPos pos) {
        if (!level.isClientSide) {
            this.getNearbyEntities(Player.class, level, pos, false).forEach((e) -> {
                if (e.getEffect(MalumIntegration.CORRUPTED_AURA.get()) == null)
                    PacketRegistry.INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> e), new MagicParticlePacket(MalumIntegration.SPIRIT_COLOR, e.blockPosition().getX(), e.blockPosition().getY() + e.getBbHeight() / 2.0F, e.blockPosition().getZ()));
                e.addEffect(new MobEffectInstance(MalumIntegration.CORRUPTED_AURA.get(), 100, 0));
            });
        }
    }
}
