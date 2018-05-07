package com.arch.guiwhois;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GUIWhois extends JavaPlugin {

    MessageService messageService;
    Config config;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();//generates config.yml if it does not exist

        //Initialise Config
        this.config = new Config(this);

        messageService = new MessageService(this);
        messageService.messageConsole("MessageService Active");
    }

    @Override
    public void onDisable() {

    }

}
