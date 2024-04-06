package srv.javierdz.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DeathCounter extends JavaPlugin implements Listener {

    private static Map<String, Integer> deathCountMap; // Declare as static
    private File dataFile;

    @Override
    public void onEnable() {
        // Initialize the death count map
        deathCountMap = new HashMap<>();

        // Register events
        getServer().getPluginManager().registerEvents(this, this);

        // Load death count data from file
        dataFile = new File(getDataFolder(), "deathcounts.yml");
        loadDeathCountData();
    }

    @Override
    public void onDisable() {
        // Save death count data to file
        saveDeathCountData();
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        String playerName = player.getName();

        // Increase death count for the player
        int deathCount = deathCountMap.getOrDefault(playerName, 0) + 1;
        deathCountMap.put(playerName, deathCount);

        // Check if the death count exceeds the threshold and take action if necessary
        if (deathCount > 3) { // Change the threshold value as needed
            // Example action: kick the player
            player.kickPlayer("You have been banned for exceeding the death count threshold.");
        }

        // You can optionally broadcast the death count to all players
        getServer().broadcastMessage(playerName + "'s death count: " + deathCount);
    }

    // Method to load death count data from file
    private void loadDeathCountData() {
        if (!dataFile.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String playerName = parts[0];
                    int deathCount = Integer.parseInt(parts[1]);
                    deathCountMap.put(playerName, deathCount);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to save death count data to file
    private void saveDeathCountData() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {
            for (Map.Entry<String, Integer> entry : deathCountMap.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Public static method to get the death count map
    public static Map<String, Integer> getDeathCountMap() {
        return deathCountMap;
    }
}