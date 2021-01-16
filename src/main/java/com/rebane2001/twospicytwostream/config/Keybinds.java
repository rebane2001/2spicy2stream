package com.rebane2001.twospicytwostream.config;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Keybinds {
    public static KeyBinding[] keyBindings;

    public static void initKeys(){
        keyBindings = new KeyBinding[1];

        keyBindings[0] = new KeyBinding("Disable censoring (hold)", Keyboard.KEY_NONE, "2spicy2stream");

        for (int i = 0; i < keyBindings.length; ++i) {
            ClientRegistry.registerKeyBinding(keyBindings[i]);
        }
    }
}
