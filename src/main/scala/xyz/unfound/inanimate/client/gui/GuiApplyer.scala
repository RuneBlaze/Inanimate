package xyz.unfound.inanimate.client.gui

import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.resources.I18n
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.fml.relauncher.{Side, SideOnly}
import xyz.unfound.inanimate.inventory.ContainerApplyer

/**
  * Created by lbq on 9/10/16.
  */

@SideOnly(Side.CLIENT)
class GuiApplyer(playerInv: InventoryPlayer, world: World, blockPos : BlockPos = BlockPos.ORIGIN) extends GuiContainer(new ContainerApplyer(playerInv, world, blockPos)) {
  val resLoc = new ResourceLocation("inanimate:textures/gui/blockApply.png")

  override protected def drawGuiContainerForegroundLayer(mouseX: Int, mouseY: Int) {
    this.fontRendererObj.drawString(I18n.format("container.crafting", new Array[AnyRef](0)), 28, 6, 4210752)
    this.fontRendererObj.drawString(I18n.format("container.inventory", new Array[AnyRef](0)), 8, this.ySize - 96 + 2, 4210752)
  }
  override def drawGuiContainerBackgroundLayer(partialTicks: Float, mouseX: Int, mouseY: Int): Unit = {
    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F)
    this.mc.getTextureManager.bindTexture(resLoc)
    val i: Int = (this.width - this.xSize) / 2
    val j: Int = (this.height - this.ySize) / 2
    this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize)
  }
}
