package com.wildcard.buddycardsexp.util;

import com.wildcard.buddycards.item.IMedalTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import vectorwing.farmersdelight.common.registry.ModEffects;

public enum ExtendedMedalTypes implements IMedalTypes {
    CREATE_SET((player, mod) -> {
        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, mod, true, false));
    }),
    AQUACULTURE_SET((player, mod) -> {
        player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 300, mod - 1, true, false));
        if(player.isUnderWater() && mod > 0) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, mod - 1, true, false));
            if(mod > 1)
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, mod - 1, true, false));
        }
    }),
    FARMERS_SET((player, mod) -> {
        player.addEffect(new MobEffectInstance(ModEffects.NOURISHMENT.get(), 300, mod, true, false));
        if(mod > 0) {
            player.addEffect(new MobEffectInstance(ModEffects.COMFORT.get(), 300, mod, true, false));
            if (mod > 1)
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, mod, true, false));
        }
    }),
    MALUM_SET((player, mod) -> {
        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, mod, true, false));
    });

    ExtendedMedalTypes(MedalEffect effect) {
        this.effect = effect;
    }
    private final MedalEffect effect;

    @Override
    public void applyEffect(Player player, int mod) {
        effect.applyEffect(player, mod);
    }

    interface MedalEffect {
        void applyEffect(Player player, int mod);
    }
}
