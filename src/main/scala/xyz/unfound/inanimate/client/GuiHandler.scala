package xyz.unfound.inanimate.client

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.IGuiHandler
import xyz.unfound.inanimate.client.gui.GuiApplyer
import xyz.unfound.inanimate.inventory.ContainerApplyer

/**
  * Created by lbq on 9/10/16.
  */
class GuiHandler extends IGuiHandler {
  override def getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef = {
    return new GuiApplyer(player.inventory, world, new BlockPos(x,y,z))
  }

  override def getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef = {
    return new ContainerApplyer(player.inventory, world, new BlockPos(x, y, z))
  }
}
