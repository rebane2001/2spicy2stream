package com.rebane2001.twospicytwostream;

import com.rebane2001.twospicytwostream.config.ModConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class BadWords {

    public static LinkedHashMap<String,BadWordData> badWordsMap = new LinkedHashMap<String, BadWordData>();

    public static class BadWordData {
        public String replacement = "";
        public Set<String> ignoreCases = Collections.emptySet();//new HashSet<String>();
    }

    public static void genBadWords(){
        badWordsMap.clear();

        if (!ModConfig.textCensor)
            return;

        try {
            ResourceLocation loc = new ResourceLocation("twospicytwostream:badwords.csv");
            InputStream in = Minecraft.getMinecraft().getResourceManager().getResource(loc).getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = reader.readLine();
            while (line != null) {
                String[] values = line.split(";");
                if (values.length >= 2) {
                    BadWordData badWordData = new BadWordData();
                    if (values.length >= 3)
                        badWordData.replacement = values[2].toLowerCase();
                    if (badWordData.replacement == "" || !ModConfig.textReplace)
                        badWordData.replacement = values[1].replaceAll(".","\\\\*");
                    //badWordData.replacement = "§k$1§r";
                    if (values[0] != "") {
                        badWordData.ignoreCases = new HashSet<String>();
                        badWordData.ignoreCases.addAll(Arrays.asList(values[0].toLowerCase().split("#")));
                    }
                    badWordsMap.put(values[1].toLowerCase(), badWordData);
                }

                line = reader.readLine();
            }
            reader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
