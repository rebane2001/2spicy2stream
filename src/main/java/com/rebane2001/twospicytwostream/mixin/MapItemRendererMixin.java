package com.rebane2001.twospicytwostream.mixin;

import com.rebane2001.twospicytwostream.BadWords;
import com.rebane2001.twospicytwostream.config.Keybinds;
import com.rebane2001.twospicytwostream.config.ModConfig;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MapItemRenderer.class)
public abstract class MapItemRendererMixin {

    //@Inject(method = "renderString", at = @At(value = "HEAD"))
    //private void renderStringAtPos(String p_renderString_1_, float p_renderString_2_, float p_renderString_3_, int p_renderString_4_, boolean p_renderString_5_, CallbackInfoReturnable<Integer> cir) {
    //    System.out.println("FUU");
    //    p_renderString_1_ = "dick";
    //}

    @Inject(method = "renderMap", at = @At(value = "HEAD"), cancellable = true)
    private void renderMap(CallbackInfo ci){
        if (ModConfig.disableMaps && !Keybinds.keyBindings[0].isKeyDown())
            ci.cancel();
    }
}
