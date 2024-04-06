package srv.javierdz.commands;

import org.bukkit.command.Command;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import srv.javierdz.Survival;
import srv.javierdz.utils.MessageUtils;

public class checkdeaths implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage(MessageUtils.getColoredMessages(Survival.prefix+"&cThis command is for player use only!"));
            return true;
        }

        Player player = (Player) sender;

        Location death = player.getLastDeathLocation();
        if (death != null) {
            player.sendMessage("Your last death location was: " + locationToString(death));
        } else {
            player.sendMessage("You haven't died recently or your last death location is not available.");
        }

        return true;
    }
    private String locationToString(Location location) {
        return "(" + location.getWorld().getName() + ", " + location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ() + ")";
    }
}
