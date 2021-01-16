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

    @Inject(method = "renderMap", at = @At(value = "HEAD"), cancellable = true)
    private void renderMap(CallbackInfo ci){
        if (ModConfig.disableMaps && !Keybinds.keyBindings[0].isKeyDown())
            ci.cancel();
    }
}
