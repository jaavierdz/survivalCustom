package srv.javierdz.utils;

import org.bukkit.ChatColor;

public class MessageUtils {

    public static String getColoredMessages(String message){
        return ChatColor.translateAlternateColorCodes('&', message); //Vaya paliza tener que poner esto to el rato, pa eso hago un handler
    }
}
