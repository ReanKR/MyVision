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
	public static String Prefix = "��e[��fM��fy��7V��fision��e]��7 ";
	
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.YELLOW + "MyVision v" + Version + " Ȱ��ȭ��.");
		Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.YELLOW + "Made by ReanKR");
	}
	
	@Override
	public void onDisable()
	{
		Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.RED + "MyVision v" + Version + " ��Ȱ��ȭ��.");
		Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.YELLOW + "Made by ReanKR");
	}
	
	@Override
	public boolean onCommand(CommandSender Sender, Command command, String string, String[] args)
	{
		if(command.getName().equalsIgnoreCase("myvision.main"))
		{
			if(!(Sender instanceof Player))
			{
				Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.DARK_RED + "�� ��ɾ �ֿܼ��� ����� �� �����ϴ�.");
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
					player.sendMessage(Prefix + "��");
					player.sendMessage(Prefix + ChatColor.AQUA + "/vision | mvision | myvision");
					player.sendMessage(Prefix + ChatColor.GREEN + "myvision ���򸻸� ���ϴ�.");
					player.sendMessage(Prefix + "��");
					player.sendMessage(Prefix + ChatColor.AQUA + "/vision | mvision | myvision on [����]");
					player.sendMessage(Prefix + ChatColor.GREEN + "�߰� ���ø� [����]�ʸ�ŭ �մϴ�.");
					player.sendMessage(Prefix + ChatColor.GREEN + "���ڿ� �ƹ��͵� �Է����� ������ ��� ���� �ֽ��ϴ�.");
					player.sendMessage(Prefix + "��");
					player.sendMessage(Prefix + ChatColor.AQUA + "/vision | mvision | myvision off");
					player.sendMessage(Prefix + ChatColor.GREEN + "�߰� ���ø� ���ϴ�.");
					player.sendMessage(Prefix + ChatColor.GRAY + "======== MyVision ========");
					return true;
				}
				else
				{
					player.sendMessage(Prefix + ChatColor.DARK_RED + "�߰� ���� ������ �� �� �ִ� ������ �����ϴ�.");
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
					player.sendMessage(Prefix + ChatColor.AQUA + "�߰� ���ð� Ȱ��ȭ �� �����Դϴ�.");
				}
					if(args.length < 2)
					{
						player.removePotionEffect(PotionEffectType.NIGHT_VISION);
						player.removePotionEffect(PotionEffectType.WATER_BREATHING);
			            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 420000000, 1));
			            player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 420000000, 1));
						player.sendMessage(Prefix + ChatColor.AQUA + "�߰� ���ð� ��� �����ϴ�.");
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
							player.sendMessage(Prefix + ChatColor.AQUA + "�߰� ���ð� " + Long.parseLong(args[1]) + "�� ���� �����ϴ�.");
							return true;
						}
						else
						{
							player.sendMessage(Prefix + ChatColor.RED + "�ùٸ� ������ ���ڸ� �Է����ֽʽÿ�! /vision | mvision | myvision on [����]");
							return false;
						}
					}
				}
				else if(args[0].equalsIgnoreCase("off"))
				{
					player.removePotionEffect(PotionEffectType.NIGHT_VISION);
					player.removePotionEffect(PotionEffectType.WATER_BREATHING);
					player.sendMessage(Prefix + ChatColor.AQUA + "�߰� ���ð� �������ϴ�.");
					return true;
				}
				else
				{
					player.sendMessage(Prefix + ChatColor.RED + "�� �� ���� ��ɾ��Դϴ�. /myvision");
				}
				}
				else
				{
					player.sendMessage(Prefix + ChatColor.DARK_RED + "�߰� ���ø� ����� ������ �����ϴ�.");
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
