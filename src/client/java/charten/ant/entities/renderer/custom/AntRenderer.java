package charten.ant.entities.renderer.custom;

import charten.ant.entites.custom.AntEntity;
import charten.ant.entities.models.AntEntityModel;
import charten.ant.entities.renderer.ModEntityRenderers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
@Environment(EnvType.CLIENT)
public class AntRenderer extends MobEntityRenderer<AntEntity, AntEntityModel> {

    public AntRenderer(EntityRendererFactory.Context context) {
        super(context, new AntEntityModel(context.getPart(ModEntityRenderers.MODEL_ANT_LAYER)), 0.3f);
    }

    @Override
    public Identifier getTexture(AntEntity entity) {
        return new Identifier("ant", "textures/entity/cube/queen_ant.png");
    }

    @Override
    protected void scale(AntEntity entity, MatrixStack matrices, float amount) {
        matrices.scale(0.8f,0.8f,0.8f);
    }
}
