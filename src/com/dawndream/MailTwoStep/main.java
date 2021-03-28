package com.dawndream.MailTwoStep;

import com.dawndream.MailTwoStep.commands.CommandsMain;
import com.dawndream.MailTwoStep.commands.login;
import com.dawndream.MailTwoStep.events.eventMain;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    public static JavaPlugin instance;

    public void onLoad() {
        saveDefaultConfig();
        saveConfig();
    }

    public void onEnable() {
        instance = this;
        System.out.println("[二步验证] 插件已启用！");
        Bukkit.getPluginCommand("2login").setExecutor(new login());
        Bukkit.getPluginCommand("2set").setExecutor(new CommandsMain());
        Bukkit.getPluginManager().registerEvents(new eventMain() , this);
    }
}

