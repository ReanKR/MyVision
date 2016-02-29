package com.ReanKR.MyVision;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public final class MyVision extends JavaPlugin implements Listener
{
	public static String Version = "1.1.0";
	public static String Prefix = "§e[§fM§fy§7V§fision§e]§7 ";
	
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.YELLOW + "MyVision v" + Version + " 활성화됨.");
		Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.YELLOW + "Made by ReanKR");
	}
	
	@Override
	public void onDisable()
	{
		Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.RED + "MyVision v" + Version + " 비활성화됨.");
		Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.YELLOW + "Made by ReanKR");
	}
	
	@Override
	public boolean onCommand(CommandSender Sender, Command command, String string, String[] args)
	{
		if(command.getName().equalsIgnoreCase("myvision.main"))
		{
			if(!(Sender instanceof Player))
			{
				Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.DARK_RED + "이 명령어를 콘솔에서 사용할 수 없습니다.");
				return false;
			}
			Player player = (Player)Sender;
			if(args.length < 1)
			{
				if(player.hasPermission("myvision.view"))
				{
					player.sendMessage(Prefix + ChatColor.GRAY + "======== MyVision ========");
					player.sendMessage(Prefix + ChatColor.GREEN + "Version: " + this.getDescription().getVersion());
					player.sendMessage(Prefix + ChatColor.GREEN + "Made by ReanKR (whitehack97@gmail.com)");
					player.sendMessage(Prefix + "　");
					player.sendMessage(Prefix + ChatColor.AQUA + "/vision | mvision | myvision");
					player.sendMessage(Prefix + ChatColor.GREEN + "myvision 도움말를 봅니다.");
					player.sendMessage(Prefix + "　");
					player.sendMessage(Prefix + ChatColor.AQUA + "/vision | mvision | myvision on [숫자]");
					player.sendMessage(Prefix + ChatColor.GREEN + "야간 투시를 [숫자]초만큼 켭니다.");
					player.sendMessage(Prefix + ChatColor.GREEN + "숫자에 아무것도 입력하지 않으면 계속 켜져 있습니다.");
					player.sendMessage(Prefix + "　");
					player.sendMessage(Prefix + ChatColor.AQUA + "/vision | mvision | myvision off");
					player.sendMessage(Prefix + ChatColor.GREEN + "야간 투시를 끕니다.");
					player.sendMessage(Prefix + ChatColor.GRAY + "======== MyVision ========");
					return true;
				}
				else
				{
					player.sendMessage(Prefix + ChatColor.DARK_RED + "야간 투시 도움말을 볼 수 있는 권한이 없습니다.");
					return true;
				}
			}
			else
			{
				if(player.hasPermission("myvision.settime"))
				{
				if(args[0].equalsIgnoreCase("on"))
				{
				if(player.hasPotionEffect(PotionEffectType.NIGHT_VISION))
				{
					player.sendMessage(Prefix + ChatColor.AQUA + "야간 투시가 활성화 된 상태입니다.");
				}
					if(args.length < 2)
					{
						player.removePotionEffect(PotionEffectType.NIGHT_VISION);
						player.removePotionEffect(PotionEffectType.WATER_BREATHING);
			            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 420000000, 1));
			            player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 420000000, 1));
						player.sendMessage(Prefix + ChatColor.AQUA + "야간 투시가 계속 켜집니다.");
						return true;
					}
					else
					{
						if(CheckNumber(args[1]))
						{
							player.removePotionEffect(PotionEffectType.NIGHT_VISION);
							player.removePotionEffect(PotionEffectType.WATER_BREATHING);
				            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, RealTime(Integer.parseInt(args[1])), 1));
				            player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, RealTime(Integer.parseInt(args[1])), 1));
							player.sendMessage(Prefix + ChatColor.AQUA + "야간 투시가 " + Long.parseLong(args[1]) + "초 동안 켜집니다.");
							return true;
						}
						else
						{
							player.sendMessage(Prefix + ChatColor.RED + "올바른 형식의 숫자를 입력해주십시오! /vision | mvision | myvision on [숫자]");
							return false;
						}
					}
				}
				else if(args[0].equalsIgnoreCase("off"))
				{
					player.removePotionEffect(PotionEffectType.NIGHT_VISION);
					player.removePotionEffect(PotionEffectType.WATER_BREATHING);
					player.sendMessage(Prefix + ChatColor.AQUA + "야간 투시가 꺼졌습니다.");
					return true;
				}
				else
				{
					player.sendMessage(Prefix + ChatColor.RED + "알 수 없는 명령어입니다. /myvision");
				}
				}
				else
				{
					player.sendMessage(Prefix + ChatColor.DARK_RED + "야간 투시를 사용할 권한이 없습니다.");
					return true;
				}
			}
		}
		return true;
	}
	public int RealTime(int TickTime)
	{
		return TickTime*20;
	}

	public boolean CheckNumber(String string)
	{
		try
		{
			Integer.parseInt(string);
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}
}
