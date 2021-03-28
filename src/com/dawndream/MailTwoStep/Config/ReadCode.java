package com.dawndream.MailTwoStep.Config;

import com.dawndream.MailTwoStep.main;

import static com.dawndream.MailTwoStep.Config.ConfigReader.getMailInfo;
import static com.dawndream.MailTwoStep.Config.ConfigReader.getPlayerEmil;
import static com.dawndream.MailTwoStep.mail.send.SendMailInt;

public class ReadCode {
    public static void CodeMail(String playerName){
        main.instance.getConfig().set(playerName + "_codeNow" , SendMailInt(getPlayerEmil(playerName), getMailInfo("sender"), getMailInfo("smtp"), getMailInfo("password"),getMailInfo("head")));
        main.instance.saveConfig();
    }

    public static void setCodeNull(String playerName){
        main.instance.getConfig().set(playerName + "_codeNow" , null);
        main.instance.saveConfig();
    }

    public static boolean ifCodeRight(String playerName,String code){
        if (code.equalsIgnoreCase(main.instance.getConfig().getString(playerName + "_codeNow"))){
            return true;
        }else return false;
    }

    /*设置邮箱时验证*/
    public static void setCodeNull_reg(String playerName){
        main.instance.getConfig().set(playerName + "_reg" , null);
    }

    public static void setCode_reg(String playerName , boolean now){
        main.instance.getConfig().set(playerName + "_reg" , now);
    }

    public static boolean isCode_reg(String playerName){
        return main.instance.getConfig().getBoolean(playerName + "_reg");
    }
}
