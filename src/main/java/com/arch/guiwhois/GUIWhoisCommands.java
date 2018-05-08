package com.arch.guiwhois;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GUIWhoisCommands implements CommandExecutor {

    private GUIWhois plugin;

    /**
     * Constructor for Commands Listener
     *
     * @param plugin
     */
    public GUIWhoisCommands(GUIWhois plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            //send version
            sender.sendMessage(plugin.config.prefix + ChatColor.GREEN + plugin.getDescription().getVersion());
        } else if (args[0].toLowerCase().equals("help")) {
            //print help to sender
            //check for permission. Only allow Admins to see this command
            if (!sender.hasPermission("guiwhois.use")) {
                sender.sendMessage(plugin.config.prefix + ChatColor.RED + "You do not have permission to run that command.");
                return true;
            }


            //load a help menu
            List<String> helpMsg = new ArrayList<String>();
            helpMsg.add(ChatColor.GOLD + "-----------------GUIWhois-----------------");

            helpMsg.add(ChatColor.GREEN + "/guiwhois [player]:" + ChatColor.RESET + " Opens the Whois Menu for Player");
            helpMsg.add(ChatColor.GREEN + "/guiwhois reload:" + ChatColor.RESET + " Reloads Config");
            helpMsg.add(ChatColor.GREEN + "/guiwhois help:" + ChatColor.RESET + " Brings up this menu");

            helpMsg.add(ChatColor.GOLD + "-----------------GUIWhois-----------------");

            sender.sendMessage(helpMsg.toArray(new String[0]));

        } else if (args[0].toLowerCase().equals("reload")) {
            sender.sendMessage("The reload functionality is not enabled yet.");
            return true;
        } else {
            //check if caller is a player
            if (!(sender instanceof Player)) {
                plugin.messageService.messageConsole(ChatColor.RED + "GUIWhois can't open GUIs in the console.");
                return true;
            }
            Player caller = (Player) sender;
            //check the arg is actually a player
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null){
                plugin.messageService.messagePlayer(caller,ChatColor.RED
                        + "The player, "
                        + ChatColor.LIGHT_PURPLE + args[0]
                        + ChatColor.RED + ", could not be found."
                );
                return true;
            }

            //player is found, load GUIWhois
            plugin.messageService.messagePlayer(caller, args[0] + " was found!");
        }

        return true;
    }


}
