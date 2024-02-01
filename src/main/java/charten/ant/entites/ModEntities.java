package charten.ant.entites;

import charten.ant.Main;
import charten.ant.entites.custom.MajorAntEntity;
import charten.ant.entites.custom.QueenAntEntity;
import charten.ant.entites.custom.WorkerAntEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ArmorItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<QueenAntEntity> QUEEN_ANT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Main.MOD_ID, "queen_ant"),
            FabricEntityTypeBuilder.<QueenAntEntity>create(SpawnGroup.MISC, QueenAntEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.25f)).build());

    public static final EntityType<WorkerAntEntity> WORKER_ANT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Main.MOD_ID, "worker_ant"),
            FabricEntityTypeBuilder.<WorkerAntEntity>create(SpawnGroup.MISC, WorkerAntEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.25f)).build());

    public static final EntityType<MajorAntEntity> MAJOR_ANT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Main.MOD_ID, "major_ant"),
            FabricEntityTypeBuilder.<MajorAntEntity>create(SpawnGroup.MISC, MajorAntEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.25f)).build());
    public static void registerEntities(String modId) {
        FabricDefaultAttributeRegistry.register(QUEEN_ANT, QueenAntEntity.createAntAttributes());
        FabricDefaultAttributeRegistry.register(WORKER_ANT, WorkerAntEntity.createAntAttributes());
        FabricDefaultAttributeRegistry.register(MAJOR_ANT, MajorAntEntity.createAntAttributes());
        Main.LOGGER.info("Registering Entities for " + modId);
    }
}
