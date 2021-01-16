package com.rebane2001.twospicytwostream;

import com.rebane2001.twospicytwostream.config.Keybinds;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.awt.image.BufferedImage;
import java.io.*;

@Mod(modid = TwoSpicyTwoStream.MOD_ID)
public class TwoSpicyTwoStream {
    public static final String MOD_ID = "twospicytwostream";

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) { }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        BadWords.genBadWords();
        Keybinds.initKeys();
    }
}
