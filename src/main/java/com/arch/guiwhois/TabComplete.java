package com.arch.guiwhois;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TabComplete implements TabCompleter {

    private static final String[] COMMANDS = { "reload", "help", "version" };

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args){
        List<String> completions = new ArrayList<String>();//object to hold items that amtch the input args

        List<String> possibilities = new ArrayList<String>();//object to hold every possibility

        for (int i = 0; i < COMMANDS.length; i++) {
            possibilities.add(COMMANDS[i]);
        }

        //get all player names and out them into
        for (Player p : Bukkit.getOnlinePlayers()){
            possibilities.add(p.getName());
        }


        StringUtil.copyPartialMatches(args[0], possibilities, completions);//copy matches of first argument from list
        Collections.sort(completions);//sort
        return completions;
    }

}
