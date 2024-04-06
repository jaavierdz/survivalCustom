package srv.javierdz.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import srv.javierdz.Survival;
import srv.javierdz.utils.MessageUtils;

import java.net.http.WebSocket;

public class PlayerListener implements WebSocket.Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String message = event.getMessage();

        if(message.toLowerCase().contains("creativo")){
            event.setCancelled(true);
            player.sendMessage(MessageUtils.getColoredMessages("&cTus muertos"));
        }

    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        player.sendMessage(MessageUtils.getColoredMessages(Survival.prefix+"&aBienvenido al Survival Custom!"));

    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity().getPlayer();
        assert player != null;
        String title = MessageUtils.getColoredMessages("&c&lHAS MUERTO!");
        String 
        player.sendTitle();

    }
}
