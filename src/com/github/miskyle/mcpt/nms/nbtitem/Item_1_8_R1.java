package com.github.miskyle.mcpt.nms.nbtitem;

import org.bukkit.craftbukkit.v1_8_R1.inventory.CraftItemStack;

import net.minecraft.server.v1_8_R1.ItemStack;
import net.minecraft.server.v1_8_R1.NBTTagCompound;
import net.minecraft.server.v1_8_R1.NBTTagString;

public class Item_1_8_R1 implements NBTItem{

	@Override
	public org.bukkit.inventory.ItemStack addNBT(org.bukkit.inventory.ItemStack is, String key, String value) {
		ItemStack item=CraftItemStack.asNMSCopy(is);
		NBTTagCompound nbttc = item.hasTag()?item.getTag():new NBTTagCompound();
		nbttc.set(key, new NBTTagString(value));
		item.setTag(nbttc);
		return CraftItemStack.asBukkitCopy(item);
	}

	@Override
	public String getNBTValue(org.bukkit.inventory.ItemStack is, String key) {
		ItemStack item=CraftItemStack.asNMSCopy(is);
		if(!item.hasTag())return null;
		NBTTagCompound nbttc = item.getTag();
		if(!nbttc.hasKey(key))return null;
		return nbttc.getString(key);
	}
	
}
