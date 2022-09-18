package com.wildcard.buddycardsexp.integrations.malum;

import com.sammy.malum.core.setup.content.SpiritTypeRegistry;
import com.sammy.malum.core.systems.rites.AuraRiteEffect;
import com.sammy.malum.core.systems.rites.MalumRiteEffect;
import com.sammy.malum.core.systems.rites.MalumRiteType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;

import java.util.function.Supplier;

public class ChildishRiteType extends MalumRiteType {
    public ChildishRiteType() {
        super("childish_rite", SpiritTypeRegistry.ARCANE_SPIRIT, MalumIntegration.SPIRIT, MalumIntegration.SPIRIT);
    }

    public MalumRiteEffect getNaturalRiteEffect() {
        return new ChildishAuraRiteEffect(MalumIntegration.AURA);
    }

    public MalumRiteEffect getCorruptedEffect() {
        return new ChildishAuraRiteEffect(MalumIntegration.CORRUPTED_AURA);
    }

    public static class ChildishAuraRiteEffect extends AuraRiteEffect {
        public ChildishAuraRiteEffect(Supplier<MobEffect> effect) {
            super(LivingEntity.class, effect, MalumIntegration.SPIRIT);
        }

        @Override
        public int getEffectAmplifier() {
            return 0;
        }
    }
}
