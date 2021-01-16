package com.rebane2001.twospicytwostream.config;

import com.rebane2001.twospicytwostream.BadWords;
import com.rebane2001.twospicytwostream.TwoSpicyTwoStream;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = TwoSpicyTwoStream.MOD_ID)
public class ModConfig {

    @Config.Comment("Censor text")
    public static boolean textCensor = true;

    @Config.Comment("+ replace")
    public static boolean textReplace = true;

    @Config.Comment("Disable maps")
    public static boolean disableMaps = true;

    @Mod.EventBusSubscriber
    private static class EventHandler {

        /**
         * Inject the new values and save to the config file when the config has been changed from the GUI.
         *
         * @param event The event
         */
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(TwoSpicyTwoStream.MOD_ID)) {
                ConfigManager.sync(TwoSpicyTwoStream.MOD_ID, Config.Type.INSTANCE);
                BadWords.genBadWords();
            }
        }
    }
}
