package io.github.frqnny.cspirit.client.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.render.entity.model.HorseEntityModel;
import net.minecraft.entity.passive.HorseBaseEntity;
import net.minecraft.util.math.MathHelper;

public class ReindeerModel<T extends HorseBaseEntity> extends HorseEntityModel<T> {

    protected final ModelPart body;
    protected final ModelPart head;
    private final ModelPart field_228262_f_;
    private final ModelPart field_228263_g_;
    private final ModelPart field_228264_h_;
    private final ModelPart field_228265_i_;
    private final ModelPart field_228266_j_;
    private final ModelPart field_228267_k_;
    private final ModelPart field_228268_l_;
    private final ModelPart field_228269_m_;
    private final ModelPart field_217133_j;
    private final ModelPart[] field_217134_k;
    private final ModelPart[] field_217135_l;

    public ReindeerModel(ModelPart root) {
        super(root);
        this.body = new ModelPart(this, 0, 32);
        this.body.addCuboid(-5.0F, -8.0F, -17.0F, 10.0F, 10.0F, 22.0F, 0.05F);
        this.body.setPivot(0.0F, 11.0F, 5.0F);
        this.head = new ModelPart(this, 0, 35);
        this.head.addCuboid(-2.05F, -6.0F, -2.0F, 4.0F, 12.0F, 7.0F);
        this.head.pivotX = ((float) Math.PI / 6F);
        head.setPivot(0.0F, 2.0F, -9.0F);
        head.setTextureOffset(52, 0).addCuboid(2.0F, -14.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(52, 0).addCuboid(-3.0F, -14.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(56, 0).addCuboid(1.0F, -15.0F, 4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(56, 0).addCuboid(-2.0F, -15.0F, 4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(56, 0).addCuboid(3.0F, -16.0F, 4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(56, 0).addCuboid(-4.0F, -16.0F, 4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(60, 0).addCuboid(4.0F, -18.0F, 5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(60, 0).addCuboid(-5.0F, -18.0F, 5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(60, 0).addCuboid(5.0F, -19.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(60, 0).addCuboid(-4.0F, -20.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(60, 0).addCuboid(3.0F, -20.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(60, 0).addCuboid(-6.0F, -19.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        ModelPart modelrenderer = new ModelPart(this, 0, 13);
        modelrenderer.addCuboid(-3.0F, -11.0F, -2.0F, 6.0F, 5.0F, 7.0F, scale);
        ModelPart modelrenderer1 = new ModelPart(this, 56, 36);
        modelrenderer1.addCuboid(-1.0F, -11.0F, 5.01F, 2.0F, 16.0F, 2.0F, scale);
        ModelPart modelrenderer2 = new ModelPart(this, 0, 25);
        modelrenderer2.addCuboid(-2.0F, -11.0F, -7.0F, 4.0F, 5.0F, 5.0F, scale);
        this.head.addChild(modelrenderer);
        this.head.addChild(modelrenderer1);
        this.head.addChild(modelrenderer2);
        this.method_2789(this.head);
        this.field_228262_f_ = new ModelPart(this, 48, 21);
        this.field_228262_f_.mirror = true;
        this.field_228262_f_.addCuboid(-3.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, scale);
        this.field_228262_f_.setPivot(4.0F, 14.0F, 7.0F);
        this.field_228263_g_ = new ModelPart(this, 48, 21);
        this.field_228263_g_.addCuboid(-1.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, scale);
        this.field_228263_g_.setPivot(-4.0F, 14.0F, 7.0F);
        this.field_228264_h_ = new ModelPart(this, 48, 21);
        this.field_228264_h_.mirror = true;
        this.field_228264_h_.addCuboid(-3.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, scale);
        this.field_228264_h_.setPivot(4.0F, 6.0F, -12.0F);
        this.field_228265_i_ = new ModelPart(this, 48, 21);
        this.field_228265_i_.addCuboid(-1.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, scale);
        this.field_228265_i_.setPivot(-4.0F, 6.0F, -12.0F);
        float f = 5.5F;
        this.field_228266_j_ = new ModelPart(this, 48, 21);
        this.field_228266_j_.mirror = true;
        this.field_228266_j_.addCuboid(-3.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, scale, scale + 5.5F, scale);
        this.field_228266_j_.setPivot(4.0F, 14.0F, 7.0F);
        this.field_228267_k_ = new ModelPart(this, 48, 21);
        this.field_228267_k_.addCuboid(-1.0F, -1.01F, -1.0F, 4.0F, 11.0F, 4.0F, scale, scale + 5.5F, scale);
        this.field_228267_k_.setPivot(-4.0F, 14.0F, 7.0F);
        this.field_228268_l_ = new ModelPart(this, 48, 21);
        this.field_228268_l_.mirror = true;
        this.field_228268_l_.addCuboid(-3.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, scale, scale + 5.5F, scale);
        this.field_228268_l_.setPivot(4.0F, 6.0F, -12.0F);
        this.field_228269_m_ = new ModelPart(this, 48, 21);
        this.field_228269_m_.addCuboid(-1.0F, -1.01F, -1.9F, 4.0F, 11.0F, 4.0F, scale, scale + 5.5F, scale);
        this.field_228269_m_.setPivot(-4.0F, 6.0F, -12.0F);
        this.field_217133_j = new ModelPart(this, 42, 36);
        this.field_217133_j.addCuboid(-1.5F, 0.0F, 0.0F, 3.0F, 14.0F, 4.0F, scale);
        this.field_217133_j.setPivot(0.0F, -5.0F, 2.0F);
        this.field_217133_j.pivotX = ((float) Math.PI / 6F);
        this.body.addChild(this.field_217133_j);
        ModelPart modelrenderer3 = new ModelPart(this, 26, 0);
        modelrenderer3.addCuboid(-5.0F, -8.0F, -9.0F, 10.0F, 9.0F, 9.0F, 0.5F);
        this.body.addChild(modelrenderer3);
        ModelPart modelrenderer4 = new ModelPart(this, 29, 5);
        modelrenderer4.addCuboid(2.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, scale);
        this.head.addChild(modelrenderer4);
        ModelPart modelrenderer5 = new ModelPart(this, 29, 5);
        modelrenderer5.addCuboid(-3.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, scale);
        this.head.addChild(modelrenderer5);
        ModelPart modelrenderer6 = new ModelPart(this, 32, 2);
        modelrenderer6.addCuboid(3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F, scale);
        modelrenderer6.pivotX = (-(float) Math.PI / 6F);
        this.head.addChild(modelrenderer6);
        ModelPart modelrenderer7 = new ModelPart(this, 32, 2);
        modelrenderer7.addCuboid(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F, scale);
        modelrenderer7.pivotX = (-(float) Math.PI / 6F);
        this.head.addChild(modelrenderer7);
        ModelPart modelrenderer8 = new ModelPart(this, 1, 1);
        modelrenderer8.addCuboid(-3.0F, -11.0F, -1.9F, 6.0F, 5.0F, 6.0F, 0.2F);
        this.head.addChild(modelrenderer8);
        ModelPart modelrenderer9 = new ModelPart(this, 19, 0);
        modelrenderer9.addCuboid(-2.0F, -11.0F, -4.0F, 4.0F, 5.0F, 2.0F, 0.2F);
        this.head.addChild(modelrenderer9);
        this.field_217134_k = new ModelPart[]{modelrenderer3, modelrenderer4, modelrenderer5, modelrenderer8, modelrenderer9};
        this.field_217135_l = new ModelPart[]{modelrenderer6, modelrenderer7};
    }


    public static ModelData getModelData(Dilation dilation) {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        root.addChild()
    }

    /*
    @Override
    protected void method_2789(ModelPart modelPart) {
        ModelPart modelrenderer = new ModelPart(this, 19, 16);
        modelrenderer.addCuboid(-3.5F, -10.0F, 4.99F, 2.0F, 1.0F, 3.0F, -0.001F);
        ModelPart modelrenderer1 = new ModelPart(this, 19, 16);
        modelrenderer1.addCuboid(1.5F, -10.0F, 4.99F, 2.0F, 1.0F, 3.0F, -0.001F);
        modelPart.addChild(modelrenderer);
        modelPart.addChild(modelrenderer1);
    }

     */

    @Override
    public void setAngles(T horseBaseEntity, float f, float g, float h, float i, float j) {
        boolean flag = horseBaseEntity.isSaddled();
        boolean flag1 = horseBaseEntity.hasPassengers();

        for (ModelPart modelrenderer : this.field_217134_k) {
            modelrenderer.visible = flag;
        }

        for (ModelPart modelrenderer1 : this.field_217135_l) {
            modelrenderer1.visible = flag1 && flag;
        }

        this.body.pivotY = 11.0F;
    }


    public Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.head);
    }

    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(this.body, this.field_228262_f_, this.field_228263_g_, this.field_228264_h_, this.field_228265_i_, this.field_228266_j_, this.field_228267_k_, this.field_228268_l_, this.field_228269_m_);
    }

    @Override
    public void animateModel(T horseBaseEntity, float limbSwing, float limbSwingAmount, float partialTick) {
        super.animateModel(horseBaseEntity, limbSwing, limbSwingAmount, partialTick);
        float f = MathHelper.lerpAngle(horseBaseEntity.prevBodyYaw, horseBaseEntity.bodyYaw, partialTick);
        float f1 = MathHelper.lerpAngle(horseBaseEntity.prevHeadYaw, horseBaseEntity.headYaw, partialTick);
        float f2 = MathHelper.lerp(partialTick, horseBaseEntity.prevPitch, horseBaseEntity.getPitch());
        float f3 = f1 - f;
        float f4 = f2 * ((float) Math.PI / 180F);
        if (f3 > 20.0F) {
            f3 = 20.0F;
        }

        if (f3 < -20.0F) {
            f3 = -20.0F;
        }

        if (limbSwingAmount > 0.2F) {
            f4 += MathHelper.cos(limbSwing * 0.4F) * 0.15F * limbSwingAmount;
        }

        float f5 = horseBaseEntity.getEatingGrassAnimationProgress(partialTick);
        float f6 = horseBaseEntity.getAngryAnimationProgress(partialTick);
        float f7 = 1.0F - f6;
        float f8 = horseBaseEntity.getEatingAnimationProgress(partialTick);
        boolean flag = horseBaseEntity.tailWagTicks != 0;
        float f9 = (float) horseBaseEntity.age + partialTick;
        this.head.pivotY = 4.0F;
        this.head.pivotZ = -12.0F;
        this.body.pitch = 0.0F;
        this.head.pitch = ((float) Math.PI / 6F) + f4;
        this.head.yaw = f3 * ((float) Math.PI / 180F);
        float f10 = horseBaseEntity.isSubmergedInWater() ? 0.2F : 1.0F;
        float f11 = MathHelper.cos(f10 * limbSwing * 0.6662F + (float) Math.PI);
        float f12 = f11 * 0.8F * limbSwingAmount;
        float f13 = (1.0F - Math.max(f6, f5)) * (((float) Math.PI / 6F) + f4 + f8 * MathHelper.sin(f9) * 0.05F);
        this.head.pitch = f6 * (0.2617994F + f4) + f5 * (2.1816616F + MathHelper.sin(f9) * 0.05F) + f13;
        this.head.yaw = f6 * f3 * ((float) Math.PI / 180F) + (1.0F - Math.max(f6, f5)) * this.head.yaw;
        this.head.pivotY = f6 * -4.0F + f5 * 11.0F + (1.0F - Math.max(f6, f5)) * this.head.pivotY;
        this.head.pivotZ = f6 * -4.0F + f5 * -12.0F + (1.0F - Math.max(f6, f5)) * this.head.pivotZ;
        this.body.pitch = f6 * (-(float) Math.PI / 4F) + f7 * this.body.pitch;
        float f14 = 0.2617994F * f6;
        float f15 = MathHelper.cos(f9 * 0.6F + (float) Math.PI);
        this.field_228264_h_.pivotY = 2.0F * f6 + 14.0F * f7;
        this.field_228264_h_.pivotZ = -6.0F * f6 - 10.0F * f7;
        this.field_228265_i_.pivotY = this.field_228264_h_.pivotY;
        this.field_228265_i_.pivotZ = this.field_228264_h_.pivotZ;
        float f16 = ((-(float) Math.PI / 3F) + f15) * f6 + f12 * f7;
        float f17 = ((-(float) Math.PI / 3F) - f15) * f6 - f12 * f7;
        this.field_228262_f_.pitch = f14 - f11 * 0.5F * limbSwingAmount * f7;
        this.field_228263_g_.pitch = f14 + f11 * 0.5F * limbSwingAmount * f7;
        this.field_228264_h_.pitch = f16;
        this.field_228265_i_.pitch = f17;
        this.field_217133_j.pitch = ((float) Math.PI / 6F) + limbSwingAmount * 0.75F;
        this.field_217133_j.pivotY = -5.0F + limbSwingAmount;
        this.field_217133_j.pivotZ = 2.0F + limbSwingAmount * 2.0F;
        if (flag) {
            this.field_217133_j.yaw = MathHelper.cos(f9 * 0.7F);
        } else {
            this.field_217133_j.yaw = 0.0F;
        }

        this.field_228266_j_.pivotY = this.field_228262_f_.pivotY;
        this.field_228266_j_.pivotZ = this.field_228262_f_.pivotZ;
        this.field_228266_j_.pitch = this.field_228262_f_.pitch;
        this.field_228267_k_.pivotY = this.field_228263_g_.pivotY;
        this.field_228267_k_.pivotZ = this.field_228263_g_.pivotZ;
        this.field_228267_k_.pitch = this.field_228263_g_.pitch;
        this.field_228268_l_.pivotY = this.field_228264_h_.pivotY;
        this.field_228268_l_.pivotZ = this.field_228264_h_.pivotZ;
        this.field_228268_l_.pitch = this.field_228264_h_.pitch;
        this.field_228269_m_.pivotY = this.field_228265_i_.pivotY;
        this.field_228269_m_.pivotZ = this.field_228265_i_.pivotZ;
        this.field_228269_m_.pitch = this.field_228265_i_.pitch;
        boolean flag1 = horseBaseEntity.isBaby();
        this.field_228262_f_.visible = !flag1;
        this.field_228263_g_.visible = !flag1;
        this.field_228264_h_.visible = !flag1;
        this.field_228265_i_.visible = !flag1;
        this.field_228266_j_.visible = flag1;
        this.field_228267_k_.visible = flag1;
        this.field_228268_l_.visible = flag1;
        this.field_228269_m_.visible = flag1;
        this.body.pivotY = flag1 ? 10.8F : 0.0F;
    }

}
