/**
    Copyright (C) 2014 by jabelar

    This file is part of jabelar's Minecraft Forge modding examples; as such,
    you can redistribute it and/or modify it under the terms of the GNU
    General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    For a copy of the GNU General Public License see <http://www.gnu.org/licenses/>.

	If you're interested in licensing the code under different terms you can
	contact the author at julian_abelar@hotmail.com 
*/

package com.blogspot.jabelarminecraft.magicbeans.items;

import com.blogspot.jabelarminecraft.magicbeans.MagicBeans;
import com.blogspot.jabelarminecraft.magicbeans.utilities.Utilities;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;


public class ItemMagicBeans extends ItemSeedFoodMagicBeans 
{
	public ItemMagicBeans() 
    {
        super(1, 0.3F, MagicBeans.blockMagicBeanStalk, Blocks.FARMLAND);
        // moved the naming to the instantiation
//        setRegistryName("magicbeans");
//        setUnlocalizedName("magicbeans");
        setCreativeTab(CreativeTabs.MATERIALS);
    }
    
    @Override
    public String getItemStackDisplayName(ItemStack parItemStack) 
    {
        return Utilities.stringToRainbow("Magic Beans");
    }
}