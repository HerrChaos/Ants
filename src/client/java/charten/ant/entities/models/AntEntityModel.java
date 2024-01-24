package charten.ant.entities.models;

import charten.ant.entites.custom.AntEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
public class AntEntityModel extends EntityModel<AntEntity> {
	private final ModelPart bone;
	public AntEntityModel(ModelPart modelPart) {
		this.bone = modelPart.getChild("bone");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 24.0F, 0.0F));

		ModelPartData mainbody = bone.addChild("mainbody", ModelPartBuilder.create().uv(0, 0).cuboid(-1.6F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

		ModelPartData cube_r1 = mainbody.addChild("cube_r1", ModelPartBuilder.create().uv(1, 1).cuboid(1.45F, -0.4F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.05F, -0.9F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.25F)), ModelTransform.of(0.65F, -1.25F, 0.0F, 0.0F, 0.0F, -0.2182F));

		ModelPartData spine = bone.addChild("spine", ModelPartBuilder.create().uv(2, 2).cuboid(-2.75F, -1.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(1, 1).cuboid(-2.5F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(1, 1).cuboid(-3.0F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F))
		.uv(1, 1).cuboid(-2.0F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

		ModelPartData back = bone.addChild("back", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.5F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.pivot(-3.0F, -1.0F, 0.0F));

		ModelPartData cube_r2 = back.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.of(-0.5F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData Head = bone.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(2.5F, -3.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(3.5F, -3.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(-0.1F))
		.uv(1, 1).cuboid(3.5F, -3.5F, -1.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3F))
		.uv(1, 1).cuboid(3.5F, -3.5F, 0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData antenna_R = Head.addChild("antenna_R", ModelPartBuilder.create().uv(1, 1).cuboid(-0.5F, -2.75F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(-0.28F)), ModelTransform.of(5.0F, -3.0F, -0.75F, 1.3188F, -0.3997F, -0.2065F));

		ModelPartData An_seg_R_1 = antenna_R.addChild("An_seg_R_1", ModelPartBuilder.create().uv(1, 1).cuboid(-0.5F, -2.75F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, -2.25F, 0.0F, 0.2537F, 0.0697F, 0.7762F));

		ModelPartData An_seg_R_2 = An_seg_R_1.addChild("An_seg_R_2", ModelPartBuilder.create().uv(1, 1).cuboid(-0.5F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
		.uv(1, 1).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, -2.25F, 0.0F, -0.0005F, -0.0076F, 0.1744F));

		ModelPartData antenna_L = Head.addChild("antenna_L", ModelPartBuilder.create().uv(1, 1).cuboid(-0.5F, -2.75F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(-0.28F)), ModelTransform.of(5.0F, -3.0F, 0.75F, -1.3188F, 0.3997F, 0.2065F));

		ModelPartData An_seg_L_1 = antenna_L.addChild("An_seg_L_1", ModelPartBuilder.create().uv(1, 1).cuboid(-0.5F, -2.75F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, -2.25F, 0.0F, 0.2537F, 0.0697F, 0.7762F));

		ModelPartData An_seg_L_2 = An_seg_L_1.addChild("An_seg_L_2", ModelPartBuilder.create().uv(1, 1).cuboid(-0.5F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
		.uv(1, 1).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, -2.25F, 0.0F, -0.0005F, -0.0076F, 0.1744F));

		ModelPartData claw_R = Head.addChild("claw_R", ModelPartBuilder.create(), ModelTransform.pivot(5.4429F, -2.0F, -1.287F));

		ModelPartData seg_1 = claw_R.addChild("seg_1", ModelPartBuilder.create().uv(1, 1).cuboid(-0.25F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(-1.1929F, 0.0F, 0.287F, 0.0F, 0.2182F, 0.0F));

		ModelPartData seg_2 = seg_1.addChild("seg_2", ModelPartBuilder.create().uv(1, 1).cuboid(-0.25F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(1.4F, 0.0F, 0.0F, 0.0F, -1.309F, 0.0F));

		ModelPartData claw_L = Head.addChild("claw_L", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData seg_3 = claw_L.addChild("seg_3", ModelPartBuilder.create().uv(1, 1).cuboid(-0.25F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(4.25F, -2.0F, 1.0F, 0.0F, -0.2182F, 0.0F));

		ModelPartData seg_4 = seg_3.addChild("seg_4", ModelPartBuilder.create().uv(1, 1).cuboid(-0.25F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(1.4F, 0.0F, 0.0F, 0.0F, 1.309F, 0.0F));
		return TexturedModelData.of(modelData, 16, 16);
	}
	@Override
	public void setAngles(AntEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}