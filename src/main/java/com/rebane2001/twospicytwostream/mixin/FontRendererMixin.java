package com.rebane2001.twospicytwostream.mixin;

import com.rebane2001.twospicytwostream.BadWords;
import com.rebane2001.twospicytwostream.config.Keybinds;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(FontRenderer.class)
public abstract class FontRendererMixin implements IResourceManagerReloadListener {

    @ModifyVariable(method = "renderStringAtPos", at = @At("HEAD"))
    private String renderStringAtPos(String text) {
        if (Keybinds.keyBindings[0].isKeyDown())
            return text;
        for (String s : BadWords.badWordsMap.keySet()) {
            if (text.toLowerCase().contains(s)) {
                //text = text.replaceAll("(?i)(" + s + ")", BadWords.badWordsMap.get(s).replacement);
                text = text.replaceAll("(?i)" + s, BadWords.badWordsMap.get(s).replacement);
                for (String ignoreWord : BadWords.badWordsMap.get(s).ignoreCases) {
                    String ignoreWord2 = ignoreWord.replace(s,BadWords.badWordsMap.get(s).replacement);
                    text = text.replaceAll("(?i)" + ignoreWord2, ignoreWord);
                }
            }
        }

        return text;
    }
}
