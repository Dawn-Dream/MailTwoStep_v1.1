package com.dawndream.MailTwoStep.events;

import com.dawndream.MailTwoStep.Config.ConfigReader;
import com.dawndream.MailTwoStep.main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;

import static com.dawndream.MailTwoStep.Config.ConfigReader.WritePlayerTimestamp;
import static com.dawndream.MailTwoStep.Config.PlayerList.addPlayerName;
import static com.dawndream.MailTwoStep.Config.PlayerList.hasPlayerName;
import static com.dawndream.MailTwoStep.Config.ReadCode.CodeMail;
import static com.dawndream.MailTwoStep.Config.ReadCode.setCodeNull;

public class eventMain implements Listener {
    boolean ifIn = true;

    @EventHandler
    public void inLogin (PlayerJoinEvent playerLoginEvent){
        Player player = playerLoginEvent.getPlayer();


        if (ConfigReader.ifModTrue(player.getName())){
            player.sendMessage(ChatColor.GOLD + "[二步验证] 验证码已发送至 " + main.instance.getConfig().getString(player.getName() + "_mail") + " 请查收！");
            CodeMail(player.getName());
            addPlayerName(playerLoginEvent.getPlayer().getName());

        }
    }

    @EventHandler
    public void OnMove (PlayerMoveEvent playerMoveEvent){
        if(hasPlayerName(playerMoveEvent.getPlayer().getName())){
            playerMoveEvent.setCancelled(true);
            playerMoveEvent.getPlayer().sendMessage(ChatColor.RED + "[二步验证] 请输入验证码");
        }
    }
    @EventHandler
    public void restrictInteract(PlayerInteractEvent e) {

        if(hasPlayerName(e.getPlayer().getName())){
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "[二步验证] 请输入验证码");
        }
    }

    @EventHandler
    public void restrictInteractAtEntity(PlayerInteractAtEntityEvent e) {
        if(hasPlayerName(e.getPlayer().getName())){
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "[二步验证] 请输入验证码");
        }
    }

    @EventHandler
    public void restrictPortal(PlayerPortalEvent e) {
        if(hasPlayerName(e.getPlayer().getName())){
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "[二步验证] 请输入验证码");
        }
    }

    @EventHandler
    public void restrictTeleport(PlayerTeleportEvent e) {
        if(hasPlayerName(e.getPlayer().getName())){
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "[二步验证] 请输入验证码");
        }
    }

    @EventHandler
    public void restrictOpenInventory(InventoryOpenEvent e) {
        if(hasPlayerName(e.getPlayer().getName())){
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "[二步验证] 请输入验证码");
        }
    }

    @EventHandler
    public void Leave (PlayerQuitEvent e){
        setCodeNull(e.getPlayer().getName());
        WritePlayerTimestamp(e.getPlayer().getName());
    }


}
