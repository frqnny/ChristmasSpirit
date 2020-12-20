package io.github.frqnny.cspirit.init;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.item.*;
import io.github.frqnny.cspirit.item.tier.CSArmorTiers;
import io.github.frqnny.cspirit.item.tier.FrostmourneItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
    //INGREDIENTS
    public static final Item FLOUR = new Item(new FabricItemSettings().group(ChristmasSpirit.BAKING));
    public static final Item ICING = new Item(new FabricItemSettings().group(ChristmasSpirit.BAKING));

    public static final Item FOOD_DYE_RED = new Item(new FabricItemSettings().group(ChristmasSpirit.BAKING));
    public static final Item FOOD_DYE_GREEN = new Item(new FabricItemSettings().group(ChristmasSpirit.BAKING));
    public static final Item FOOD_DYE_BLUE = new Item(new FabricItemSettings().group(ChristmasSpirit.BAKING));

    public static final Item PEPPERMINT_LEAF = new Item(new FabricItemSettings().group(ChristmasSpirit.BAKING));
    public static final Item PEPPERMINT_CANDY_MIX = new Item(new FabricItemSettings().group(ChristmasSpirit.BAKING));

    public static final Item SUGAR_COOKIE_DOUGH = new Item(new FabricItemSettings().group(ChristmasSpirit.BAKING));
    public static final Item SUGAR_COOKIE_SHEET = new Item(new FabricItemSettings().group(ChristmasSpirit.BAKING));
    public static final Item GINGER_GROUND = new Item(new FabricItemSettings().group(ChristmasSpirit.BAKING));
    public static final Item GINGERBREAD_DOUGH = new Item(new FabricItemSettings().group(ChristmasSpirit.BAKING));
    public static final Item GINGERBREAD_SHEET = new Item(new FabricItemSettings().group(ChristmasSpirit.BAKING));

    public static final Item COOKIE_CUTTER_CIRCLE = new CookieCutterItem(new FabricItemSettings().group(ChristmasSpirit.BAKING));
    public static final Item COOKIE_CUTTER_ORNAMENT = new CookieCutterItem(new FabricItemSettings().group(ChristmasSpirit.BAKING));
    public static final Item COOKIE_CUTTER_STAR = new CookieCutterItem(new FabricItemSettings().group(ChristmasSpirit.BAKING));
    public static final Item COOKIE_CUTTER_MAN = new CookieCutterItem(new FabricItemSettings().group(ChristmasSpirit.BAKING));
    public static final Item COOKIE_CUTTER_SNOWMAN = new CookieCutterItem(new FabricItemSettings().group(ChristmasSpirit.BAKING));

    public static final Item CHRISTMAS_LIGHT_WHITE = new BlockItem(ModBlocks.CHRISTMAS_LIGHTS_WHITE, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item CHRISTMAS_LIGHT_RED = new BlockItem(ModBlocks.CHRISTMAS_LIGHTS_RED, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item CHRISTMAS_LIGHT_GREEN = new BlockItem(ModBlocks.CHRISTMAS_LIGHTS_GREEN, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item CHRISTMAS_LIGHT_BLUE = new BlockItem(ModBlocks.CHRISTMAS_LIGHTS_BLUE, new FabricItemSettings().group(ChristmasSpirit.DECORATION));

    //FOOD
    public static final Item CHOCOLATE_BAR = new CSFoodItem(2, 0.2F, 1, false);
    public static final Item PEPPERMINT_BARK = new CSFoodItem(4, 0.3F, 2, false);
    public static final Item PEPPERMINT_CANDY_RED = new CSFoodItem(2, 0.4F, 2, false);
    public static final Item PEPPERMINT_CANDY_GREEN = new CSFoodItem(2, 0.4F, 2, false);
    public static final Item PEPPERMINT_CANDY_BLUE = new CSFoodItem(2, 0.4F, 2, false);

    public static final Item CANDY_CANE_RED = new CandyCaneItem(ModBlocks.CANDY_CANE_POST_RED, new FabricItemSettings().group(ChristmasSpirit.DECORATION).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.8F).alwaysEdible().build()));
    public static final Item CANDY_CANE_GREEN = new CandyCaneItem(ModBlocks.CANDY_CANE_POST_GREEN, new FabricItemSettings().group(ChristmasSpirit.DECORATION).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.8F).alwaysEdible().build()));
    public static final Item CANDY_CANE_BLUE = new CandyCaneItem(ModBlocks.CANDY_CANE_POST_BLUE, new FabricItemSettings().group(ChristmasSpirit.DECORATION).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.8F).alwaysEdible().build()));

    public static final Item SUGAR_COOKIE_SANTA = new SantaCookieItem(new FabricItemSettings().group(ChristmasSpirit.BAKING).food(new FoodComponent.Builder().hunger(12).saturationModifier(1.2F).alwaysEdible().build()));

    public static final Item SUGAR_COOKIE_CIRCLE = new CSFoodItem(5, 0.2F, 2, false);
    public static final Item SUGAR_COOKIE_ORNAMENT = new CSFoodItem(6, 0.3F, 2, false);
    public static final Item SUGAR_COOKIE_STAR = new CSFoodItem(7, 0.4F, 2, false);
    public static final Item SUGAR_COOKIE_MAN = new CSFoodItem(8, 0.5F, 3, false);
    public static final Item SUGAR_COOKIE_SNOWMAN = new CSFoodItem(9, 0.6F, 3, false);

    public static final Item GINGERBREAD_COOKIE_CIRCLE = new CSFoodItem(6, 0.3F, 2, false);
    public static final Item GINGERBREAD_COOKIE_ORNAMENT = new CSFoodItem(7, 0.4F, 2, false);
    public static final Item GINGERBREAD_COOKIE_STAR = new CSFoodItem(8, 0.5F, 2, false);
    public static final Item GINGERBREAD_COOKIE_MAN = new CSFoodItem(9, 0.6F, 3, false);
    public static final Item GINGERBREAD_COOKIE_SNOWMAN = new CSFoodItem(10, 0.6F, 3, false);

    public static final Item MUG_MILK = new CSFoodItem(3, 0.4F, 2, true);
    public static final Item MUG_HOT_CHOCOLATE = new CSFoodItem(6, 0.5F, 2, true);
    public static final Item MUG_EGGNOG = new CSFoodItem(6, 0.6F, 2, true);

    public static final Item SODA_COLA = new SodaItem(5, 0.4F);
    public static final Item SODA_GINGER_ALE = new SodaItem(6, 0.6F);
    public static final Item SODA_SPRITE_CRANBERRY = new SodaItem(8, 0.8F);

    //WEARABLES
    public static final Item CHRISTMAS_HAT = new ArmorItem(CSArmorTiers.CHRISTMAS_HAT, EquipmentSlot.HEAD, new FabricItemSettings().group(ChristmasSpirit.MAIN));
    public static final Item BEANIE_BLACK = new ArmorItem(CSArmorTiers.BEANIE_BLACK, EquipmentSlot.HEAD, new FabricItemSettings().group(ChristmasSpirit.MAIN));
    public static final Item BEANIE_RED = new ArmorItem(CSArmorTiers.BEANIE_RED, EquipmentSlot.HEAD, new FabricItemSettings().group(ChristmasSpirit.MAIN));
    public static final Item BEANIE_GREEN = new ArmorItem(CSArmorTiers.BEANIE_GREEN, EquipmentSlot.HEAD, new FabricItemSettings().group(ChristmasSpirit.MAIN));

    public static final Item SWEATER_BLACK = new ArmorItem(CSArmorTiers.SWEATER_BLACK, EquipmentSlot.CHEST, new FabricItemSettings().group(ChristmasSpirit.MAIN));
    public static final Item SWEATER_RED = new ArmorItem(CSArmorTiers.SWEATER_RED, EquipmentSlot.CHEST, new FabricItemSettings().group(ChristmasSpirit.MAIN));
    public static final Item SWEATER_GREEN = new ArmorItem(CSArmorTiers.SWEATER_GREEN, EquipmentSlot.CHEST, new FabricItemSettings().group(ChristmasSpirit.MAIN));

    public static final Item WINTER_JEANS = new ArmorItem(CSArmorTiers.WINTER_JEANS, EquipmentSlot.LEGS, new FabricItemSettings().group(ChristmasSpirit.MAIN));

    public static final Item WINTER_BOOTS = new ArmorItem(CSArmorTiers.WINTER_BOOTS, EquipmentSlot.FEET, new FabricItemSettings().group(ChristmasSpirit.MAIN));
    public static final Item ICE_SKATES = new ArmorItem(CSArmorTiers.ICE_SKATES, EquipmentSlot.FEET, new FabricItemSettings().group(ChristmasSpirit.MAIN));

    //DISCS
    public static final Item DISC_WISHBACKGROUND = new CSMusicDiscItem(15, ModSounds.WISHBACKGROUND, new FabricItemSettings().maxCount(1).group(ChristmasSpirit.MAIN).rarity(Rarity.RARE));
    public static final Item DISC_MCCHRISTMAS = new CSMusicDiscItem(15, ModSounds.MCCHRISTMAS, new FabricItemSettings().maxCount(1).group(ChristmasSpirit.MAIN).rarity(Rarity.RARE));
    public static final Item DISC_JARED = new CSMusicDiscItem(15, ModSounds.JARED, new FabricItemSettings().maxCount(1).group(ChristmasSpirit.MAIN).rarity(Rarity.RARE));

    //OTHER
    public static final Item SLEIGH = new SleighItem(new FabricItemSettings().group(ChristmasSpirit.MAIN));
    public static final Item CHRISTMAS_TREE = new ChristmasTreeItem(new FabricItemSettings().group(ChristmasSpirit.DECORATION), false);
    public static final Item CHRISTMAS_TREE_WHITE = new ChristmasTreeItem(new FabricItemSettings().group(ChristmasSpirit.DECORATION), true);

    //public static final Item SPAWN_EGG_JACK_FROST = regItem("spawn_egg_jack_frost", () -> new ItemSpawnEggBase(InitEntityTypes.JACK_FROST));
    //public static final Item SPAWN_EGG_REINDEER = regItem("spawn_egg_reindeer", () -> new ItemSpawnEggBase(InitEntityTypes.REINDEER));

    //------NAUGHTY ITEMS------\\

    //AL OF THESE ITEMS will use MC tag system
    public static final Item LUMP_OF_COAL = new Item(new FabricItemSettings().group(ChristmasSpirit.MAIN));

    public static final Item FROST_INGOT = new Item(new FabricItemSettings().group(ChristmasSpirit.MAIN));
    public static final Item FROST_HELMET = new FrostArmorItem(EquipmentSlot.HEAD, new FabricItemSettings().group(ChristmasSpirit.MAIN).maxCount(1));
    public static final Item FROST_CHESTPLATE = new FrostArmorItem(EquipmentSlot.CHEST, new FabricItemSettings().group(ChristmasSpirit.MAIN).maxCount(1));
    public static final Item FROST_LEGGINGS = new FrostArmorItem(EquipmentSlot.LEGS, new FabricItemSettings().group(ChristmasSpirit.MAIN).maxCount(1));
    public static final Item FROST_BOOTS = new FrostArmorItem(EquipmentSlot.FEET, new FabricItemSettings().group(ChristmasSpirit.MAIN).maxCount(1));


    public static final Item FROSTMOURNE = new FrostmourneItem(new FabricItemSettings().group(ChristmasSpirit.MAIN).maxCount(1));

    public static final CandyCaneCannonItem CANDY_CANE_CANNON = new CandyCaneCannonItem(new FabricItemSettings().group(ChristmasSpirit.MAIN).maxCount(1));

    //------BLOCKS------\\

    public static final Item FRUITCAKE = new BlockItem(ModBlocks.FRUITCAKE, new FabricItemSettings().group(ChristmasSpirit.BAKING));

    public static final Item PRESENT_UNWRAPPED = new BlockItem(ModBlocks.PRESENT_UNWRAPPED, new FabricItemSettings().group(ChristmasSpirit.DECORATION));

    public static final Item PRESENT_WRAPPED_RED_ITEM = new WrappedPresentBlockItem(ModBlocks.PRESENT_WRAPPED_RED, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item PRESENT_WRAPPED_GREEN_ITEM = new WrappedPresentBlockItem(ModBlocks.PRESENT_WRAPPED_GREEN, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item PRESENT_WRAPPED_BLUE_ITEM = new WrappedPresentBlockItem(ModBlocks.PRESENT_WRAPPED_BLUE, new FabricItemSettings().group(ChristmasSpirit.DECORATION));

    //CROPS
    public static final Item GINGER = new AliasedBlockItem(ModBlocks.GINGER, new FabricItemSettings().group(ChristmasSpirit.BAKING));
    public static final Item PEPPERMINT = new AliasedBlockItem(ModBlocks.PEPPERMINT, new FabricItemSettings().group(ChristmasSpirit.BAKING));

    //DECORATIONS
    public static final Item SNOWY_PATH = new BlockItem(ModBlocks.SNOWY_PATH, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item FROSTED_GLASS = new BlockItem(ModBlocks.FROSTED_GLASS, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item FROSTED_GLASS_PANE = new BlockItem(ModBlocks.FROSTED_GLASS_PANE, new FabricItemSettings().group(ChristmasSpirit.DECORATION));

    public static final Item CANDY_CANE_BLOCK_RED = new BlockItem(ModBlocks.CANDY_CANE_BLOCK_RED, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item CANDY_CANE_BLOCK_GREEN = new BlockItem(ModBlocks.CANDY_CANE_BLOCK_GREEN, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item CANDY_CANE_BLOCK_BLUE = new BlockItem(ModBlocks.CANDY_CANE_BLOCK_BLUE, new FabricItemSettings().group(ChristmasSpirit.DECORATION));

    public static final Item CANDY_CANE_BRICK_RED = new BlockItem(ModBlocks.CANDY_CANE_BRICK_RED, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item CANDY_CANE_BRICK_GREEN = new BlockItem(ModBlocks.CANDY_CANE_BRICK_GREEN, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item CANDY_CANE_BRICK_BLUE = new BlockItem(ModBlocks.CANDY_CANE_BRICK_BLUE, new FabricItemSettings().group(ChristmasSpirit.DECORATION));

    public static final Item CHRISTMAS_LIGHTS_MULTICOLOR = new BlockItem(ModBlocks.CHRISTMAS_LIGHTS_MULTICOLOR, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item CHRISTMAS_LIGHTS_MULTICOLOR_FLICKERING = new BlockItem(ModBlocks.CHRISTMAS_LIGHTS_MULTICOLOR_FLICKERING, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item CHRISTMAS_LIGHTS_WHITE = new BlockItem(ModBlocks.CHRISTMAS_LIGHTS_WHITE, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item CHRISTMAS_LIGHTS_WHITE_FLICKERING = new BlockItem(ModBlocks.CHRISTMAS_LIGHTS_WHITE_FLICKERING, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item CHRISTMAS_LIGHTS_RED = new BlockItem(ModBlocks.CHRISTMAS_LIGHTS_RED, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item CHRISTMAS_LIGHTS_GREEN = new BlockItem(ModBlocks.CHRISTMAS_LIGHTS_GREEN, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item CHRISTMAS_LIGHTS_BLUE = new BlockItem(ModBlocks.CHRISTMAS_LIGHTS_BLUE, new FabricItemSettings().group(ChristmasSpirit.DECORATION));

    public static final Item ORNAMENT_RED = new BlockItem(ModBlocks.ORNAMENT_RED, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item ORNAMENT_GREEN = new BlockItem(ModBlocks.ORNAMENT_GREEN, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item ORNAMENT_BLUE = new BlockItem(ModBlocks.ORNAMENT_BLUE, new FabricItemSettings().group(ChristmasSpirit.DECORATION));

    public static final Item STAR = new BlockItem(ModBlocks.STAR, new FabricItemSettings().group(ChristmasSpirit.DECORATION));

    public static final Item STOCKING_RED = new BlockItem(ModBlocks.STOCKING_RED, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item STOCKING_GREEN = new BlockItem(ModBlocks.STOCKING_GREEN, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item STOCKING_BLUE = new BlockItem(ModBlocks.STOCKING_BLUE, new FabricItemSettings().group(ChristmasSpirit.DECORATION));

    public static final Item CHIMNEY = new BlockItem(ModBlocks.CHIMNEY, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item ICICLES = new BlockItem(ModBlocks.ICICLES, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item SNOW_GLOBE = new BlockItem(ModBlocks.SNOW_GLOBE, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item GINGERBREAD_HOUSE = new BlockItem(ModBlocks.GINGERBREAD_HOUSE, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item COOKIE_TRAY = new BlockItem(ModBlocks.COOKIE_TRAY, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item REEF = new BlockItem(ModBlocks.REEF, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item GARLAND = new BlockItem(ModBlocks.GARLAND, new FabricItemSettings().group(ChristmasSpirit.DECORATION));
    public static final Item MISTLETOE = new BlockItem(ModBlocks.MISTLETOE, new FabricItemSettings().group(ChristmasSpirit.DECORATION));


    public static void init() {
        Registry.register(Registry.ITEM, ChristmasSpirit.id("flour"), FLOUR);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("icing"), ICING);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("food_dye_red"), FOOD_DYE_RED);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("food_dye_green"), FOOD_DYE_GREEN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("food_dye_blue"), FOOD_DYE_BLUE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("peppermint_leaf"), PEPPERMINT_LEAF);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("peppermint_candy_mix"), PEPPERMINT_CANDY_MIX);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("sugar_cookie_dough"), SUGAR_COOKIE_DOUGH);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("sugar_cookie_sheet"), SUGAR_COOKIE_SHEET);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("ginger_ground"), GINGER_GROUND);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("gingerbread_dough"), GINGERBREAD_DOUGH);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("gingerbread_sheet"), GINGERBREAD_SHEET);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("cookie_cutter_circle"), COOKIE_CUTTER_CIRCLE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("cookie_cutter_ornament"), COOKIE_CUTTER_ORNAMENT);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("cookie_cutter_star"), COOKIE_CUTTER_STAR);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("cookie_cutter_man"), COOKIE_CUTTER_MAN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("cookie_cutter_snowman"), COOKIE_CUTTER_SNOWMAN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_light_white"), CHRISTMAS_LIGHT_WHITE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_light_red"), CHRISTMAS_LIGHT_RED);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_light_green"), CHRISTMAS_LIGHT_GREEN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_light_blue"), CHRISTMAS_LIGHT_BLUE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("chocolate_bar"), CHOCOLATE_BAR);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("peppermint_bark"), PEPPERMINT_BARK);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("peppermint_candy_red"), PEPPERMINT_CANDY_RED);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("peppermint_candy_green"), PEPPERMINT_CANDY_GREEN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("peppermint_candy_blue"), PEPPERMINT_CANDY_BLUE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("candy_cane_red"), CANDY_CANE_RED);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("candy_cane_green"), CANDY_CANE_GREEN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("candy_cane_blue"), CANDY_CANE_BLUE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("sugar_cookie_santa"), SUGAR_COOKIE_SANTA);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("sugar_cookie_circle"), SUGAR_COOKIE_CIRCLE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("sugar_cookie_ornament"), SUGAR_COOKIE_ORNAMENT);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("sugar_cookie_star"), SUGAR_COOKIE_STAR);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("sugar_cookie_man"), SUGAR_COOKIE_MAN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("sugar_cookie_snowman"), SUGAR_COOKIE_SNOWMAN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("gingerbread_cookie_circle"), GINGERBREAD_COOKIE_CIRCLE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("gingerbread_cookie_ornament"), GINGERBREAD_COOKIE_ORNAMENT);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("gingerbread_cookie_star"), GINGERBREAD_COOKIE_STAR);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("gingerbread_cookie_man"), GINGERBREAD_COOKIE_MAN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("gingerbread_cookie_snowman"), GINGERBREAD_COOKIE_SNOWMAN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("mug_milk"), MUG_MILK);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("mug_hot_chocolate"), MUG_HOT_CHOCOLATE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("mug_eggnog"), MUG_EGGNOG);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("soda_cola"), SODA_COLA);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("soda_ginger_ale"), SODA_GINGER_ALE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("soda_sprite_cranberry"), SODA_SPRITE_CRANBERRY);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_hat"), CHRISTMAS_HAT);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("beanie_black"), BEANIE_BLACK);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("beanie_red"), BEANIE_RED);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("beanie_green"), BEANIE_GREEN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("sweater_black"), SWEATER_BLACK);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("sweater_red"), SWEATER_RED);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("sweater_green"), SWEATER_GREEN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("winter_jeans"), WINTER_JEANS);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("winter_boots"), WINTER_BOOTS);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("ice_skates"), ICE_SKATES);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("disc_wishbackground"), DISC_WISHBACKGROUND);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("disc_jared"), DISC_JARED);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("disc_mcchristmas"), DISC_MCCHRISTMAS);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("sleigh"), SLEIGH);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_tree"), CHRISTMAS_TREE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_tree_white"), CHRISTMAS_TREE_WHITE);
        //Registry.register(Registry.ITEM, ChristmasSpirit.id("spawn_egg_jack_frost"), SPAWN_EGG_JACK_FROST);
        //Registry.register(Registry.ITEM, ChristmasSpirit.id("spawn_egg_reindeer"), SPAWN_EGG_REINDEER);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("lump_of_coal"), LUMP_OF_COAL);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("frost_ingot"), FROST_INGOT);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("frost_helmet"), FROST_HELMET);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("frost_chestplate"), FROST_CHESTPLATE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("frost_leggings"), FROST_LEGGINGS);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("frost_boots"), FROST_BOOTS);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("frostmourne"), FROSTMOURNE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("candy_cane_cannon"), CANDY_CANE_CANNON);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("fruitcake"), FRUITCAKE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("present_unwrapped"), PRESENT_UNWRAPPED);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("present_wrapped_red"), PRESENT_WRAPPED_RED_ITEM);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("present_wrapped_blue"), PRESENT_WRAPPED_BLUE_ITEM);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("present_wrapped_green"), PRESENT_WRAPPED_GREEN_ITEM);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("ginger"), GINGER);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("peppermint"), PEPPERMINT);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("snowy_path"), SNOWY_PATH);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("frosted_glass"), FROSTED_GLASS);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("frosted_glass_pane"), FROSTED_GLASS_PANE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("candy_cane_block_red"), CANDY_CANE_BLOCK_RED);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("candy_cane_block_green"), CANDY_CANE_BLOCK_GREEN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("candy_cane_block_blue"), CANDY_CANE_BLOCK_BLUE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("candy_cane_brick_red"), CANDY_CANE_BRICK_RED);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("candy_cane_brick_green"), CANDY_CANE_BRICK_GREEN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("candy_cane_brick_blue"), CANDY_CANE_BRICK_BLUE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_lights_multicolor"), CHRISTMAS_LIGHTS_MULTICOLOR);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_lights_multicolor_flickering"), CHRISTMAS_LIGHTS_MULTICOLOR_FLICKERING);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_lights_white"), CHRISTMAS_LIGHTS_WHITE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_lights_white_flickering"), CHRISTMAS_LIGHTS_WHITE_FLICKERING);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_lights_red"), CHRISTMAS_LIGHTS_RED);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_lights_green"), CHRISTMAS_LIGHTS_GREEN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("christmas_lights_blue"), CHRISTMAS_LIGHTS_BLUE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("ornament_red"), ORNAMENT_RED);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("ornament_green"), ORNAMENT_GREEN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("ornament_blue"), ORNAMENT_BLUE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("star"), STAR);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("stocking_red"), STOCKING_RED);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("stocking_green"), STOCKING_GREEN);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("stocking_blue"), STOCKING_BLUE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("chimney"), CHIMNEY);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("icicles"), ICICLES);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("snow_globe"), SNOW_GLOBE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("gingerbread_house"), GINGERBREAD_HOUSE);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("cookie_tray"), COOKIE_TRAY);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("reef"), REEF);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("garland"), GARLAND);
        Registry.register(Registry.ITEM, ChristmasSpirit.id("mistletoe"), MISTLETOE);
    }

    public static FoodComponent createFoodComponent(int hunger, float saturation) {
        return new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build();
    }
}
