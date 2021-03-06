package io.github.frqnny.cspirit.init;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public class ModEntityTypes {
    public static EntityType<CandyCaneProjectileEntity> CANDY_CANE_PROJECTILE;
    public static EntityType<ChristmasTreeEntity> CHRISTMAS_TREE;
    public static EntityType<SleighEntity> SLEIGH_ENTITY;
    public static EntityType<JackFrostEntity> JACK_FROST_ENTITY;
    public static EntityType<ReindeerEntity> REINDEER_ENTITY;

    public static void init() {
        CANDY_CANE_PROJECTILE = register("candy_cane_projectile",
                FabricEntityTypeBuilder.<CandyCaneProjectileEntity>create(SpawnGroup.MISC, CandyCaneProjectileEntity::new)
                        .dimensions(EntityDimensions.fixed(0.5F, 0.5F))
                        .trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
                        .build()
        );
        CHRISTMAS_TREE = register("christmas_tree",
                FabricEntityTypeBuilder.<ChristmasTreeEntity>create(SpawnGroup.MISC, ChristmasTreeEntity::new)
                        .dimensions(EntityDimensions.fixed(1.5F, 3F))
                        .build()
        );
        SLEIGH_ENTITY = register("sleigh",
                FabricEntityTypeBuilder.<SleighEntity>create(SpawnGroup.MISC, SleighEntity::new)
                        .dimensions(EntityDimensions.fixed(1.95F, 1.95F))
                        .build()
        );
        JACK_FROST_ENTITY = register("jack_frost",
                FabricEntityTypeBuilder.<JackFrostEntity>create(SpawnGroup.MONSTER, JackFrostEntity::new)
                        .dimensions(EntityDimensions.fixed(0.8F, 1.8F))
                        .build()
        );
        FabricDefaultAttributeRegistry.register(JACK_FROST_ENTITY, JackFrostEntity.createJackFrostAttributes());
        REINDEER_ENTITY = register("reindeer",
                FabricEntityTypeBuilder.<ReindeerEntity>create(SpawnGroup.CREATURE, ReindeerEntity::new)
                        .dimensions(EntityDimensions.fixed(0.8F, 1.8F))
                        .build()
        );
        FabricDefaultAttributeRegistry.register(REINDEER_ENTITY, ReindeerEntity.createReindeerAttributes());

    }

    private static <T extends Entity> EntityType<T> register(String name, EntityType<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, ChristmasSpirit.id(name), builder);
    }
}
