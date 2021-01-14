package dev.heyitsskay.mockbukkittestimplementation;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;
import java.util.Locale;

public final class MockBukkitTestImplementation extends JavaPlugin implements CommandExecutor {

    protected MockBukkitTestImplementation(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file)
    {
        super(loader, description, dataFolder, file);
    }

    @Override
    public void onEnable() {
        getServer().getPluginCommand("gmc").setExecutor(this);
        getServer().getPluginCommand("gms").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.equalsIgnoreCase("gmc")) {
                p.setGameMode(GameMode.CREATIVE);
            } else if (cmd.equalsIgnoreCase("gms")) {
                p.setGameMode(GameMode.SURVIVAL);
            }
        } else {
            sender.sendMessage("This command can only be run as player.");
        }
        return true;
    }

    @Override
    public void onDisable() {
    }
}
