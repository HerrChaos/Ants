package charten.ant.entites;

import charten.ant.entites.custom.AntEntity;
import charten.ant.Main;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<AntEntity> QUEEN_ANT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Main.MOD_ID, "queen_ant"),
            FabricEntityTypeBuilder.<AntEntity>create(SpawnGroup.MISC, AntEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());
    public static void registerEntities(String modId) {
        FabricDefaultAttributeRegistry.register(QUEEN_ANT, AntEntity.createMobAttributes());
        Main.LOGGER.info("Registering Entities for " + modId);
    }
}
