package srv.javierdz.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import srv.javierdz.Survival;
import srv.javierdz.utils.MessageUtils;

public class about implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if(!(sender instanceof Player)){
            //Es la consola
            sender.sendMessage(ChatColor.translateAlternateColorCodes(
                    '&', "&cThis command is for player use only! (Paleto)"));

            return true;
        }

        sender.sendMessage(ChatColor.translateAlternateColorCodes(
                '&', Survival.prefix+"Survival Custom plugin version 1.0"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Survival.prefix+"Made by Javierdz"));
        sender.sendMessage(MessageUtils.getColoredMessages(Survival.prefix+"For problems contact me"));


        //Jugador
        return true;


    }
}
