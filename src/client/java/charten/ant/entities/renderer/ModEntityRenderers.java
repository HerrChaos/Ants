package charten.ant.entities.renderer;

import charten.ant.Main;
import charten.ant.entites.ModEntities;
import charten.ant.entites.custom.AntEntity;
import charten.ant.entities.models.AntEntityModel;
import charten.ant.entities.models.MajorAntModel;
import charten.ant.entities.renderer.custom.AntRenderer;
import charten.ant.entities.renderer.custom.MajorAntRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModEntityRenderers {

    public static void registerModEntityRenderers() {
        EntityRendererRegistry.register(ModEntities.QUEEN_ANT, AntRenderer::new);
        EntityRendererRegistry.register(ModEntities.WORKER_ANT, AntRenderer::new);
        EntityRendererRegistry.register(ModEntities.MAJOR_ANT, MajorAntRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(AntRenderer.MODEL_ANT_LAYER, AntEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MajorAntRenderer.MODEL_MAJOR_ANT_LAYER, MajorAntModel::getTexturedModelData);
    }
}
