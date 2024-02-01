package charten.ant.entities.renderer.custom;

import charten.ant.Main;
import charten.ant.entites.custom.AntEntity;
import charten.ant.entities.models.AntEntityModel;
import charten.ant.entities.renderer.ModEntityRenderers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.Objects;

@Environment(EnvType.CLIENT)
public class AntRenderer extends MobEntityRenderer<AntEntity, AntEntityModel<AntEntity>> {
    public static final EntityModelLayer MODEL_ANT_LAYER = new EntityModelLayer(new Identifier(Main.MOD_ID, "ant"), "main");
    private AntEntityModel<AntEntity> Model;
    public AntRenderer(EntityRendererFactory.Context context) {
        super(context, new AntEntityModel<>(context.getPart(MODEL_ANT_LAYER)), 0.3f);
        Model = new AntEntityModel<>(context.getPart(MODEL_ANT_LAYER));
    }

    @Override
    public Identifier getTexture(AntEntity entity) {
        Identifier originalTexture = new Identifier("ant", "textures/entity/ant/worker_ant.png");
        return originalTexture;
    }
    @Override
    public void render(AntEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isQueen()) {
            matrixStack.scale(1f, 1f, 1f);
        } else if (mobEntity.isWorker()){
            matrixStack.scale(0.8f, 0.8f, 0.8f);
        } else if (mobEntity.isMajor()){
            matrixStack.scale(1.2f, 1.2f, 1.2f);
        }

        super.render(mobEntity, f, g ,matrixStack, vertexConsumerProvider, i);
    }
}

