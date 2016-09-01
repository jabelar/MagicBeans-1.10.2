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

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemSeedFoodMagicBeans extends ItemFood implements IPlantable
{
    protected final Block thePlant;
    protected final Block theSoil;

    public ItemSeedFoodMagicBeans(int parHealAmount, float parSaturationModifier, 
          Block parBlockPlant, Block parSoilBlock)
    {
        super(parHealAmount, parSaturationModifier, false);
        thePlant = parBlockPlant;
        theSoil = parSoilBlock;
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, 
            BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	// DEBUG
    	System.out.println("ItemMagicBeans onItemUse()");
        net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
        if (facing == EnumFacing.UP && playerIn.canPlayerEdit(pos.offset(facing), facing, stack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up()))
        {
            if (state.getBlock() == theSoil)
            {
                // DEBUG
                System.out.println("Right soil");
                
                worldIn.setBlockState(pos.up(), thePlant.getDefaultState(), 11);
                --stack.stackSize;
                return EnumActionResult.SUCCESS;
            }
            else
            {
                // DEBUG
                System.out.println("Wrong soil");
                return EnumActionResult.FAIL;
            }
        }
        else
        {
            return EnumActionResult.FAIL;
        }
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
    {
        return EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos)
    {
        return thePlant.getDefaultState();
    }
}