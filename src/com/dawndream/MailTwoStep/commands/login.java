package com.dawndream.MailTwoStep.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static com.dawndream.MailTwoStep.Config.PlayerList.hasPlayerName;
import static com.dawndream.MailTwoStep.Config.ReadCode.ifCodeRight;
import static com.dawndream.MailTwoStep.Config.ReadCode.setCodeNull;
import static com.dawndream.MailTwoStep.Config.PlayerList.removePlayerName;

public class login implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
            if (strings.length != 1){
                commandSender.sendMessage(ChatColor.RED + "格式错误！");
                return true;
            }
            if (ifCodeRight(commandSender.getName() , strings[0])){
                setCodeNull(commandSender.getName());
                if (hasPlayerName(commandSender.getName())){
                    removePlayerName(commandSender.getName());
                    commandSender.sendMessage(ChatColor.GREEN + "[二步验证] 登陆成功");
                    return true;
                }
            }
        return false;
    }
}
