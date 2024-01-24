package charten.ant.entities.renderer;

import charten.ant.Main;
import charten.ant.entites.ModEntities;
import charten.ant.entities.models.AntEntityModel;
import charten.ant.entities.renderer.custom.AntRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModEntityRenderers {
    public static final EntityModelLayer MODEL_ANT_LAYER = new EntityModelLayer(new Identifier(Main.MOD_ID, "ant"), "main");

    public static void registerModEntityRenderers() {
        EntityRendererRegistry.register(ModEntities.QUEEN_ANT, AntRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_ANT_LAYER, AntEntityModel::getTexturedModelData);
    }
}