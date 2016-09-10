package xyz.unfound.inanimate.inventory

import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import xyz.unfound.inanimate.block.Blocks
import net.minecraft.inventory._
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

/**
  * Created by lbq on 9/9/16.
  */
class ContainerApplyer(playerInventory : InventoryPlayer,
                       world: World, pos : BlockPos) extends Container {

  val applyMatrix = new InventoryApplyer(this)
  val craftResult: IInventory = new InventoryCraftResult

  addSlotToContainer(new Slot(craftResult, 0, 124, 35))

  for (i <- 0 until 3) {
    for (j <- 0 until 3) {
      addSlotToContainer(new Slot(applyMatrix, j + i * 3, 15 + 30 + j * 18, 17 + i * 18))
    }
  }

  addSlotToContainer(new Slot(applyMatrix, 9, 23, 17 + 9))

  for (k <- 0 until 3) {
    for (i1 <- 1 until 9) {
      addSlotToContainer(
        new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18)
      )
    }
  }

  for (l <- 0 until 9) {
    addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 142))
  }

  override def canInteractWith(playerIn: EntityPlayer): Boolean = {
    val tmp = world.getBlockState(pos).getBlock != Blocks.APPLYER
    if (tmp) false
    else playerIn.getDistanceSq(pos.getX + 0.5, pos.getY + 0.5, pos.getZ + 0.5) <= 64
  }
}
