package com.arch.guiwhois;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GUIWhois extends JavaPlugin {

    @Override
    public void onEnable(){
        this.saveDefaultConfig();//generates config.yml if it does not exist

    }

    @Override
    public void onDisable(){

    }

}
