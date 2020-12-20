package io.github.frqnny.cspirit.init;

import io.github.frqnny.cspirit.data.DailyPresentDataFile;
import io.github.frqnny.cspirit.util.PresentHelper;
import io.github.frqnny.cspirit.util.TimeHelper;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModEvents {

    public static void init() {
        ServerEntityEvents.ENTITY_LOAD.register(
                ((entity, serverWorld) -> {
                    if (entity instanceof ServerPlayerEntity) {
                        if (DailyPresentDataFile.areDailyGiftsEnabled() && !DailyPresentDataFile.hasReceivedPreset((ServerPlayerEntity) entity)) {
                            PresentHelper.giveSantaPresent((ServerPlayerEntity) entity, TimeHelper.getCurrentDay() - 1);
                        }
                    }
                })
        );
    }
}
