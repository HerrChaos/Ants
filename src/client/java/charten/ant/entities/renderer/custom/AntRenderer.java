package charten.ant.entities.renderer.custom;

import charten.ant.Main;
import charten.ant.entites.custom.AntEntity;
import charten.ant.entities.models.AntEntityModel;
import charten.ant.entities.renderer.ModEntityRenderers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
@Environment(EnvType.CLIENT)
public class AntRenderer extends MobEntityRenderer<AntEntity, AntEntityModel<AntEntity>> {
    public static final EntityModelLayer MODEL_ANT_LAYER = new EntityModelLayer(new Identifier(Main.MOD_ID, "ant"), "main");
    public AntRenderer(EntityRendererFactory.Context context) {
        super(context, new AntEntityModel(context.getPart(MODEL_ANT_LAYER)), 0.3f);
    }

    @Override
    public Identifier getTexture(AntEntity entity) {
        return new Identifier("ant", "textures/entity/ant/worker_ant.png");
    }
    @Override
    public void render(AntEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isQueen()) {
            matrixStack.scale(1f, 1f, 1f);
        } else {
            matrixStack.scale(0.8f, 0.8f, 0.8f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
