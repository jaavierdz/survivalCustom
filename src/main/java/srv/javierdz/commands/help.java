package srv.javierdz.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import srv.javierdz.Survival;
import srv.javierdz.utils.MessageUtils;

public class help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args){
        sender.sendMessage(MessageUtils.getColoredMessages(Survival.prefix+""));
    }
}
