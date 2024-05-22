package org.thinkingstudio.mafglib.mixin;

import net.minecraftforge.client.gui.overlay.ForgeGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import fi.dy.masa.malilib.event.RenderEventHandler;

@Mixin(ForgeGui.class)
public abstract class MixinForgeGui {
    @Inject(method = "render", at = @At("RETURN"))
    private void onGameOverlayPost(MatrixStack matrixStack, float partialTicks, CallbackInfo ci) {
        ((RenderEventHandler) RenderEventHandler.getInstance()).onRenderGameOverlayPost(matrixStack, MinecraftClient.getInstance(), partialTicks);
    }
}