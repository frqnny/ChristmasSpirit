package io.github.frqnny.cspirit.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class SleighModel extends EntityModel<Entity> {

    private final ModelPart body;
    private final ModelPart skate;
    private final ModelPart skate2;
    private final ModelPart chest;
    private final ModelPart wall;
    private final ModelPart loop;
    private final ModelPart loop2;
    private final ModelPart engine;
    private final ModelPart detailing;
    private final ModelPart detailing2;

    public SleighModel(ModelPart root) {
        chest = root.getChild("chest");
        detailing = root.getChild("detailing");
        loop2 = root.getChild("loop2");
        detailing2 = root.getChild("detailing2");
        engine = root.getChild("engine");
        skate = root.getChild("skate");
        wall = root.getChild("wall");
        body = root.getChild("body");
        skate2 = root.getChild("skate2");
        loop = root.getChild("loop");

    }


    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        root.addChild("chest",
                ModelPartBuilder.create()
                        .uv(152, 66).cuboid(-13.5F, -10.15F, -6.05F, 28.0F, 5.0F, 23.0F)
                        .uv(168, 82).cuboid(-13.5F, -15.15F, 15.45F, 28.0F, 5.0F, 7.0F)
                        .uv(194, 56).cuboid(-14.0F, -25.15F, 22.25F, 29.0F, 8.0F, 2.0F)
                        .uv(164, 116).cuboid(-13.5F, -17.15F, 0.95F, 28.0F, 12.0F, 4.0F)
                        .uv(166, 116).cuboid(-13.5F, -24.15F, 20.95F, 28.0F, 12.0F, 2.0F)
                        .uv(230, 116).cuboid(-1.0F, -14.15F, -5.05F, 3.0F, 4.0F, 6.0F)
                        .cuboid(-1.0F, -19.15F, 16.25F, 3.0F, 4.0F, 6.0F)
                        .uv(152, 94).cuboid(-14.0F, -6.0F, -4.0F, 29.0F, 6.0F, 16.0F),
                ModelTransform.of(0.0F, 10.0F, 16.55F, 0.0F, 0.0F, 0.0F));
        ModelPartData Detailing = root.addChild("detailing",
                ModelPartBuilder.create(),
                ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        Detailing.addChild("cube_r64",
                ModelPartBuilder.create()
                        .uv(8, 224).cuboid(-1.0F, -20.0F, 0.0F, 1.0F, 30.0F, 1.0F),
                ModelTransform.of(16.25F, -21.0F, 21.0F, -0.7854F, 0.0F, 0.0F));
        Detailing.addChild("cube_r65",
                ModelPartBuilder.create()
                        .uv(8, 236).cuboid(-1.0F, -8.0F, 0.0F, 1.0F, 18.0F, 1.0F),
                ModelTransform.of(16.25F, -21.0F, 26.0F, -0.7854F, 0.0F, 0.0F));
        Detailing.addChild("cube_r66",
                ModelPartBuilder.create()
                        .uv(8, 243).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 11.0F, 1.0F),
                ModelTransform.of(16.25F, -21.0F, 16.0F, -0.7854F, 0.0F, 0.0F));
        ModelPartData Loop2 = root.addChild("loop2",
                ModelPartBuilder.create()
                        .uv(167, 98).cuboid(-1.0F, -35.05F, -32.525F, 1.0F, 2.0F, 1.0F)
                        .cuboid(-1.0F, -36.45F, -32.525F, 1.0F, 1.0F, 1.0F)
                        .cuboid(-0.3F, -35.75F, -32.525F, 1.0F, 1.0F, 1.0F)
                        .cuboid(-1.7F, -35.75F, -32.525F, 1.0F, 1.0F, 1.0F),
                ModelTransform.of(16.0F, 23.625F, 11.975F, 0.2618F, 0.0F, 0.0F));
        Loop2.addChild("cube_r42",
                ModelPartBuilder.create()
                        .uv(167, 98).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F),
                ModelTransform.of(0.0F, -35.025F, -32.525F, 0.0F, 0.0F, 0.7854F));
        Loop2.addChild("cube_r43",
                ModelPartBuilder.create()
                        .uv(167, 98).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F),
                ModelTransform.of(-1.0F, -35.025F, -32.525F, 0.0F, 0.0F, 0.7854F));
        Loop2.addChild("cube_r44",
                ModelPartBuilder.create()
                        .uv(167, 98).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F),
                ModelTransform.of(0.0F, -34.05F, -32.525F, 0.0F, 0.0F, 0.7854F));
        Loop2.addChild("cube_r45",
                ModelPartBuilder.create()
                        .uv(167, 98).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F),
                ModelTransform.of(-1.0F, -34.05F, -32.525F, 0.0F, 0.0F, 0.7854F));
        ModelPartData Detailing2 = root.addChild("detailing2",
                ModelPartBuilder.create(),
                ModelTransform.of(-30.75F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        Detailing2.addChild("cube_r67",
                ModelPartBuilder.create()
                        .uv(8, 224).cuboid(-1.0F, -20.0F, 0.0F, 1.0F, 30.0F, 1.0F),
                ModelTransform.of(16.25F, -21.0F, 21.0F, -0.7854F, 0.0F, 0.0F));
        Detailing2.addChild("cube_r68",
                ModelPartBuilder.create()
                        .uv(8, 236).cuboid(-1.0F, -8.0F, 0.0F, 1.0F, 18.0F, 1.0F),
                ModelTransform.of(16.25F, -21.0F, 26.0F, -0.7854F, 0.0F, 0.0F));
        Detailing2.addChild("cube_r69",
                ModelPartBuilder.create()
                        .uv(8, 243).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 11.0F, 1.0F),
                ModelTransform.of(16.25F, -21.0F, 16.0F, -0.7854F, 0.0F, 0.0F));
        ModelPartData Engine = root.addChild("engine",
                ModelPartBuilder.create()
                        .uv(154, 132).cuboid(-1.0F, -6.0F, 13.0F, 3.0F, 1.0F, 20.0F)
                        .uv(177, 140).cuboid(-1.0F, -7.0F, -6.0F, 3.0F, 1.0F, 20.0F)
                        .uv(190, 141).cuboid(-1.0F, -12.25F, 13.0F, 3.0F, 1.0F, 20.0F)
                        .uv(166, 143).cuboid(-1.0F, -11.25F, -6.0F, 3.0F, 1.0F, 20.0F)
                        .uv(153, 195).cuboid(-2.5F, -11.5F, 30.75F, 6.0F, 6.0F, 1.0F)
                        .uv(178, 133).cuboid(-1.0F, -10.15F, -14.0F, 3.0F, 3.0F, 36.0F),
                ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        Engine.addChild("cube_r46",
                ModelPartBuilder.create()
                        .uv(181, 150).cuboid(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F),
                ModelTransform.of(5.0F, -11.1F, -2.25F, 0.0F, 0.0F, -0.7854F));
        Engine.addChild("cube_r47",
                ModelPartBuilder.create()
                        .uv(77, 73).cuboid(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F)
                        .uv(91, 73).cuboid(-2.0F, -1.0F, 7.0F, 5.0F, 1.0F, 1.0F)
                        .uv(115, 73).cuboid(-2.0F, -1.0F, 13.0F, 5.0F, 1.0F, 1.0F),
                ModelTransform.of(5.0F, -11.2F, 6.75F, 0.0F, 0.0F, -0.7854F));
        Engine.addChild("cube_r48",
                ModelPartBuilder.create()
                        .uv(103, 73).cuboid(-4.0F, -1.0F, 0.0F, 5.0F, 1.0F, 1.0F)
                        .uv(168, 139).cuboid(-4.0F, -1.0F, -28.0F, 6.0F, 1.0F, 1.0F)
                        .uv(189, 156).cuboid(-4.0F, -1.0F, -19.0F, 6.0F, 1.0F, 1.0F)
                        .uv(103, 18).cuboid(-4.0F, -1.0F, -12.0F, 5.0F, 1.0F, 1.0F)
                        .uv(198, 154).cuboid(-4.0F, -1.0F, -6.0F, 5.0F, 1.0F, 1.0F),
                ModelTransform.of(-3.0F, -10.2F, 25.75F, 0.0F, 0.0F, 0.7854F));
        Engine.addChild("cube_r49",
                ModelPartBuilder.create()
                        .uv(189, 156).cuboid(-4.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F),
                ModelTransform.of(4.6F, -10.7F, 6.75F, 0.0F, 0.0F, -0.7854F));
        Engine.addChild("cube_r50",
                ModelPartBuilder.create()
                        .uv(103, 18).cuboid(-4.0F, -1.0F, 0.0F, 5.0F, 1.0F, 1.0F),
                ModelTransform.of(5.0F, -10.2F, 13.75F, 0.0F, 0.0F, -0.7854F));
        Engine.addChild("cube_r51",
                ModelPartBuilder.create()
                        .uv(198, 154).cuboid(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F),
                ModelTransform.of(4.6929F, -11.6142F, 20.25F, 0.0F, 0.0F, -0.7854F));
        Engine.addChild("cube_r52",
                ModelPartBuilder.create()
                        .uv(169, 142).cuboid(-1.0F, -1.0F, -19.0F, 3.0F, 1.0F, 20.0F),
                ModelTransform.of(-1.125F, -8.125F, 13.0F, 0.0F, 0.0F, -1.5708F));
        Engine.addChild("cube_r53",
                ModelPartBuilder.create()
                        .uv(174, 146).cuboid(-1.0F, -1.0F, -19.0F, 3.0F, 1.0F, 20.0F),
                ModelTransform.of(-2.125F, -8.125F, 32.0F, 0.0F, 0.0F, -1.5708F));
        Engine.addChild("cube_r54",
                ModelPartBuilder.create()
                        .uv(171, 172).cuboid(0.0F, -1.0F, -19.0F, 2.0F, 1.0F, 20.0F),
                ModelTransform.of(0.0F, -6.7F, 13.1F, 0.0F, 0.0F, -2.3562F));
        Engine.addChild("cube_r55",
                ModelPartBuilder.create()
                        .uv(158, 173).cuboid(0.0F, -1.0F, -19.0F, 2.0F, 1.0F, 19.0F),
                ModelTransform.of(2.4F, -8.125F, 13.1F, 0.0F, 0.0F, 2.3562F));
        Engine.addChild("cube_r56",
                ModelPartBuilder.create()
                        .uv(161, 174).cuboid(0.0F, -1.0F, -19.0F, 2.0F, 1.0F, 20.0F),
                ModelTransform.of(-0.7F, -11.25F, 13.1F, 0.0F, 0.0F, 2.3562F));
        Engine.addChild("cube_r57",
                ModelPartBuilder.create()
                        .uv(167, 174).cuboid(0.0F, -1.0F, -19.0F, 2.0F, 1.0F, 20.0F),
                ModelTransform.of(3.125F, -9.825F, 13.1F, 0.0F, 0.0F, -2.3562F));
        Engine.addChild("cube_r58",
                ModelPartBuilder.create()
                        .uv(186, 141).cuboid(-1.0F, -1.0F, -19.0F, 3.0F, 1.0F, 20.0F),
                ModelTransform.of(3.125F, -8.125F, 13.0F, 0.0F, 0.0F, -1.5708F));
        Engine.addChild("cube_r59",
                ModelPartBuilder.create()
                        .uv(167, 138).cuboid(-1.0F, -1.0F, -19.0F, 3.0F, 1.0F, 20.0F),
                ModelTransform.of(4.125F, -8.125F, 32.0F, 0.0F, 0.0F, -1.5708F));
        Engine.addChild("cube_r60",
                ModelPartBuilder.create()
                        .uv(186, 141).cuboid(-1.0F, 0.0F, -19.0F, 3.0F, 1.0F, 20.0F),
                ModelTransform.of(2.7F, -11.55F, 32.0F, 0.0F, 0.0F, 0.7854F));
        Engine.addChild("cube_r61",
                ModelPartBuilder.create()
                        .uv(162, 147).cuboid(-1.0F, -1.0F, -19.0F, 3.0F, 1.0F, 20.0F),
                ModelTransform.of(2.7F, -5.7F, 32.0F, 0.0F, 0.0F, -0.7854F));
        Engine.addChild("cube_r62",
                ModelPartBuilder.create()
                        .uv(188, 136).cuboid(-2.0F, 0.0F, -19.0F, 3.0F, 1.0F, 20.0F),
                ModelTransform.of(-1.7F, -11.55F, 32.0F, 0.0F, 0.0F, -0.7854F));
        Engine.addChild("cube_r63",
                ModelPartBuilder.create()
                        .uv(202, 143).cuboid(-2.0F, -1.0F, -19.0F, 3.0F, 1.0F, 20.0F),
                ModelTransform.of(-1.7F, -5.7F, 32.0F, 0.0F, 0.0F, 0.7854F));
        root.addChild("wall",
                ModelPartBuilder.create()
                        .cuboid(15.5F, -43.0F, -28.0F, 0.0F, 29.0F, 70.0F)
                        .cuboid(14.5F, -43.0F, -28.0F, 0.0F, 29.0F, 70.0F)
                        .cuboid(-15.0F, -43.0F, -28.0F, 0.0F, 29.0F, 70.0F)
                        .cuboid(-13.7F, -43.0F, -28.0F, 0.0F, 29.0F, 70.0F),
                ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        ModelPartData Skate = root.addChild("skate",
                ModelPartBuilder.create()
                        .uv(0, 181).cuboid(-20.6F, -1.0F, -42.3F, 1.0F, 1.0F, 75.0F)
                        .uv(0, 245).cuboid(-20.55F, -9.0F, 0.0F, 1.0F, 9.0F, 1.0F)
                        .cuboid(-20.55F, -9.0F, -20.875F, 1.0F, 9.0F, 1.0F)
                        .cuboid(-20.55F, -9.0F, 20.725F, 1.0F, 9.0F, 1.0F),
                ModelTransform.of(1.85F, 27.4F, -0.05F, 0.0F, 0.0F, 0.3927F));
        Skate.addChild("cube_r20",
                ModelPartBuilder.create()
                        .uv(4, 232).cuboid(-1.006F, -23.3268F, -0.5471F, 1.0F, 22.0F, 1.0F)
                        .cuboid(-1.006F, -4.0409F, -8.5356F, 1.0F, 22.0F, 1.0F),
                ModelTransform.of(-19.55F, 0.0F, 0.0F, -1.1781F, 0.0F, 0.0F));
        Skate.addChild("cube_r21",
                ModelPartBuilder.create()
                        .uv(71, 251).cuboid(-1.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F),
                ModelTransform.of(-19.6F, -1.575F, -43.125F, -0.6981F, 0.0F, 0.0F));
        Skate.addChild("cube_r22",
                ModelPartBuilder.create()
                        .uv(71, 251).cuboid(-1.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F),
                ModelTransform.of(-19.6F, -4.325F, -45.425F, -1.1345F, 0.0F, 0.0F));
        Skate.addChild("cube_r23",
                ModelPartBuilder.create()
                        .uv(71, 251).cuboid(-1.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F),
                ModelTransform.of(-19.6F, -7.8F, -46.275F, -1.6144F, 0.0F, 0.0F));
        Skate.addChild("cube_r24",
                ModelPartBuilder.create()
                        .uv(71, 251).cuboid(-1.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F),
                ModelTransform.of(-19.6F, -11.2F, -45.375F, -2.138F, 0.0F, 0.0F));
        Skate.addChild("cube_r25",
                ModelPartBuilder.create()
                        .uv(71, 251).cuboid(-1.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F),
                ModelTransform.of(-19.6F, -13.45F, -42.9F, -2.7925F, 0.0F, 0.0F));
        Skate.addChild("cube_r26",
                ModelPartBuilder.create()
                        .uv(67, 247).cuboid(-1.0F, -0.338F, -6.3285F, 1.0F, 1.0F, 8.0F),
                ModelTransform.of(-19.6F, -13.85F, -39.5F, 2.9234F, 0.0F, 0.0F));
        Skate.addChild("cube_r27",
                ModelPartBuilder.create()
                        .uv(74, 250).cuboid(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F),
                ModelTransform.of(-19.6F, -2.075F, 36.6F, -0.6109F, 0.0F, 0.0F));
        Skate.addChild("cube_r28",
                ModelPartBuilder.create()
                        .uv(74, 250).cuboid(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F),
                ModelTransform.of(-19.6F, -0.95F, 32.375F, -1.2654F, 0.0F, 0.0F));
        ModelPartData Body = root.addChild("body",
                ModelPartBuilder.create()
                        .cuboid(4.0F, -14.0F, -19.0F, 32.0F, 2.0F, 55.0F)
                        .uv(0, 115).cuboid(3.975F, -21.025F, -21.65F, 32.0F, 3.0F, 1.0F),
                ModelTransform.of(-19.6F, 24.0F, -7.3F, 0.0F, 0.0F, 0.0F));
        Body.addChild("cube_r1",
                ModelPartBuilder.create()
                        .uv(0, 115).cuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F),
                ModelTransform.of(8.975F, -24.975F, -12.725F, -2.3387F, 0.0F, 0.0F));
        Body.addChild("cube_r2",
                ModelPartBuilder.create()
                        .uv(194, 24).cuboid(-2.0F, -9.0F, 0.0F, 2.0F, 14.0F, 1.0F)
                        .uv(197, 16).cuboid(-32.025F, -9.0F, 0.0F, 2.0F, 14.0F, 1.0F),
                ModelTransform.of(36.0F, -15.9F, 4.0F, 1.5708F, 0.0F, 0.0F));
        Body.addChild("cube_r3",
                ModelPartBuilder.create()
                        .uv(186, 20).cuboid(-2.0F, -9.0F, 0.0F, 2.0F, 9.0F, 1.0F),
                ModelTransform.of(36.0F, -31.45F, 23.35F, -1.5708F, 0.0F, 0.0F));
        Body.addChild("cube_r4",
                ModelPartBuilder.create()
                        .uv(184, 30).cuboid(-1.0F, -9.0F, 0.0F, 2.0F, 9.0F, 1.0F),
                ModelTransform.of(4.975F, -31.45F, 23.15F, -1.5708F, 0.0F, 0.0F));
        Body.addChild("cube_r5",
                ModelPartBuilder.create()
                        .uv(206, 16).cuboid(-2.0F, -18.0F, 0.0F, 2.0F, 19.0F, 1.0F)
                        .uv(227, 22).cuboid(-32.025F, -18.0F, 0.0F, 2.0F, 19.0F, 1.0F),
                ModelTransform.of(36.0F, -31.9F, 32.175F, -0.7854F, 0.0F, 0.0F));
        Body.addChild("cube_r6",
                ModelPartBuilder.create()
                        .uv(192, 20).cuboid(-2.0F, -21.0F, 0.0F, 2.0F, 21.0F, 1.0F),
                ModelTransform.of(36.0F, -16.6F, 8.475F, -0.7854F, 0.0F, 0.0F));
        Body.addChild("cube_r7",
                ModelPartBuilder.create()
                        .uv(189, 15).cuboid(-1.0F, -21.0F, 0.0F, 2.0F, 21.0F, 1.0F),
                ModelTransform.of(4.975F, -16.6F, 8.275F, -0.7854F, 0.0F, 0.0F));
        Body.addChild("cube_r8",
                ModelPartBuilder.create()
                        .uv(70, 99).cuboid(-27.0F, -8.0F, -1.0F, 28.0F, 6.0F, 2.0F),
                ModelTransform.of(32.975F, -33.05F, 50.35F, 0.48F, 0.0F, 0.0F));
        Body.addChild("cube_r9",
                ModelPartBuilder.create()
                        .uv(190, 18).cuboid(-1.0F, -11.0F, -1.0F, 2.0F, 10.0F, 2.0F),
                ModelTransform.of(34.875F, -33.95F, 49.95F, 0.5236F, 0.0F, 0.0F));
        Body.addChild("cube_r10",
                ModelPartBuilder.create()
                        .uv(191, 28).cuboid(-1.0F, -11.0F, -1.0F, 2.0F, 10.0F, 2.0F),
                ModelTransform.of(5.075F, -33.85F, 49.95F, 0.5236F, 0.0F, 0.0F));
        Body.addChild("cube_r11",
                ModelPartBuilder.create()
                        .uv(0, 99).cuboid(-1.0F, -14.0F, 0.0F, 32.0F, 14.0F, 2.0F),
                ModelTransform.of(4.975F, -22.55F, 44.1F, -0.3142F, 0.0F, 0.0F));
        Body.addChild("cube_r12",
                ModelPartBuilder.create()
                        .uv(0, 99).cuboid(-1.0F, -14.0F, 0.0F, 32.0F, 14.0F, 2.0F),
                ModelTransform.of(4.975F, -13.45F, 34.625F, -0.7854F, 0.0F, 0.0F));
        Body.addChild("cube_r13",
                ModelPartBuilder.create()
                        .uv(0, 115).cuboid(-1.0F, -9.0F, 0.0F, 32.0F, 9.0F, 1.0F),
                ModelTransform.of(4.975F, -15.9F, -5.0F, 0.7854F, 0.0F, 0.0F));
        Body.addChild("cube_r14",
                ModelPartBuilder.create()
                        .uv(0, 115).cuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F),
                ModelTransform.of(8.975F, -25.825F, -15.575F, -1.8588F, 0.0F, 0.0F));
        Body.addChild("cube_r15",
                ModelPartBuilder.create()
                        .uv(0, 115).cuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F),
                ModelTransform.of(8.975F, -25.9F, -18.55F, -1.597F, 0.0F, 0.0F));
        Body.addChild("cube_r16",
                ModelPartBuilder.create()
                        .uv(0, 115).cuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F),
                ModelTransform.of(8.975F, -23.85F, -20.75F, -0.6981F, 0.0F, 0.0F));
        Body.addChild("cube_r17",
                ModelPartBuilder.create()
                        .uv(0, 115).cuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F),
                ModelTransform.of(8.975F, -21.0F, -21.65F, -0.3054F, 0.0F, 0.0F));
        Body.addChild("cube_r18",
                ModelPartBuilder.create()
                        .uv(0, 115).cuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F),
                ModelTransform.of(8.975F, -15.225F, -21.025F, 0.2182F, 0.0F, 0.0F));
        Body.addChild("cube_r19",
                ModelPartBuilder.create()
                        .uv(0, 115).cuboid(-5.0F, -3.0F, 0.0F, 32.0F, 3.0F, 1.0F),
                ModelTransform.of(8.975F, -13.025F, -19.0F, 0.7418F, 0.0F, 0.0F));
        ModelPartData Loop = root.addChild("loop",
                ModelPartBuilder.create()
                        .uv(162, 100).cuboid(-1.0F, -35.05F, -32.525F, 1.0F, 2.0F, 1.0F)
                        .cuboid(-1.0F, -36.45F, -32.525F, 1.0F, 1.0F, 1.0F)
                        .cuboid(-0.3F, -35.75F, -32.525F, 1.0F, 1.0F, 1.0F)
                        .cuboid(-1.7F, -35.75F, -32.525F, 1.0F, 1.0F, 1.0F),
                ModelTransform.of(-14.2F, 23.625F, 11.975F, 0.2618F, 0.0F, 0.0F));
        Loop.addChild("cube_r38",
                ModelPartBuilder.create()
                        .uv(162, 100).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F),
                ModelTransform.of(0.0F, -35.025F, -32.525F, 0.0F, 0.0F, 0.7854F));
        Loop.addChild("cube_r39",
                ModelPartBuilder.create()
                        .uv(162, 100).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F),
                ModelTransform.of(-1.0F, -35.025F, -32.525F, 0.0F, 0.0F, 0.7854F));
        Loop.addChild("cube_r40",
                ModelPartBuilder.create()
                        .uv(162, 100).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F),
                ModelTransform.of(0.0F, -34.05F, -32.525F, 0.0F, 0.0F, 0.7854F));
        Loop.addChild("cube_r41",
                ModelPartBuilder.create()
                        .uv(162, 100).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F),
                ModelTransform.of(-1.0F, -34.05F, -32.525F, 0.0F, 0.0F, 0.7854F));
        ModelPartData Skate2 = root.addChild("skate2",
                ModelPartBuilder.create()
                        .uv(0, 177).cuboid(19.6F, -1.0F, -42.3F, 1.0F, 1.0F, 75.0F)
                        .uv(0, 245).cuboid(19.55F, -9.0F, -20.875F, 1.0F, 9.0F, 1.0F)
                        .cuboid(19.55F, -9.0F, -0.075F, 1.0F, 9.0F, 1.0F)
                        .cuboid(19.55F, -9.0F, 20.725F, 1.0F, 9.0F, 1.0F),
                ModelTransform.of(-1.25F, 27.4F, -0.05F, 0.0F, 0.0F, -0.3927F));
        Skate2.addChild("cube_r29",
                ModelPartBuilder.create()
                        .uv(4, 232).cuboid(0.006F, -22.2576F, -0.5758F, 1.0F, 21.0F, 1.0F)
                        .cuboid(0.006F, -3.0409F, -8.5356F, 1.0F, 21.0F, 1.0F),
                ModelTransform.of(19.55F, 0.0F, 0.0F, -1.1781F, 0.0F, 0.0F));
        Skate2.addChild("cube_r30",
                ModelPartBuilder.create()
                        .uv(71, 251).cuboid(0.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F),
                ModelTransform.of(19.6F, -1.575F, -43.125F, -0.6981F, 0.0F, 0.0F));
        Skate2.addChild("cube_r31",
                ModelPartBuilder.create()
                        .uv(71, 251).cuboid(0.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F),
                ModelTransform.of(19.6F, -4.325F, -45.425F, -1.1345F, 0.0F, 0.0F));
        Skate2.addChild("cube_r32",
                ModelPartBuilder.create()
                        .uv(71, 251).cuboid(0.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F),
                ModelTransform.of(19.6F, -7.8F, -46.275F, -1.6144F, 0.0F, 0.0F));
        Skate2.addChild("cube_r33",
                ModelPartBuilder.create()
                        .uv(71, 251).cuboid(0.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F),
                ModelTransform.of(19.6F, -11.2F, -45.375F, -2.138F, 0.0F, 0.0F));
        Skate2.addChild("cube_r34",
                ModelPartBuilder.create()
                        .uv(71, 251).cuboid(0.0F, -0.338F, -2.3285F, 1.0F, 1.0F, 4.0F),
                ModelTransform.of(19.6F, -13.45F, -42.9F, -2.7925F, 0.0F, 0.0F));
        Skate2.addChild("cube_r35",
                ModelPartBuilder.create()
                        .uv(67, 247).cuboid(0.0F, -0.338F, -6.3285F, 1.0F, 1.0F, 8.0F),
                ModelTransform.of(19.6F, -13.85F, -39.5F, 2.9234F, 0.0F, 0.0F));
        Skate2.addChild("cube_r36",
                ModelPartBuilder.create()
                        .uv(74, 250).cuboid(0.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F),
                ModelTransform.of(19.6F, -2.075F, 36.6F, -0.6109F, 0.0F, 0.0F));
        Skate2.addChild("cube_r37",
                ModelPartBuilder.create()
                        .uv(74, 250).cuboid(0.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F),
                ModelTransform.of(19.6F, -0.95F, 32.375F, -1.2654F, 0.0F, 0.0F));

        return TexturedModelData.of(modelData, 256, 256);
    }

    @Override
    public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }


    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        skate.render(matrixStack, buffer, packedLight, packedOverlay);
        skate2.render(matrixStack, buffer, packedLight, packedOverlay);
        chest.render(matrixStack, buffer, packedLight, packedOverlay);
        wall.render(matrixStack, buffer, packedLight, packedOverlay);
        loop.render(matrixStack, buffer, packedLight, packedOverlay);
        loop2.render(matrixStack, buffer, packedLight, packedOverlay);
        engine.render(matrixStack, buffer, packedLight, packedOverlay);
        detailing.render(matrixStack, buffer, packedLight, packedOverlay);
        detailing2.render(matrixStack, buffer, packedLight, packedOverlay);
    }


    public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.pitch = x;
        modelRenderer.yaw = y;
        modelRenderer.roll = z;
    }
}
