package srv.javierdz;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import srv.javierdz.commands.about;
import srv.javierdz.commands.coords;

public class Survival extends JavaPlugin {

    public static String prefix = "&8[&1&lSurvivalCustom&r&8]";

    private String version = getDescription().getVersion();

    public void onEnable(){
        registerCommands();
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+version+"&a&l enabled"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+"&1Author: &6Javierdz"));
    }

    public void onDisable(){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+version+"&a&l enabled"));
    }

    public void registerCommands() {
        this.getCommand("about").setExecutor(new about());
        this.getCommand("coords").setExecutor(new coords());
    }

}
