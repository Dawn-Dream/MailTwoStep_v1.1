package com.dawndream.MailTwoStep.commands;

import com.dawndream.MailTwoStep.Config.ConfigReader;
import com.dawndream.MailTwoStep.Config.ReadCode;
import com.dawndream.MailTwoStep.main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class CommandsMain implements CommandExecutor {
    FileConfiguration config = main.instance.getConfig();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0 ){
            commandSender.sendMessage(ChatColor.RED + "[二步验证] 语法错误！");
            return true;
        }
        if (strings[0].equalsIgnoreCase("help")){
            commandSender.sendMessage(ChatColor.GOLD + "---------------HELP---------------");
            commandSender.sendMessage(ChatColor.GOLD + "/2set set         设置邮箱");
            commandSender.sendMessage(ChatColor.GOLD + "/2set set.code    邮箱验证码");
            commandSender.sendMessage(ChatColor.GOLD + "/2set true/fasle  开启/关闭二步验证");
        }
        if (strings[0].equalsIgnoreCase("set")){
            if (strings.length == 1){
                commandSender.sendMessage(ChatColor.RED + "[二步验证] 语法错误！");
                return true;
            }
            main.instance.getConfig().set(commandSender.getName() + "_mail" , strings[1]);
            commandSender.sendMessage(ChatColor.GREEN + "[二步验证] 验证码已发送至 " + strings[1] + "  ，请注意你的邮箱！");
            commandSender.sendMessage(ChatColor.GREEN + "[二步验证] 请使用 /2set set.code [code] 来验证你的邮箱！");
            ReadCode.setCode_reg(commandSender.getName() , true);
            ReadCode.CodeMail(commandSender.getName());
            /*
            com.dawndream.MailTwoStep.Config.ConfigReader.addPlayer(commandSender.getName() , strings[1]);
            commandSender.sendMessage(ChatColor.GREEN + "[二步验证] " + strings[1] + "设置验证成功，已开启验证！");
            */


        }
        if (strings[0].equalsIgnoreCase("set.code")){
            if (strings.length != 2){
                commandSender.sendMessage(ChatColor.RED + "[二步验证] 语法错误！");
                return true;
            }
            if (ReadCode.isCode_reg(commandSender.getName())){
                if (ReadCode.ifCodeRight(commandSender.getName() , strings[1])){
                    commandSender.sendMessage(ChatColor.GREEN + "[二步验证] 邮箱验证成功！已开启验证！");
                    ConfigReader.addPlayer(commandSender.getName() , ConfigReader.getPlayerEmil(commandSender.getName()));
                }
            }else {
                commandSender.sendMessage(ChatColor.RED + "[二步验证] 你无需验证邮箱！");
            }
        }


        if (strings[0].equalsIgnoreCase("true")){
            if(main.instance.getConfig().getString(commandSender.getName() + "_mail") == null){
                commandSender.sendMessage(ChatColor.RED + "[二步验证]你还没有设置账户！");
                return true;
            }
            commandSender.sendMessage(ChatColor.GREEN + "[二步验证] 已开启验证！");
            com.dawndream.MailTwoStep.Config.ConfigReader.truePlyaer(commandSender.getName());
            return true;
        }if (strings[0].equalsIgnoreCase("false")){
            commandSender.sendMessage(ChatColor.RED + "[二步验证] 已关闭验证！");
            com.dawndream.MailTwoStep.Config.ConfigReader.falsePlyaer(commandSender.getName());
            return true;
        }

        return true;
    }
}
