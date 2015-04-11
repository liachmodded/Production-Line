/*
 * This file is part of GoodTime-Industrial, licensed under MIT License (MIT).
 *
 * Copyright (c) 2015 Minecraft-GoodTime <http://github.com/Minecraft-GoodTime>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.mcgoodtime.gti.common.items;

import com.mcgoodtime.gti.common.core.CreativeTabGti;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemIridium extends Item {
	
	public static Item CrushedIR = new Item()
	.setUnlocalizedName("CrushedIriridium")
	.setCreativeTab(CreativeTabGti.creativeTabGti)
    .setTextureName("gti:itemCrushedIR");
	public static Item DustIR = new Item()
	.setUnlocalizedName("DustIriridium")
	.setCreativeTab(CreativeTabGti.creativeTabGti)
	.setTextureName("gti:itemDustIR");
	public static Item IngotIR = new Item()
	.setUnlocalizedName("IngotIriridium")
	.setCreativeTab(CreativeTabGti.creativeTabGti)
	.setTextureName("gti:itemIngotIR");
	public static Item CleanedIridium = new Item()
	.setUnlocalizedName("IngotIriridium")
	.setCreativeTab(CreativeTabGti.creativeTabGti)
	.setTextureName("gti:itemWashedIridium");
	
	public static ItemStack CrushedIRs = new ItemStack(CrushedIR); 
	public static ItemStack DustIRs = new ItemStack(DustIR);
	public static ItemStack IngotIRs = new ItemStack(IngotIR);
	
    public static void preInit() {
    	GameRegistry.registerItem(CrushedIR, "CrushedIriridium");
    	GameRegistry.registerItem(DustIR, "DustIriridium");
    	GameRegistry.registerItem(IngotIR, "IngotIriridium");
	}
	
}