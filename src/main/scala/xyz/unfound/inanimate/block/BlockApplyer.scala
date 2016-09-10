package xyz.unfound.inanimate.block

import net.minecraft.block.{Block, BlockContainer}
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory.Container
import net.minecraft.item.ItemStack
import net.minecraft.stats.StatList
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.{EnumFacing, EnumHand}
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.{ITextComponent, TextComponentTranslation}
import net.minecraft.world.{IInteractionObject, World}
import xyz.unfound.inanimate.Inanimate
import xyz.unfound.inanimate.inventory.ContainerApplyer

/**
  * Created by lbq on 9/9/16.
  */
class BlockApplyer extends Block(Material.WOOD) {
//  setCreativeTab(CreativeTabs.DECORATIONS)
//  setRegistryName("inanimate", "blockApplyer")
//  setUnlocalizedName("inanimate:blockApplyer")
  setHardness(0.5f)

  override def onBlockActivated(world: World, pos: BlockPos, state: IBlockState, player: EntityPlayer, hand: EnumHand, heldItem: ItemStack, side: EnumFacing, hitX : Float, hitY : Float, hitZ: Float): Boolean = {
    if (!world.isRemote) {
      player.displayGui(new InterfaceApplyer(world, pos))
      player.openGui(Inanimate, 0, world, pos.getX, pos.getY, pos.getZ)
    }
    true
  }

  class InterfaceApplyer(world: World, pos: BlockPos) extends IInteractionObject {

    override def createContainer(playerInventory: InventoryPlayer, playerIn: EntityPlayer): Container = {
      new ContainerApplyer(playerInventory, world, pos)
    }

    override def getGuiID: String = "inanimate:applyer"

    override def getDisplayName: ITextComponent = new TextComponentTranslation("Blah")

    override def getName: String = null

    override def hasCustomName: Boolean = false
  }
}
