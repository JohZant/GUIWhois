package com.arch.guiwhois;

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


        //setup commands
        this.getCommand("guiwhois").setExecutor(new GUIWhoisCommands(this));
        this.getCommand("guiwhois").setTabCompleter(new TabComplete());//tab complete
    }

    @Override
    public void onDisable() {

    }

}
