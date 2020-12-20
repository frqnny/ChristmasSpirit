package io.github.frqnny.cspirit.client.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class SleighModel extends EntityModel<Entity> {

    private final ModelPart Body;
    private final ModelPart Skate;
    private final ModelPart Skate2;
    private final ModelPart Chest;
    private final ModelPart Wall;
    private final ModelPart Loop;
    private final ModelPart Loop2;
    private final ModelPart Engine;
    private final ModelPart Detailing;
    private final ModelPart Detailing2;

    public SleighModel() {
        textureWidth = 256;
        textureHeight = 256;

        Body = new ModelPart(this);
        Body.setPivot(-19.6F, 24.0F, -7.3F);
        Body.setTextureOffset(0, 0).addCuboid(4.0F, -14.0F, -19.0F, 32.0F, 2.0F, 55.0F, 0.0F, false);
        Body.setTextureOffset(0, 115).addCuboid(3.975F, -21.025F, -21.65F, 32.0F, 3.0F, 1.0F, 0.0F, false);

        ModelPart cube_r1 = new ModelPart(this);
        cube_r1.setPivot(8.975F, -24.975F, -12.725F);
        Body.addChild(cube_r1);
        setRotationAngle(cube_r1, -2.3387F, 0.0F, 0.0F);
        cube_r1.setTextureOffset(0, 115).addCuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F, 0.0F, false);

        ModelPart cube_r2 = new ModelPart(this);
        cube_r2.setPivot(36.0F, -15.9F, 4.0F);
        Body.addChild(cube_r2);
        setRotationAngle(cube_r2, 1.5708F, 0.0F, 0.0F);
        cube_r2.setTextureOffset(194, 24).addCuboid(-2.0F, -9.0F, 0.0F, 2.0F, 14.0F, 1.0F, 0.0F, false);
        cube_r2.setTextureOffset(197, 16).addCuboid(-32.025F, -9.0F, 0.0F, 2.0F, 14.0F, 1.0F, 0.0F, false);

        ModelPart cube_r3 = new ModelPart(this);
        cube_r3.setPivot(36.0F, -31.45F, 23.35F);
        Body.addChild(cube_r3);
        setRotationAngle(cube_r3, -1.5708F, 0.0F, 0.0F);
        cube_r3.setTextureOffset(186, 20).addCuboid(-2.0F, -9.0F, 0.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);

        ModelPart cube_r4 = new ModelPart(this);
        cube_r4.setPivot(4.975F, -31.45F, 23.15F);
        Body.addChild(cube_r4);
        setRotationAngle(cube_r4, -1.5708F, 0.0F, 0.0F);
        cube_r4.setTextureOffset(184, 30).addCuboid(-1.0F, -9.0F, 0.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);

        ModelPart cube_r5 = new ModelPart(this);
        cube_r5.setPivot(36.0F, -31.9F, 32.175F);
        Body.addChild(cube_r5);
        setRotationAngle(cube_r5, -0.7854F, 0.0F, 0.0F);
        cube_r5.setTextureOffset(206, 16).addCuboid(-2.0F, -18.0F, 0.0F, 2.0F, 19.0F, 1.0F, 0.0F, false);
        cube_r5.setTextureOffset(227, 22).addCuboid(-32.025F, -18.0F, 0.0F, 2.0F, 19.0F, 1.0F, 0.0F, false);

        ModelPart cube_r6 = new ModelPart(this);
        cube_r6.setPivot(36.0F, -16.6F, 8.475F);
        Body.addChild(cube_r6);
        setRotationAngle(cube_r6, -0.7854F, 0.0F, 0.0F);
        cube_r6.setTextureOffset(192, 20).addCuboid(-2.0F, -21.0F, 0.0F, 2.0F, 21.0F, 1.0F, 0.0F, false);

        ModelPart cube_r7 = new ModelPart(this);
        cube_r7.setPivot(4.975F, -16.6F, 8.275F);
        Body.addChild(cube_r7);
        setRotationAngle(cube_r7, -0.7854F, 0.0F, 0.0F);
        cube_r7.setTextureOffset(189, 15).addCuboid(-1.0F, -21.0F, 0.0F, 2.0F, 21.0F, 1.0F, 0.0F, false);

        ModelPart cube_r8 = new ModelPart(this);
        cube_r8.setPivot(32.975F, -33.05F, 50.35F);
        Body.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.48F, 0.0F, 0.0F);
        cube_r8.setTextureOffset(70, 99).addCuboid(-27.0F, -8.0F, -1.0F, 28.0F, 6.0F, 2.0F, 0.0F, false);

        ModelPart cube_r9 = new ModelPart(this);
        cube_r9.setPivot(34.875F, -33.95F, 49.95F);
        Body.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.5236F, 0.0F, 0.0F);
        cube_r9.setTextureOffset(190, 18).addCuboid(-1.0F, -11.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

        ModelPart cube_r10 = new ModelPart(this);
        cube_r10.setPivot(5.075F, -33.85F, 49.95F);
        Body.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.5236F, 0.0F, 0.0F);
        cube_r10.setTextureOffset(191, 28).addCuboid(-1.0F, -11.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

        ModelPart cube_r11 = new ModelPart(this);
        cube_r11.setPivot(4.975F, -22.55F, 44.1F);
        Body.addChild(cube_r11);
        setRotationAngle(cube_r11, -0.3142F, 0.0F, 0.0F);
        cube_r11.setTextureOffset(0, 99).addCuboid(-1.0F, -14.0F, 0.0F, 32.0F, 14.0F, 2.0F, 0.0F, false);

        ModelPart cube_r12 = new ModelPart(this);
        cube_r12.setPivot(4.975F, -13.45F, 34.625F);
        Body.addChild(cube_r12);
        setRotationAngle(cube_r12, -0.7854F, 0.0F, 0.0F);
        cube_r12.setTextureOffset(0, 99).addCuboid(-1.0F, -14.0F, 0.0F, 32.0F, 14.0F, 2.0F, 0.0F, false);

        ModelPart cube_r13 = new ModelPart(this);
        cube_r13.setPivot(4.975F, -15.9F, -5.0F);
        Body.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.7854F, 0.0F, 0.0F);
        cube_r13.setTextureOffset(0, 115).addCuboid(-1.0F, -9.0F, 0.0F, 32.0F, 9.0F, 1.0F, 0.0F, false);

        ModelPart cube_r14 = new ModelPart(this);
        cube_r14.setPivot(8.975F, -25.825F, -15.575F);
        Body.addChild(cube_r14);
        setRotationAngle(cube_r14, -1.8588F, 0.0F, 0.0F);
        cube_r14.setTextureOffset(0, 115).addCuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F, 0.0F, false);

        ModelPart cube_r15 = new ModelPart(this);
        cube_r15.setPivot(8.975F, -25.9F, -18.55F);
        Body.addChild(cube_r15);
        setRotationAngle(cube_r15, -1.597F, 0.0F, 0.0F);
        cube_r15.setTextureOffset(0, 115).addCuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F, 0.0F, false);

        ModelPart cube_r16 = new ModelPart(this);
        cube_r16.setPivot(8.975F, -23.85F, -20.75F);
        Body.addChild(cube_r16);
        setRotationAngle(cube_r16, -0.6981F, 0.0F, 0.0F);
        cube_r16.setTextureOffset(0, 115).addCuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F, 0.0F, false);

        ModelPart cube_r17 = new ModelPart(this);
        cube_r17.setPivot(8.975F, -21.0F, -21.65F);
        Body.addChild(cube_r17);
        setRotationAngle(cube_r17, -0.3054F, 0.0F, 0.0F);
        cube_r17.setTextureOffset(0, 115).addCuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F, 0.0F, false);

        ModelPart cube_r18 = new ModelPart(this);
        cube_r18.setPivot(8.975F, -15.225F, -21.025F);
        Body.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.2182F, 0.0F, 0.0F);
        cube_r18.setTextureOffset(0, 115).addCuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F, 0.0F, false);

        ModelPart cube_r19 = new ModelPart(this);
        cube_r19.setPivot(8.975F, -13.025F, -19.0F);
        Body.addChild(cube_r19);
        setRotationAngle(cube_r19, 0.7418F, 0.0F, 0.0F);
        cube_r19.setTextureOffset(0, 115).addCuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F, 0.0F, false);

        Skate = new ModelPart(this);
        Skate.setPivot(1.85F, 27.4F, -0.05F);
        setRotationAngle(Skate, 0.0F, 0.0F, 0.3927F);
        Skate.setTextureOffset(0, 181).addCuboid(-20.6F, -1.0F, -42.3F, 1.0F, 1.0F, 75.0F, 0.0F, false);
        Skate.setTextureOffset(0, 245).addCuboid(-20.55F, -9.0F, 0.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);
        Skate.setTextureOffset(0, 245).addCuboid(-20.55F, -9.0F, -20.875F, 1.0F, 9.0F, 1.0F, 0.0F, false);
        Skate.setTextureOffset(0, 245).addCuboid(-20.55F, -9.0F, 20.725F, 1.0F, 9.0F, 1.0F, 0.0F, false);

        ModelPart cube_r20 = new ModelPart(this);
        cube_r20.setPivot(-19.55F, 0.0F, 0.0F);
        Skate.addChild(cube_r20);
        setRotationAngle(cube_r20, -1.1781F, 0.0F, 0.0F);
        cube_r20.setTextureOffset(4, 232).addCuboid(-1.006F, -23.3268F, -0.5471F, 1.0F, 22.0F, 1.0F, 0.0F, false);
        cube_r20.setTextureOffset(4, 232).addCuboid(-1.006F, -4.0409F, -8.5356F, 1.0F, 22.0F, 1.0F, 0.0F, false);

        ModelPart cube_r21 = new ModelPart(this);
        cube_r21.setPivot(-19.6F, -1.575F, -43.125F);
        Skate.addChild(cube_r21);
        setRotationAngle(cube_r21, -0.6981F, 0.0F, 0.0F);
        cube_r21.setTextureOffset(71, 251).addCuboid(-1.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        ModelPart cube_r22 = new ModelPart(this);
        cube_r22.setPivot(-19.6F, -4.325F, -45.425F);
        Skate.addChild(cube_r22);
        setRotationAngle(cube_r22, -1.1345F, 0.0F, 0.0F);
        cube_r22.setTextureOffset(71, 251).addCuboid(-1.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        ModelPart cube_r23 = new ModelPart(this);
        cube_r23.setPivot(-19.6F, -7.8F, -46.275F);
        Skate.addChild(cube_r23);
        setRotationAngle(cube_r23, -1.6144F, 0.0F, 0.0F);
        cube_r23.setTextureOffset(71, 251).addCuboid(-1.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        ModelPart cube_r24 = new ModelPart(this);
        cube_r24.setPivot(-19.6F, -11.2F, -45.375F);
        Skate.addChild(cube_r24);
        setRotationAngle(cube_r24, -2.138F, 0.0F, 0.0F);
        cube_r24.setTextureOffset(71, 251).addCuboid(-1.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        ModelPart cube_r25 = new ModelPart(this);
        cube_r25.setPivot(-19.6F, -13.45F, -42.9F);
        Skate.addChild(cube_r25);
        setRotationAngle(cube_r25, -2.7925F, 0.0F, 0.0F);
        cube_r25.setTextureOffset(71, 251).addCuboid(-1.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        ModelPart cube_r26 = new ModelPart(this);
        cube_r26.setPivot(-19.6F, -13.85F, -39.5F);
        Skate.addChild(cube_r26);
        setRotationAngle(cube_r26, 2.9234F, 0.0F, 0.0F);
        cube_r26.setTextureOffset(67, 247).addCuboid(-1.0F, -0.338F, -6.3285F, 1.0F, 1.0F, 8.0F, 0.0F, false);

        ModelPart cube_r27 = new ModelPart(this);
        cube_r27.setPivot(-19.6F, -2.075F, 36.6F);
        Skate.addChild(cube_r27);
        setRotationAngle(cube_r27, -0.6109F, 0.0F, 0.0F);
        cube_r27.setTextureOffset(74, 250).addCuboid(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        ModelPart cube_r28 = new ModelPart(this);
        cube_r28.setPivot(-19.6F, -0.95F, 32.375F);
        Skate.addChild(cube_r28);
        setRotationAngle(cube_r28, -1.2654F, 0.0F, 0.0F);
        cube_r28.setTextureOffset(74, 250).addCuboid(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        Skate2 = new ModelPart(this);
        Skate2.setPivot(-1.25F, 27.4F, -0.05F);
        setRotationAngle(Skate2, 0.0F, 0.0F, -0.3927F);
        Skate2.setTextureOffset(0, 177).addCuboid(19.6F, -1.0F, -42.3F, 1.0F, 1.0F, 75.0F, 0.0F, false);
        Skate2.setTextureOffset(0, 245).addCuboid(19.55F, -9.0F, -20.875F, 1.0F, 9.0F, 1.0F, 0.0F, false);
        Skate2.setTextureOffset(0, 245).addCuboid(19.55F, -9.0F, -0.075F, 1.0F, 9.0F, 1.0F, 0.0F, false);
        Skate2.setTextureOffset(0, 245).addCuboid(19.55F, -9.0F, 20.725F, 1.0F, 9.0F, 1.0F, 0.0F, false);

        ModelPart cube_r29 = new ModelPart(this);
        cube_r29.setPivot(19.55F, 0.0F, 0.0F);
        Skate2.addChild(cube_r29);
        setRotationAngle(cube_r29, -1.1781F, 0.0F, 0.0F);
        cube_r29.setTextureOffset(4, 232).addCuboid(0.006F, -22.2576F, -0.5758F, 1.0F, 21.0F, 1.0F, 0.0F, false);
        cube_r29.setTextureOffset(4, 232).addCuboid(0.006F, -3.0409F, -8.5356F, 1.0F, 21.0F, 1.0F, 0.0F, false);

        ModelPart cube_r30 = new ModelPart(this);
        cube_r30.setPivot(19.6F, -1.575F, -43.125F);
        Skate2.addChild(cube_r30);
        setRotationAngle(cube_r30, -0.6981F, 0.0F, 0.0F);
        cube_r30.setTextureOffset(71, 251).addCuboid(0.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        ModelPart cube_r31 = new ModelPart(this);
        cube_r31.setPivot(19.6F, -4.325F, -45.425F);
        Skate2.addChild(cube_r31);
        setRotationAngle(cube_r31, -1.1345F, 0.0F, 0.0F);
        cube_r31.setTextureOffset(71, 251).addCuboid(0.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        ModelPart cube_r32 = new ModelPart(this);
        cube_r32.setPivot(19.6F, -7.8F, -46.275F);
        Skate2.addChild(cube_r32);
        setRotationAngle(cube_r32, -1.6144F, 0.0F, 0.0F);
        cube_r32.setTextureOffset(71, 251).addCuboid(0.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        ModelPart cube_r33 = new ModelPart(this);
        cube_r33.setPivot(19.6F, -11.2F, -45.375F);
        Skate2.addChild(cube_r33);
        setRotationAngle(cube_r33, -2.138F, 0.0F, 0.0F);
        cube_r33.setTextureOffset(71, 251).addCuboid(0.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        ModelPart cube_r34 = new ModelPart(this);
        cube_r34.setPivot(19.6F, -13.45F, -42.9F);
        Skate2.addChild(cube_r34);
        setRotationAngle(cube_r34, -2.7925F, 0.0F, 0.0F);
        cube_r34.setTextureOffset(71, 251).addCuboid(0.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        ModelPart cube_r35 = new ModelPart(this);
        cube_r35.setPivot(19.6F, -13.85F, -39.5F);
        Skate2.addChild(cube_r35);
        setRotationAngle(cube_r35, 2.9234F, 0.0F, 0.0F);
        cube_r35.setTextureOffset(67, 247).addCuboid(0.0F, -0.338F, -6.3285F, 1.0F, 1.0F, 8.0F, 0.0F, false);

        ModelPart cube_r36 = new ModelPart(this);
        cube_r36.setPivot(19.6F, -2.075F, 36.6F);
        Skate2.addChild(cube_r36);
        setRotationAngle(cube_r36, -0.6109F, 0.0F, 0.0F);
        cube_r36.setTextureOffset(74, 250).addCuboid(0.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        ModelPart cube_r37 = new ModelPart(this);
        cube_r37.setPivot(19.6F, -0.95F, 32.375F);
        Skate2.addChild(cube_r37);
        setRotationAngle(cube_r37, -1.2654F, 0.0F, 0.0F);
        cube_r37.setTextureOffset(74, 250).addCuboid(0.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        Chest = new ModelPart(this);
        Chest.setPivot(0.0F, 10.0F, 16.55F);
        Chest.setTextureOffset(152, 66).addCuboid(-13.5F, -10.15F, -6.05F, 28.0F, 5.0F, 23.0F, 0.0F, false);
        Chest.setTextureOffset(168, 82).addCuboid(-13.5F, -15.15F, 15.45F, 28.0F, 5.0F, 7.0F, 0.0F, false);
        Chest.setTextureOffset(194, 56).addCuboid(-14.0F, -25.15F, 22.25F, 29.0F, 8.0F, 2.0F, 0.0F, false);
        Chest.setTextureOffset(164, 116).addCuboid(-13.5F, -17.15F, 0.95F, 28.0F, 12.0F, 4.0F, 0.0F, false);
        Chest.setTextureOffset(166, 116).addCuboid(-13.5F, -24.15F, 20.95F, 28.0F, 12.0F, 2.0F, 0.0F, false);
        Chest.setTextureOffset(230, 116).addCuboid(-1.0F, -14.15F, -5.05F, 3.0F, 4.0F, 6.0F, 0.0F, false);
        Chest.setTextureOffset(230, 116).addCuboid(-1.0F, -19.15F, 16.25F, 3.0F, 4.0F, 6.0F, 0.0F, false);
        Chest.setTextureOffset(152, 94).addCuboid(-14.0F, -6.0F, -4.0F, 29.0F, 6.0F, 16.0F, 0.0F, false);

        Wall = new ModelPart(this);
        Wall.setPivot(0.0F, 24.0F, 0.0F);
        Wall.setTextureOffset(0, 0).addCuboid(15.5F, -43.0F, -28.0F, 0.0F, 29.0F, 70.0F, 0.0F, false);
        Wall.setTextureOffset(0, 0).addCuboid(14.5F, -43.0F, -28.0F, 0.0F, 29.0F, 70.0F, 0.0F, false);
        Wall.setTextureOffset(0, 0).addCuboid(-15.0F, -43.0F, -28.0F, 0.0F, 29.0F, 70.0F, 0.0F, false);
        Wall.setTextureOffset(0, 0).addCuboid(-13.7F, -43.0F, -28.0F, 0.0F, 29.0F, 70.0F, 0.0F, false);

        Loop = new ModelPart(this);
        Loop.setPivot(-14.2F, 23.625F, 11.975F);
        setRotationAngle(Loop, 0.2618F, 0.0F, 0.0F);
        Loop.setTextureOffset(162, 100).addCuboid(-1.0F, -35.05F, -32.525F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        Loop.setTextureOffset(162, 100).addCuboid(-1.0F, -36.45F, -32.525F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Loop.setTextureOffset(162, 100).addCuboid(-0.3F, -35.75F, -32.525F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Loop.setTextureOffset(162, 100).addCuboid(-1.7F, -35.75F, -32.525F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r38 = new ModelPart(this);
        cube_r38.setPivot(0.0F, -35.025F, -32.525F);
        Loop.addChild(cube_r38);
        setRotationAngle(cube_r38, 0.0F, 0.0F, 0.7854F);
        cube_r38.setTextureOffset(162, 100).addCuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r39 = new ModelPart(this);
        cube_r39.setPivot(-1.0F, -35.025F, -32.525F);
        Loop.addChild(cube_r39);
        setRotationAngle(cube_r39, 0.0F, 0.0F, 0.7854F);
        cube_r39.setTextureOffset(162, 100).addCuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r40 = new ModelPart(this);
        cube_r40.setPivot(0.0F, -34.05F, -32.525F);
        Loop.addChild(cube_r40);
        setRotationAngle(cube_r40, 0.0F, 0.0F, 0.7854F);
        cube_r40.setTextureOffset(162, 100).addCuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r41 = new ModelPart(this);
        cube_r41.setPivot(-1.0F, -34.05F, -32.525F);
        Loop.addChild(cube_r41);
        setRotationAngle(cube_r41, 0.0F, 0.0F, 0.7854F);
        cube_r41.setTextureOffset(162, 100).addCuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        Loop2 = new ModelPart(this);
        Loop2.setPivot(16.0F, 23.625F, 11.975F);
        setRotationAngle(Loop2, 0.2618F, 0.0F, 0.0F);
        Loop2.setTextureOffset(167, 98).addCuboid(-1.0F, -35.05F, -32.525F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        Loop2.setTextureOffset(167, 98).addCuboid(-1.0F, -36.45F, -32.525F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Loop2.setTextureOffset(167, 98).addCuboid(-0.3F, -35.75F, -32.525F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Loop2.setTextureOffset(167, 98).addCuboid(-1.7F, -35.75F, -32.525F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r42 = new ModelPart(this);
        cube_r42.setPivot(0.0F, -35.025F, -32.525F);
        Loop2.addChild(cube_r42);
        setRotationAngle(cube_r42, 0.0F, 0.0F, 0.7854F);
        cube_r42.setTextureOffset(167, 98).addCuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r43 = new ModelPart(this);
        cube_r43.setPivot(-1.0F, -35.025F, -32.525F);
        Loop2.addChild(cube_r43);
        setRotationAngle(cube_r43, 0.0F, 0.0F, 0.7854F);
        cube_r43.setTextureOffset(167, 98).addCuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r44 = new ModelPart(this);
        cube_r44.setPivot(0.0F, -34.05F, -32.525F);
        Loop2.addChild(cube_r44);
        setRotationAngle(cube_r44, 0.0F, 0.0F, 0.7854F);
        cube_r44.setTextureOffset(167, 98).addCuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r45 = new ModelPart(this);
        cube_r45.setPivot(-1.0F, -34.05F, -32.525F);
        Loop2.addChild(cube_r45);
        setRotationAngle(cube_r45, 0.0F, 0.0F, 0.7854F);
        cube_r45.setTextureOffset(167, 98).addCuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        Engine = new ModelPart(this);
        Engine.setPivot(0.0F, 24.0F, 0.0F);
        Engine.setTextureOffset(154, 132).addCuboid(-1.0F, -6.0F, 13.0F, 3.0F, 1.0F, 20.0F, 0.0F, false);
        Engine.setTextureOffset(177, 140).addCuboid(-1.0F, -7.0F, -6.0F, 3.0F, 1.0F, 20.0F, 0.0F, false);
        Engine.setTextureOffset(190, 141).addCuboid(-1.0F, -12.25F, 13.0F, 3.0F, 1.0F, 20.0F, 0.0F, false);
        Engine.setTextureOffset(166, 143).addCuboid(-1.0F, -11.25F, -6.0F, 3.0F, 1.0F, 20.0F, 0.0F, false);
        Engine.setTextureOffset(153, 195).addCuboid(-2.5F, -11.5F, 30.75F, 6.0F, 6.0F, 1.0F, 0.0F, false);
        Engine.setTextureOffset(178, 133).addCuboid(-1.0F, -10.15F, -14.0F, 3.0F, 3.0F, 36.0F, 0.0F, false);

        ModelPart cube_r46 = new ModelPart(this);
        cube_r46.setPivot(5.0F, -11.1F, -2.25F);
        Engine.addChild(cube_r46);
        setRotationAngle(cube_r46, 0.0F, 0.0F, -0.7854F);
        cube_r46.setTextureOffset(181, 150).addCuboid(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r47 = new ModelPart(this);
        cube_r47.setPivot(5.0F, -11.2F, 6.75F);
        Engine.addChild(cube_r47);
        setRotationAngle(cube_r47, 0.0F, 0.0F, -0.7854F);
        cube_r47.setTextureOffset(77, 73).addCuboid(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r47.setTextureOffset(91, 73).addCuboid(-2.0F, -1.0F, 7.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r47.setTextureOffset(115, 73).addCuboid(-2.0F, -1.0F, 13.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r48 = new ModelPart(this);
        cube_r48.setPivot(-3.0F, -10.2F, 25.75F);
        Engine.addChild(cube_r48);
        setRotationAngle(cube_r48, 0.0F, 0.0F, 0.7854F);
        cube_r48.setTextureOffset(103, 73).addCuboid(-4.0F, -1.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r48.setTextureOffset(168, 139).addCuboid(-4.0F, -1.0F, -28.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r48.setTextureOffset(189, 156).addCuboid(-4.0F, -1.0F, -19.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r48.setTextureOffset(103, 18).addCuboid(-4.0F, -1.0F, -12.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r48.setTextureOffset(198, 154).addCuboid(-4.0F, -1.0F, -6.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r49 = new ModelPart(this);
        cube_r49.setPivot(4.6F, -10.7F, 6.75F);
        Engine.addChild(cube_r49);
        setRotationAngle(cube_r49, 0.0F, 0.0F, -0.7854F);
        cube_r49.setTextureOffset(189, 156).addCuboid(-4.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r50 = new ModelPart(this);
        cube_r50.setPivot(5.0F, -10.2F, 13.75F);
        Engine.addChild(cube_r50);
        setRotationAngle(cube_r50, 0.0F, 0.0F, -0.7854F);
        cube_r50.setTextureOffset(103, 18).addCuboid(-4.0F, -1.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r51 = new ModelPart(this);
        cube_r51.setPivot(4.6929F, -11.6142F, 20.25F);
        Engine.addChild(cube_r51);
        setRotationAngle(cube_r51, 0.0F, 0.0F, -0.7854F);
        cube_r51.setTextureOffset(198, 154).addCuboid(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        ModelPart cube_r52 = new ModelPart(this);
        cube_r52.setPivot(-1.125F, -8.125F, 13.0F);
        Engine.addChild(cube_r52);
        setRotationAngle(cube_r52, 0.0F, 0.0F, -1.5708F);
        cube_r52.setTextureOffset(169, 142).addCuboid(-1.0F, -1.0F, -19.0F, 3.0F, 1.0F, 20.0F, 0.0F, false);

        ModelPart cube_r53 = new ModelPart(this);
        cube_r53.setPivot(-2.125F, -8.125F, 32.0F);
        Engine.addChild(cube_r53);
        setRotationAngle(cube_r53, 0.0F, 0.0F, -1.5708F);
        cube_r53.setTextureOffset(174, 146).addCuboid(-1.0F, -1.0F, -19.0F, 3.0F, 1.0F, 20.0F, 0.0F, false);

        ModelPart cube_r54 = new ModelPart(this);
        cube_r54.setPivot(0.0F, -6.7F, 13.1F);
        Engine.addChild(cube_r54);
        setRotationAngle(cube_r54, 0.0F, 0.0F, -2.3562F);
        cube_r54.setTextureOffset(171, 172).addCuboid(0.0F, -1.0F, -19.0F, 2.0F, 1.0F, 20.0F, 0.0F, false);

        ModelPart cube_r55 = new ModelPart(this);
        cube_r55.setPivot(2.4F, -8.125F, 13.1F);
        Engine.addChild(cube_r55);
        setRotationAngle(cube_r55, 0.0F, 0.0F, 2.3562F);
        cube_r55.setTextureOffset(158, 173).addCuboid(0.0F, -1.0F, -19.0F, 2.0F, 1.0F, 19.0F, 0.0F, false);

        ModelPart cube_r56 = new ModelPart(this);
        cube_r56.setPivot(-0.7F, -11.25F, 13.1F);
        Engine.addChild(cube_r56);
        setRotationAngle(cube_r56, 0.0F, 0.0F, 2.3562F);
        cube_r56.setTextureOffset(161, 174).addCuboid(0.0F, -1.0F, -19.0F, 2.0F, 1.0F, 20.0F, 0.0F, false);

        ModelPart cube_r57 = new ModelPart(this);
        cube_r57.setPivot(3.125F, -9.825F, 13.1F);
        Engine.addChild(cube_r57);
        setRotationAngle(cube_r57, 0.0F, 0.0F, -2.3562F);
        cube_r57.setTextureOffset(167, 174).addCuboid(0.0F, -1.0F, -19.0F, 2.0F, 1.0F, 20.0F, 0.0F, false);

        ModelPart cube_r58 = new ModelPart(this);
        cube_r58.setPivot(3.125F, -8.125F, 13.0F);
        Engine.addChild(cube_r58);
        setRotationAngle(cube_r58, 0.0F, 0.0F, -1.5708F);
        cube_r58.setTextureOffset(186, 141).addCuboid(-1.0F, -1.0F, -19.0F, 3.0F, 1.0F, 20.0F, 0.0F, false);

        ModelPart cube_r59 = new ModelPart(this);
        cube_r59.setPivot(4.125F, -8.125F, 32.0F);
        Engine.addChild(cube_r59);
        setRotationAngle(cube_r59, 0.0F, 0.0F, -1.5708F);
        cube_r59.setTextureOffset(167, 138).addCuboid(-1.0F, -1.0F, -19.0F, 3.0F, 1.0F, 20.0F, 0.0F, false);

        ModelPart cube_r60 = new ModelPart(this);
        cube_r60.setPivot(2.7F, -11.55F, 32.0F);
        Engine.addChild(cube_r60);
        setRotationAngle(cube_r60, 0.0F, 0.0F, 0.7854F);
        cube_r60.setTextureOffset(186, 141).addCuboid(-1.0F, 0.0F, -19.0F, 3.0F, 1.0F, 20.0F, 0.0F, false);

        ModelPart cube_r61 = new ModelPart(this);
        cube_r61.setPivot(2.7F, -5.7F, 32.0F);
        Engine.addChild(cube_r61);
        setRotationAngle(cube_r61, 0.0F, 0.0F, -0.7854F);
        cube_r61.setTextureOffset(162, 147).addCuboid(-1.0F, -1.0F, -19.0F, 3.0F, 1.0F, 20.0F, 0.0F, false);

        ModelPart cube_r62 = new ModelPart(this);
        cube_r62.setPivot(-1.7F, -11.55F, 32.0F);
        Engine.addChild(cube_r62);
        setRotationAngle(cube_r62, 0.0F, 0.0F, -0.7854F);
        cube_r62.setTextureOffset(188, 136).addCuboid(-2.0F, 0.0F, -19.0F, 3.0F, 1.0F, 20.0F, 0.0F, false);

        ModelPart cube_r63 = new ModelPart(this);
        cube_r63.setPivot(-1.7F, -5.7F, 32.0F);
        Engine.addChild(cube_r63);
        setRotationAngle(cube_r63, 0.0F, 0.0F, 0.7854F);
        cube_r63.setTextureOffset(202, 143).addCuboid(-2.0F, -1.0F, -19.0F, 3.0F, 1.0F, 20.0F, 0.0F, false);

        Detailing = new ModelPart(this);
        Detailing.setPivot(0.0F, 24.0F, 0.0F);


        ModelPart cube_r64 = new ModelPart(this);
        cube_r64.setPivot(16.25F, -21.0F, 21.0F);
        Detailing.addChild(cube_r64);
        setRotationAngle(cube_r64, -0.7854F, 0.0F, 0.0F);
        cube_r64.setTextureOffset(8, 224).addCuboid(-1.0F, -20.0F, 0.0F, 1.0F, 30.0F, 1.0F, 0.0F, false);

        ModelPart cube_r65 = new ModelPart(this);
        cube_r65.setPivot(16.25F, -21.0F, 26.0F);
        Detailing.addChild(cube_r65);
        setRotationAngle(cube_r65, -0.7854F, 0.0F, 0.0F);
        cube_r65.setTextureOffset(8, 236).addCuboid(-1.0F, -8.0F, 0.0F, 1.0F, 18.0F, 1.0F, 0.0F, false);

        ModelPart cube_r66 = new ModelPart(this);
        cube_r66.setPivot(16.25F, -21.0F, 16.0F);
        Detailing.addChild(cube_r66);
        setRotationAngle(cube_r66, -0.7854F, 0.0F, 0.0F);
        cube_r66.setTextureOffset(8, 243).addCuboid(-1.0F, -1.0F, 0.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);

        Detailing2 = new ModelPart(this);
        Detailing2.setPivot(-30.75F, 24.0F, 0.0F);


        ModelPart cube_r67 = new ModelPart(this);
        cube_r67.setPivot(16.25F, -21.0F, 21.0F);
        Detailing2.addChild(cube_r67);
        setRotationAngle(cube_r67, -0.7854F, 0.0F, 0.0F);
        cube_r67.setTextureOffset(8, 224).addCuboid(-1.0F, -20.0F, 0.0F, 1.0F, 30.0F, 1.0F, 0.0F, false);

        ModelPart cube_r68 = new ModelPart(this);
        cube_r68.setPivot(16.25F, -21.0F, 26.0F);
        Detailing2.addChild(cube_r68);
        setRotationAngle(cube_r68, -0.7854F, 0.0F, 0.0F);
        cube_r68.setTextureOffset(8, 236).addCuboid(-1.0F, -8.0F, 0.0F, 1.0F, 18.0F, 1.0F, 0.0F, false);

        ModelPart cube_r69 = new ModelPart(this);
        cube_r69.setPivot(16.25F, -21.0F, 16.0F);
        Detailing2.addChild(cube_r69);
        setRotationAngle(cube_r69, -0.7854F, 0.0F, 0.0F);
        cube_r69.setTextureOffset(8, 243).addCuboid(-1.0F, -1.0F, 0.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }


    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        Body.render(matrixStack, buffer, packedLight, packedOverlay);
        Skate.render(matrixStack, buffer, packedLight, packedOverlay);
        Skate2.render(matrixStack, buffer, packedLight, packedOverlay);
        Chest.render(matrixStack, buffer, packedLight, packedOverlay);
        Wall.render(matrixStack, buffer, packedLight, packedOverlay);
        Loop.render(matrixStack, buffer, packedLight, packedOverlay);
        Loop2.render(matrixStack, buffer, packedLight, packedOverlay);
        Engine.render(matrixStack, buffer, packedLight, packedOverlay);
        Detailing.render(matrixStack, buffer, packedLight, packedOverlay);
        Detailing2.render(matrixStack, buffer, packedLight, packedOverlay);
    }


    public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.pitch = x;
        modelRenderer.yaw = y;
        modelRenderer.roll = z;
    }
}
