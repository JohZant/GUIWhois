package com.arch.guiwhois;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Config {

    private GUIWhois plugin;

    public String prefix;//prefix to use for plugin

    /**
     * Contructor for Message Service
     * @param plugin
     */
    public Config(GUIWhois plugin) {
        this.plugin = plugin;
        this.prefix = ChatColor.GOLD + "[GUIWhois] " + ChatColor.RESET;
    }


}
