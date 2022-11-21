package io.github.frqnny.cspirit.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;

@Mixin(Biome.class)
public interface BiomeMixin {
    @Accessor
    Category getCategory();
}
