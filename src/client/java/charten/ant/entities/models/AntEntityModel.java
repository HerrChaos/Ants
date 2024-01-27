package charten.ant.entities.models;

import charten.ant.entites.custom.AntEntity;
import charten.ant.entities.renderer.animations.AntAnimation;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class AntEntityModel<T extends AntEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bone;
	private final ModelPart head;
	public AntEntityModel(ModelPart modelPart) {
		this.bone = modelPart.getChild("bone");
		this.head = bone.getChild("mainbody").getChild("Head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 1.25F, 0.0F, 1.5708F, 0.0F));

		ModelPartData mainbody = bone.addChild("mainbody", ModelPartBuilder.create().uv(8, 2).cuboid(-1.6F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

		ModelPartData cube_r1 = mainbody.addChild("cube_r1", ModelPartBuilder.create().uv(8, 0).cuboid(1.45F, -0.4F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.05F, -0.9F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(-0.25F)), ModelTransform.of(0.65F, -1.25F, 0.0F, 0.0F, 0.0F, -0.2182F));

		ModelPartData Head = mainbody.addChild("Head", ModelPartBuilder.create().uv(24, 12).cuboid(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(24, 16).cuboid(1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(-0.1F))
				.uv(0, 27).cuboid(1.0F, -1.0F, -1.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3F))
				.uv(0, 27).cuboid(1.0F, -1.0F, 0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.pivot(2.5F, -1.5F, 0.0F));

		ModelPartData antenna_R = Head.addChild("antenna_R", ModelPartBuilder.create().uv(14, 23).cuboid(-0.5F, -2.75F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(-0.28F)), ModelTransform.of(2.5F, -0.5F, -0.75F, 1.3188F, -0.3997F, -0.2065F));

		ModelPartData An_seg_R_1 = antenna_R.addChild("An_seg_R_1", ModelPartBuilder.create().uv(19, 27).cuboid(-0.5F, -2.75F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, -2.25F, 0.0F, 0.2537F, 0.0697F, 0.7762F));

		ModelPartData An_seg_R_2 = An_seg_R_1.addChild("An_seg_R_2", ModelPartBuilder.create().uv(18, 24).cuboid(-0.5F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
				.uv(0, 22).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, -2.25F, 0.0F, -0.0005F, -0.0076F, 0.1744F));

		ModelPartData antenna_L = Head.addChild("antenna_L", ModelPartBuilder.create().uv(14, 23).cuboid(-0.5F, -2.75F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(-0.28F)), ModelTransform.of(2.5F, -0.5F, 0.75F, -1.3188F, 0.3997F, 0.2065F));

		ModelPartData An_seg_L_1 = antenna_L.addChild("An_seg_L_1", ModelPartBuilder.create().uv(19, 27).cuboid(-0.5F, -2.75F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, -2.25F, 0.0F, 0.2537F, 0.0697F, 0.7762F));

		ModelPartData An_seg_L_2 = An_seg_L_1.addChild("An_seg_L_2", ModelPartBuilder.create().uv(18, 24).cuboid(-0.5F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
				.uv(0, 22).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, -2.25F, 0.0F, -0.0005F, -0.0076F, 0.1744F));

		ModelPartData claw_R = Head.addChild("claw_R", ModelPartBuilder.create(), ModelTransform.pivot(2.9429F, 0.5F, -1.287F));

		ModelPartData seg_1 = claw_R.addChild("seg_1", ModelPartBuilder.create().uv(11, 27).cuboid(-0.25F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(-1.1929F, 0.0F, 0.287F, 0.0F, 0.2182F, 0.0F));

		ModelPartData seg_2 = seg_1.addChild("seg_2", ModelPartBuilder.create().uv(11, 29).cuboid(-0.25F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(1.4F, 0.0F, 0.0F, 0.0F, -1.309F, 0.0F));

		ModelPartData claw_L = Head.addChild("claw_L", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, 2.5F, 0.0F));

		ModelPartData seg_3 = claw_L.addChild("seg_3", ModelPartBuilder.create().uv(11, 27).cuboid(-0.25F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(4.25F, -2.0F, 1.0F, 0.0F, -0.2182F, 0.0F));

		ModelPartData seg_4 = seg_3.addChild("seg_4", ModelPartBuilder.create().uv(11, 29).cuboid(-0.25F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(1.4F, 0.0F, 0.0F, 0.0F, 1.309F, 0.0F));

		ModelPartData spine = mainbody.addChild("spine", ModelPartBuilder.create().uv(8, 24).cuboid(-1.5625F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 15).cuboid(-1.3125F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 29).cuboid(-1.8125F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F))
				.uv(0, 17).cuboid(-0.8125F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.pivot(-1.1875F, -1.0F, 0.0F));

		ModelPartData back = spine.addChild("back", ModelPartBuilder.create().uv(2, 4).cuboid(-2.3619F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(2, 4).cuboid(-1.8619F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.pivot(-1.4506F, 0.0F, 0.0F));

		ModelPartData cube_r2 = back.addChild("cube_r2", ModelPartBuilder.create().uv(8, 6).cuboid(-2.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.of(-0.8619F, 1.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData Leg_1 = mainbody.addChild("Leg_1", ModelPartBuilder.create().uv(7, 27).cuboid(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(1.75F, -0.75F, -0.75F, 0.0F, 0.0F, 0.3927F));

		ModelPartData leg_1_1 = Leg_1.addChild("leg_1_1", ModelPartBuilder.create().uv(2, 16).cuboid(-0.5F, -0.5F, -3.75F, 1.0F, 1.0F, 4.0F, new Dilation(-0.25F)), ModelTransform.of(0.0F, 0.5F, -0.25F, -0.2094F, -0.6981F, -0.3069F));

		ModelPartData leg_1_2 = leg_1_1.addChild("leg_1_2", ModelPartBuilder.create().uv(5, 10).cuboid(-0.5F, -0.5F, -4.75F, 1.0F, 1.0F, 5.0F, new Dilation(-0.26F)), ModelTransform.of(0.0F, 0.0F, -3.25F, 0.5236F, 0.0F, 0.0F));

		ModelPartData Leg_2 = mainbody.addChild("Leg_2", ModelPartBuilder.create().uv(7, 27).cuboid(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(1.75F, -0.75F, 0.75F, 0.0F, 0.0F, 0.3927F));

		ModelPartData leg_2_1 = Leg_2.addChild("leg_2_1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.5F, 0.25F, 0.2094F, 0.6981F, -0.3069F));

		ModelPartData cube_r3 = leg_2_1.addChild("cube_r3", ModelPartBuilder.create().uv(2, 16).mirrored().cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(-0.25F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 1.75F, 3.1416F, 0.0F, 0.0F));

		ModelPartData leg_2_2 = leg_2_1.addChild("leg_2_2", ModelPartBuilder.create().uv(5, 10).cuboid(-0.5F, -0.5F, -0.25F, 1.0F, 1.0F, 5.0F, new Dilation(-0.26F)), ModelTransform.of(0.0F, 0.0F, 3.25F, -0.5236F, 0.0F, 0.0F));

		ModelPartData Leg_3 = mainbody.addChild("Leg_3", ModelPartBuilder.create(), ModelTransform.pivot(0.25F, -0.5F, 0.5F));

		ModelPartData leg_2_3 = Leg_3.addChild("leg_2_3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		ModelPartData cube_r4 = leg_2_3.addChild("cube_r4", ModelPartBuilder.create().uv(2, 16).cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(-0.25F)), ModelTransform.of(0.0F, 0.0F, 1.75F, 3.1416F, 0.0F, 0.0F));

		ModelPartData leg_2_4 = leg_2_3.addChild("leg_2_4", ModelPartBuilder.create().uv(5, 10).cuboid(-0.5F, -0.5F, -0.25F, 1.0F, 1.0F, 5.0F, new Dilation(-0.26F)), ModelTransform.of(0.0F, 0.0F, 3.25F, -1.1781F, 0.0F, 0.0F));

		ModelPartData Leg_5 = mainbody.addChild("Leg_5", ModelPartBuilder.create(), ModelTransform.pivot(0.25F, -0.5F, -0.5F));

		ModelPartData leg_1_3 = Leg_5.addChild("leg_1_3", ModelPartBuilder.create().uv(2, 16).cuboid(-0.5F, -0.25F, -3.75F, 1.0F, 1.0F, 4.0F, new Dilation(-0.25F)), ModelTransform.of(0.0F, -0.25F, 0.0F, -0.48F, 0.0F, 0.0F));

		ModelPartData leg_1_4 = leg_1_3.addChild("leg_1_4", ModelPartBuilder.create().uv(5, 10).cuboid(-0.5F, -0.5F, -4.75F, 1.0F, 1.0F, 5.0F, new Dilation(-0.26F)), ModelTransform.of(0.0F, 0.25F, -3.25F, 1.1781F, 0.0F, 0.0F));

		ModelPartData Leg_4 = mainbody.addChild("Leg_4", ModelPartBuilder.create(), ModelTransform.of(-1.0F, -0.5F, 0.5F, 0.0F, -0.4363F, 0.0F));

		ModelPartData leg_2_5 = Leg_4.addChild("leg_2_5", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData cube_r5 = leg_2_5.addChild("cube_r5", ModelPartBuilder.create().uv(2, 16).cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(-0.25F)), ModelTransform.of(0.0F, 0.0F, 1.75F, 3.1416F, 0.0F, 0.0F));

		ModelPartData leg_2_6 = leg_2_5.addChild("leg_2_6", ModelPartBuilder.create().uv(5, 10).cuboid(-0.5F, -0.5F, -0.25F, 1.0F, 1.0F, 5.0F, new Dilation(-0.26F)), ModelTransform.of(0.0F, 0.0F, 3.25F, -1.0036F, 0.0F, 0.0F));

		ModelPartData Leg_6 = mainbody.addChild("Leg_6", ModelPartBuilder.create(), ModelTransform.of(-1.0F, -0.5F, -0.5F, 0.0F, 0.4363F, 0.0F));

		ModelPartData leg_1_5 = Leg_6.addChild("leg_1_5", ModelPartBuilder.create().uv(2, 16).cuboid(-0.5F, -0.25F, -3.75F, 1.0F, 1.0F, 4.0F, new Dilation(-0.25F)), ModelTransform.of(0.0F, -0.25F, 0.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData leg_1_6 = leg_1_5.addChild("leg_1_6", ModelPartBuilder.create().uv(5, 10).cuboid(-0.5F, -0.5F, -4.75F, 1.0F, 1.0F, 5.0F, new Dilation(-0.26F)), ModelTransform.of(0.0F, 0.25F, -3.25F, 1.0036F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(AntEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngels(netHeadYaw, headPitch);

		this.animateMovement(AntAnimation.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
	}

	private void setHeadAngels(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return bone;
	}
}