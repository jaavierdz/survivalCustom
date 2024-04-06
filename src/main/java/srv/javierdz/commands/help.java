package srv.javierdz.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import srv.javierdz.Survival;
import srv.javierdz.utils.MessageUtils;

public class help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args){
        sender.sendMessage(MessageUtils.getColoredMessages(Survival.prefix+"&aHelp page 1"));
        sender.sendMessage(MessageUtils.getColoredMessages("&a/help --> This page"));
        sender.sendMessage(MessageUtils.getColoredMessages("&a/coords --> Send coords to the chat"));
        sender.sendMessage(MessageUtils.getColoredMessages("&a/checkdeath --> Displays your last death location"));
        sender.sendMessage(MessageUtils.getColoredMessages("&a/minecraft:help --> Minecraft's help page"));
        return false;
    }
}
