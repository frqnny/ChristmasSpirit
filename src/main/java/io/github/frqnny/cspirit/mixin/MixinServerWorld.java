package io.github.frqnny.cspirit.mixin;

import io.github.frqnny.cspirit.data.JackFrostData;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ServerWorld.class)
public class MixinServerWorld implements JackFrostData {
    @Unique
    boolean canSpawnJackFrost = true;

    @Override
    public boolean canSpawnJackFrost() {
        return canSpawnJackFrost;
    }

    @Override
    public void setCanSpawnJackFrost(boolean canSpawnJackFrost) {
        this.canSpawnJackFrost = canSpawnJackFrost;
    }
}
