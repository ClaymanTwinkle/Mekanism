package mekanism.client.render.block;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mekanism.client.ClientProxy;
import mekanism.client.model.*;
import mekanism.client.render.MekanismRenderer;
import mekanism.common.block.BlockMachine.MachineType;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.MekanismUtils.ResourceType;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class MachineRenderingHandler implements ISimpleBlockRenderingHandler
{
	public ModelElectricPump electricPump = new ModelElectricPump();
	public ModelMetallurgicInfuser metallurgicInfuser = new ModelMetallurgicInfuser();
	public ModelChargepad chargepad = new ModelChargepad();
	public ModelLogisticalSorter logisticalSorter = new ModelLogisticalSorter();
	public ModelDigitalMiner digitalMiner = new ModelDigitalMiner();
	public ModelRotaryCondensentrator rotaryCondensentrator = new ModelRotaryCondensentrator();
	public ModelChemicalOxidizer chemicalOxidizer = new ModelChemicalOxidizer();
	public ModelChemicalInfuser chemicalInfuser = new ModelChemicalInfuser();
	public ModelElectrolyticSeparator electrolyticSeparator = new ModelElectrolyticSeparator();


	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		if(block == null || renderer == null || MachineType.get(block.blockID, metadata) == null)
		{
			return;
		}
		
	    GL11.glPushMatrix();
	    GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
	    
	    MachineType type = MachineType.get(block.blockID, metadata);
	    
		if(type == MachineType.ELECTRIC_PUMP)
		{
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(90F, 0.0F, -1.0F, 0.0F);
	    	GL11.glTranslatef(0.0F, -0.85F, 0.0F);
	    	Minecraft.getMinecraft().renderEngine.bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "ElectricPump.png"));
	    	electricPump.render(0.0560F);
		}
		else if(type == MachineType.METALLURGIC_INFUSER)
		{
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(270F, 0.0F, -1.0F, 0.0F);
	    	GL11.glTranslatef(0.0F, -1.0F, 0.0F);
	    	Minecraft.getMinecraft().renderEngine.bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "MetallurgicInfuser.png"));
	    	metallurgicInfuser.render(0.0625F);
		}
		else if(type == MachineType.CHARGEPAD)
		{
			GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.0F, -1.1F, 0.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "Chargepad.png"));
			chargepad.render(0.0625F);
		}
		else if(type == MachineType.LOGISTICAL_SORTER)
		{
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(270F, 0.0F, -1.0F, 0.0F);
	    	GL11.glTranslatef(0.0F, -0.85F, -0.15F);
	    	Minecraft.getMinecraft().renderEngine.bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "LogisticalSorter.png"));
	    	logisticalSorter.render(0.0625F, false);
		}
		else if(type == MachineType.DIGITAL_MINER)
		{
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0.2F, -0.3F, 0.0F);
		  	Minecraft.getMinecraft().renderEngine.bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "DigitalMiner.png"));
		  	digitalMiner.render(0.03125F, false);
		}
		else if(type == MachineType.ROTARY_CONDENSENTRATOR)
		{
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(270F, 0.0F, -1.0F, 0.0F);
	    	GL11.glTranslatef(0.0F, -1.06F, 0.05F);
	    	Minecraft.getMinecraft().renderEngine.bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "RotaryCondensentrator.png"));
			rotaryCondensentrator.render(0.0625F);
		}
		else if(type == MachineType.CHEMICAL_OXIDIZER)
		{
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(270F, 0.0F, -1.0F, 0.0F);
	    	GL11.glTranslatef(0.0F, -1.06F, 0.05F);
	    	Minecraft.getMinecraft().renderEngine.bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "ChemicalOxidizer.png"));
			chemicalOxidizer.render(0.0625F);
			chemicalOxidizer.renderGlass(0.0625F);
		}
		else if(type == MachineType.CHEMICAL_INFUSER)
		{
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(270F, 0.0F, -1.0F, 0.0F);
	    	GL11.glTranslatef(0.0F, -1.06F, 0.05F);
	    	Minecraft.getMinecraft().renderEngine.bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "ChemicalInfuser.png"));
			chemicalInfuser.render(0.0625F);
			chemicalInfuser.renderGlass(0.0625F);
		}
		else if(type == MachineType.ELECTROLYTIC_SEPARATOR)
		{
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslated(0.0F, -1.0F, 0.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "ElectrolyticSeparatorHydrogen.png"));
			electrolyticSeparator.render(0.0625F);
		}
		else {
	        MekanismRenderer.renderItem(renderer, metadata, block);
		}
	    
	    GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		
		if(MachineType.get(block.blockID, metadata) != null)
		{
			if(!MachineType.get(block.blockID, metadata).hasModel)
			{
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBoundsFromBlock(block);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() 
	{
		return true;
	}

	@Override
	public int getRenderId() 
	{
		return ClientProxy.MACHINE_RENDER_ID;
	}
}
