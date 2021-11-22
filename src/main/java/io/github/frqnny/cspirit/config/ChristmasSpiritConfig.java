package io.github.frqnny.cspirit.config;

import draylar.omegaconfig.api.Comment;
import draylar.omegaconfig.api.Config;

public class ChristmasSpiritConfig implements Config {
    public WorldGen worldGen = new WorldGen();
    public Misc misc = new Misc();

    @Override
    public String getName() {
        return "cspirit/main-config-file";
    }

    public static class WorldGen {
        @Comment("This option allows you to turn off the world freezer, so it does not snow or generate with snow")
        public boolean freezeWorld = true;
        @Comment("this option freezes oceans")
        public boolean freezeOceans = false;
    }

    public static class Misc {
        @Comment("1 in x chance when a zombie or skeleton spawns to give them clothing and a present. Range is 0 - 256")
        public int mobArmorRarity = 50;
        @Comment("When false, any Naughty Item in a player's inventory will be deleted.")
        public boolean naughtyItems = true;
        @Comment("When false, can't fly.")
        public boolean reindeerFlying = true;
        @Comment("The higher the value is, the more frequent it spawns.")
        public int reindeerSpawnWeight = 1;
    }
}
