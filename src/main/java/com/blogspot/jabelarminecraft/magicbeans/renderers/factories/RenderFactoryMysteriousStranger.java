/**
    Copyright (C) 2016 by jabelar

    This file is part of jabelar's Minecraft Forge modding examples; as such,
    you can redistribute it and/or modify it under the terms of the GNU
    General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    For a copy of the GNU General Public License see <http://www.gnu.org/licenses/>.
*/

package com.blogspot.jabelarminecraft.magicbeans.renderers.factories;

import com.blogspot.jabelarminecraft.magicbeans.renderers.RenderMysteriousStranger;

import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * @author jabelar
 *
 */
public class RenderFactoryMysteriousStranger implements IRenderFactory
{

    /* (non-Javadoc)
     * @see net.minecraftforge.fml.client.registry.IRenderFactory#createRenderFor(net.minecraft.client.renderer.entity.RenderManager)
     */
    @Override
    public Render createRenderFor(RenderManager renderManager)
    {
        return new RenderMysteriousStranger(renderManager, new ModelVillager(0.0F), 0.5F); // 0.5F is shadow size 
    }

}
