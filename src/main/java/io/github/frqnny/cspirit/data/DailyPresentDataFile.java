package io.github.frqnny.cspirit.data;

import com.google.gson.reflect.TypeToken;
import io.github.frqnny.cspirit.util.FileHelper;
import io.github.frqnny.cspirit.util.TimeHelper;
import net.minecraft.entity.player.PlayerEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DailyPresentDataFile {

    private static final UUID dailyGiftUUID = UUID.fromString("dc4787f8-2bac-11eb-adc1-0242ac120002");

    public static Map<UUID, Integer> receivedGiftList;

    public static void init() {
        Map<UUID, Integer> map = new HashMap<>();
        map.put(dailyGiftUUID, 0);
        receivedGiftList = FileHelper.readFileOrCreate("DailyPresentData", map, new TypeToken<Map<UUID, Integer>>() {
        });
    }

    public static void clearEntries() {
        receivedGiftList.clear();
        FileHelper.saveToFile("DailyPresentData", receivedGiftList);
    }

    public static boolean hasReceivedPreset(PlayerEntity player) {

        if (receivedGiftList.containsKey(player.getUuid())) {

            if (receivedGiftList.get(player.getUuid()).equals(TimeHelper.getCurrentDay())) {
                return true;
            } else receivedGiftList.replace(player.getUuid(), TimeHelper.getCurrentDay());
        }

        receivedGiftList.put(player.getUuid(), TimeHelper.getCurrentDay());
        FileHelper.saveToFile("DailyPresentData", receivedGiftList);

        return false;
    }

    public static void enableDailyGifts(boolean state) {
        receivedGiftList.clear();
        receivedGiftList.put(dailyGiftUUID, state ? 1 : 0);
        FileHelper.saveToFile("DailyPresentData", receivedGiftList);
    }

    public static boolean areDailyGiftsEnabled() {

        if (receivedGiftList.containsKey(dailyGiftUUID)) {
            return receivedGiftList.get(dailyGiftUUID) == 1;
        }

        return false;
    }
}
