package com.arch.guiwhois;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MessageService {
    private GUIWhois plugin;

    public MessageService(GUIWhois plugin){
        this.plugin = plugin;
    }

    /**
     * Send a message to the console from GUIWhois
     * @param msg
     */
    public void messageConsole(String msg){
        Bukkit.getConsoleSender().sendMessage(plugin.config.prefix + msg);
    }

    /**
     * Sends messages to the console from GUIWhois
     * @param msgs
     */
    public void messageConsole(String[] msgs){
        //add prefix to each message
        for (int i = 0; i < msgs.length; i++) {
            msgs[i] = plugin.config.prefix + msgs[i];
        }

        Bukkit.getConsoleSender().sendMessage(msgs);
    }

    /**
     * Sends a message to the specified player
     * @param player
     * @param msg
     */
    public void messagePlayer(Player player, String msg){
        player.sendMessage(plugin.config.prefix + msg);
    }

    /**
     * Sends messages to the specified player
     * @param player
     * @param msgs
     */
    public void messagePlayer(Player player, String[] msgs){
        //add prefix to each message
        for (int i = 0; i < msgs.length; i++) {
            msgs[i] = plugin.config.prefix + msgs[i];
        }
        player.sendMessage(msgs);
    }
}
