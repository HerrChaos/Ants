package charten.ant.entities.renderer.animations;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;
import org.joml.Vector3f;

public class AntAnimation {
        public static final Animation WALK = Animation.Builder.create(0.75f).looping()
                .addBoneAnimation("Head",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 7.5f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(0f, -7.5f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(0f, 7.5f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("spine",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 7.5f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(0f, -7.5f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(0f, 7.5f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("back",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 7.5f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(0f, -7.5f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(0f, 7.5f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg_1_1",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 15f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(-10f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(0f, -15f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(0f, 15f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg_2_1",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 15f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(0f, -15f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(0f, 15f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg_2_3",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -15f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(0f, 15f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(0f, -15f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg_1_3",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -15f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(0f, 15f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(-10f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(0f, -15f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg_2_5",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 15f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(0f, -15f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(0f, 15f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg_1_5",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 15f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(-10f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(0f, -15f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(0f, 15f, 0f),
                                        Transformation.Interpolations.LINEAR))).build();
}