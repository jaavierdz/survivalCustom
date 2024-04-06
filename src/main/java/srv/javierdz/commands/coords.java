package srv.javierdz.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import srv.javierdz.Survival;
import srv.javierdz.utils.MessageUtils;

public class coords implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (!(sender instanceof Player)){
            //Consola
            sender.sendMessage(MessageUtils.getColoredMessages(Survival.prefix+"&cThis command is for player use only!"));
            return true;
        }

        //Jugador
        Player player = (Player) sender;
        double x = player.getLocation().getX();
        double z = player.getLocation().getZ();

        String coords = String.format("%s esta en: X=%.2f, Z=%.2f", player.getName(), x, z);
        Bukkit.getServer().broadcastMessage(coords);
        return true;

    }
}
