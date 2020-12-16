package io.github.frqnny.cspirit.init;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.block.*;
import io.github.frqnny.cspirit.blockentity.CookieTrayBlockEntity;
import io.github.frqnny.cspirit.blockentity.UnwrappedPresentBlockEntity;
import io.github.frqnny.cspirit.blockentity.WrappedPresentBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block FRUITCAKE = new FruitCakeBlock(FabricBlockSettings.of(Material.CAKE).strength(0.5F).sounds(BlockSoundGroup.WOOL));
    public static final Block PRESENT_UNWRAPPED = new UnwrappedPresentBlock(FabricBlockSettings.of(Material.WOOL).strength(0.5F).sounds(BlockSoundGroup.WOOL).nonOpaque());
    public static final Block PRESENT_WRAPPED_RED = new WrappedPresentBlock(FabricBlockSettings.of(Material.WOOL, MaterialColor.RED).strength(0.8F).sounds(BlockSoundGroup.WOOL));
    public static final Block PRESENT_WRAPPED_GREEN = new WrappedPresentBlock(FabricBlockSettings.of(Material.WOOL, MaterialColor.GREEN).strength(0.8F).sounds(BlockSoundGroup.WOOL));
    public static final Block PRESENT_WRAPPED_BLUE = new WrappedPresentBlock(FabricBlockSettings.of(Material.WOOL, MaterialColor.BLUE).strength(0.8F).sounds(BlockSoundGroup.WOOL));
    public static final Block CANDY_CANE_POST_RED = new CandyCanePostBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.RED).hardness(0.5F).nonOpaque().sounds(BlockSoundGroup.LANTERN));
    public static final Block CANDY_CANE_POST_GREEN = new CandyCanePostBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.GREEN).hardness(0.5F).nonOpaque().sounds(BlockSoundGroup.LANTERN));
    public static final Block CANDY_CANE_POST_BLUE = new CandyCanePostBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.BLUE).hardness(0.5F).nonOpaque().sounds(BlockSoundGroup.LANTERN));
    public static final Block GINGER = new CSpiritCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT));
    public static final Block PEPPERMINT = new CSpiritCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT));
    public static final Block SNOWY_PATH = new SnowyPathBlock(FabricBlockSettings.of(Material.STONE).strength(1F).sounds(BlockSoundGroup.STONE).blockVision(AbstractBlock.AbstractBlockState::shouldPostProcess).suffocates(AbstractBlock.AbstractBlockState::shouldPostProcess));
    public static final Block FROSTED_GLASS = new FrostedGlassBlock(FabricBlockSettings.of(Material.GLASS).strength(0.5F).sounds(BlockSoundGroup.GLASS).nonOpaque().dynamicBounds());
    public static final Block FROSTED_GLASS_PANE = new FrostedGlassPaneBlock(FabricBlockSettings.of(Material.GLASS).strength(0.5F).sounds(BlockSoundGroup.GLASS).nonOpaque().dynamicBounds());
    public static final Block CANDY_CANE_BLOCK_RED = new CSBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.RED).sounds(BlockSoundGroup.NETHERRACK));
    public static final Block CANDY_CANE_BLOCK_GREEN = new CSBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.GREEN).sounds(BlockSoundGroup.NETHERRACK));
    public static final Block CANDY_CANE_BLOCK_BLUE = new CSBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.BLUE).sounds(BlockSoundGroup.NETHERRACK));
    public static final Block CANDY_CANE_BRICK_RED = new CSBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.RED).requiresTool().strength(2.0F, 6.0F).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block CANDY_CANE_BRICK_GREEN = new CSBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.GREEN).requiresTool().strength(2.0F, 6.0F).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block CANDY_CANE_BRICK_BLUE = new CSBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.BLUE).requiresTool().strength(2.0F, 6.0F).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block CHRISTMAS_LIGHTS_MULTICOLOR = new ChristmasLightsBlock(FabricBlockSettings.of(Material.METAL).hardness(0.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque().dynamicBounds().noCollision().luminance((state) -> 10));
    public static final Block CHRISTMAS_LIGHTS_MULTICOLOR_FLICKERING = new ChristmasLightsBlock(FabricBlockSettings.of(Material.METAL).hardness(0.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque().dynamicBounds().noCollision().luminance((state) -> 10));
    public static final Block CHRISTMAS_LIGHTS_WHITE = new ChristmasLightsBlock(FabricBlockSettings.of(Material.METAL, MaterialColor.WHITE).hardness(0.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque().dynamicBounds().noCollision().luminance((state) -> 10));
    public static final Block CHRISTMAS_LIGHTS_WHITE_FLICKERING = new ChristmasLightsBlock(FabricBlockSettings.of(Material.METAL, MaterialColor.WHITE).hardness(0.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque().dynamicBounds().noCollision().luminance((state) -> 10));
    public static final Block CHRISTMAS_LIGHTS_RED = new ChristmasLightsBlock(FabricBlockSettings.of(Material.METAL, MaterialColor.RED).hardness(0.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque().dynamicBounds().noCollision().luminance((state) -> 10));
    public static final Block CHRISTMAS_LIGHTS_GREEN = new ChristmasLightsBlock(FabricBlockSettings.of(Material.METAL, MaterialColor.GREEN).hardness(0.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque().dynamicBounds().noCollision().luminance((state) -> 10));
    public static final Block CHRISTMAS_LIGHTS_BLUE = new ChristmasLightsBlock(FabricBlockSettings.of(Material.METAL, MaterialColor.BLUE).hardness(0.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque().dynamicBounds().noCollision().luminance((state) -> 10));
    public static final Block ORNAMENT_RED = new OrnamentBlock(FabricBlockSettings.of(Material.METAL, MaterialColor.RED).strength(0.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque().dynamicBounds().noCollision());
    public static final Block ORNAMENT_GREEN = new OrnamentBlock(FabricBlockSettings.of(Material.METAL, MaterialColor.GREEN).strength(0.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque().dynamicBounds().noCollision());
    public static final Block ORNAMENT_BLUE = new OrnamentBlock(FabricBlockSettings.of(Material.METAL, MaterialColor.BLUE).strength(0.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque().dynamicBounds().noCollision());
    public static final Block STAR = new StarBlock(FabricBlockSettings.of(Material.STONE).strength(0.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque().luminance((state) -> 10));
    public static final Block STOCKING_RED = new StockingBlock(FabricBlockSettings.of(Material.WOOL, MaterialColor.RED).sounds(BlockSoundGroup.WOOL).strength(0).sounds(BlockSoundGroup.WOOL).nonOpaque().dynamicBounds().noCollision());
    public static final Block STOCKING_GREEN = new StockingBlock(FabricBlockSettings.of(Material.WOOL, MaterialColor.GREEN).sounds(BlockSoundGroup.WOOL).strength(0).sounds(BlockSoundGroup.WOOL).nonOpaque().dynamicBounds().noCollision());
    public static final Block STOCKING_BLUE = new StockingBlock(FabricBlockSettings.of(Material.WOOL, MaterialColor.BLUE).sounds(BlockSoundGroup.WOOL).strength(0).sounds(BlockSoundGroup.WOOL).nonOpaque().dynamicBounds().noCollision());
    public static final Block CHIMNEY = new ChimneyBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(1).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1).sounds(BlockSoundGroup.STONE).nonOpaque().dynamicBounds());
    public static final Block ICICLES = new IciclesBlock(FabricBlockSettings.of(Material.ICE).strength(0.5F).sounds(BlockSoundGroup.GLASS).nonOpaque().dynamicBounds());
    public static final Block SNOW_GLOBE = new SnowGlobeBlock(FabricBlockSettings.of(Material.STONE).strength(1).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1).sounds(BlockSoundGroup.STONE).nonOpaque().dynamicBounds());
    public static final Block GINGERBREAD_HOUSE = new GingerbreadHouseBlock(FabricBlockSettings.of(Material.STONE).strength(0.5F).sounds(BlockSoundGroup.STONE).nonOpaque().luminance(1));
    public static final Block COOKIE_TRAY = new CookieTrayBlock(FabricBlockSettings.of(Material.METAL).strength(0.5F).sounds(BlockSoundGroup.METAL).nonOpaque());
    public static final Block REEF = new ReefBlock(FabricBlockSettings.of(Material.PLANT).strength(0).sounds(BlockSoundGroup.GRASS).nonOpaque().dynamicBounds().noCollision());
    public static final Block GARLAND = new GarlandBlock(FabricBlockSettings.of(Material.PLANT).strength(0).sounds(BlockSoundGroup.GRASS).nonOpaque().dynamicBounds().noCollision());
    public static final Block MISTLETOE = new MistletoeBlock(FabricBlockSettings.of(Material.PLANT).strength(0).sounds(BlockSoundGroup.GRASS).nonOpaque().dynamicBounds().noCollision());

    public static BlockEntityType<CookieTrayBlockEntity> COOKIE_TRAY_BLOCK_ENTITY;
    public static BlockEntityType<UnwrappedPresentBlockEntity> UNWRAPPED_PRESENT_BLOCK_ENTITY;
    public static BlockEntityType<WrappedPresentBlockEntity> WRAPPED_PRESENT_BLOCK_ENTITY;


    public static void init() {
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("fruitcake"), FRUITCAKE);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("present_unwrapped"), PRESENT_UNWRAPPED);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("present_wrapped_red"), PRESENT_WRAPPED_RED);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("present_wrapped_green"), PRESENT_WRAPPED_GREEN);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("present_wrapped_blue"), PRESENT_WRAPPED_BLUE);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("candy_cane_red"), CANDY_CANE_POST_RED);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("candy_cane_green"), CANDY_CANE_POST_GREEN);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("candy_cane_blue"), CANDY_CANE_POST_BLUE);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("ginger"), GINGER);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("peppermint"), PEPPERMINT);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("snowy_path"), SNOWY_PATH);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("frosted_glass"), FROSTED_GLASS);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("frosted_glass_pane"), FROSTED_GLASS_PANE);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("candy_cane_block_red"), CANDY_CANE_BLOCK_RED);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("candy_cane_block_green"), CANDY_CANE_BLOCK_GREEN);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("candy_cane_block_blue"), CANDY_CANE_BLOCK_BLUE);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("candy_cane_brick_red"), CANDY_CANE_BRICK_RED);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("candy_cane_brick_green"), CANDY_CANE_BRICK_GREEN);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("candy_cane_brick_blue"), CANDY_CANE_BRICK_BLUE);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("christmas_lights_multicolor"), CHRISTMAS_LIGHTS_MULTICOLOR);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("christmas_lights_multicolor_flickering"), CHRISTMAS_LIGHTS_MULTICOLOR_FLICKERING);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("christmas_lights_white"), CHRISTMAS_LIGHTS_WHITE);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("christmas_lights_white_flickering"), CHRISTMAS_LIGHTS_WHITE_FLICKERING);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("christmas_lights_red"), CHRISTMAS_LIGHTS_RED);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("christmas_lights_green"), CHRISTMAS_LIGHTS_GREEN);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("christmas_lights_blue"), CHRISTMAS_LIGHTS_BLUE);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("ornament_red"), ORNAMENT_RED);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("ornament_green"), ORNAMENT_GREEN);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("ornament_blue"), ORNAMENT_BLUE);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("star"), STAR);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("stocking_red"), STOCKING_RED);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("stocking_green"), STOCKING_GREEN);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("stocking_blue"), STOCKING_BLUE);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("chimney"), CHIMNEY);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("icicles"), ICICLES);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("snow_globe"), SNOW_GLOBE);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("gingerbread_house"), GINGERBREAD_HOUSE);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("cookie_tray"), COOKIE_TRAY);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("reef"), REEF);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("garland"), GARLAND);
        Registry.register(Registry.BLOCK, ChristmasSpirit.id("mistletoe"), MISTLETOE);

        COOKIE_TRAY_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, ChristmasSpirit.id("cookie_tray"), BlockEntityType.Builder.create(CookieTrayBlockEntity::new, COOKIE_TRAY).build(null));
        UNWRAPPED_PRESENT_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, ChristmasSpirit.id("present_unwrapped"), BlockEntityType.Builder.create(UnwrappedPresentBlockEntity::new, PRESENT_UNWRAPPED).build(null));
        WRAPPED_PRESENT_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, ChristmasSpirit.id("present_wrapped_red"), BlockEntityType.Builder.create(WrappedPresentBlockEntity::new, PRESENT_WRAPPED_RED).build(null));
        WRAPPED_PRESENT_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, ChristmasSpirit.id("present_wrapped_green"), BlockEntityType.Builder.create(WrappedPresentBlockEntity::new, PRESENT_WRAPPED_GREEN).build(null));
        WRAPPED_PRESENT_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, ChristmasSpirit.id("present_wrapped_blue"), BlockEntityType.Builder.create(WrappedPresentBlockEntity::new, PRESENT_WRAPPED_BLUE).build(null));

    }
}
