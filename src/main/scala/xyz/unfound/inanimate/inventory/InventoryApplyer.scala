package xyz.unfound.inanimate.inventory

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.{Container, IInventory, ItemStackHelper}
import net.minecraft.item.ItemStack
import net.minecraft.util.text.{ITextComponent, TextComponentTranslation}

import scala.collection.mutable.ListBuffer

/**
  * Created by lbq on 9/9/16.
  */
class InventoryApplyer(eventHandler : Container) extends IInventory {

  val (width, height) = (3, 3)

  val stackList : ListBuffer[ItemStack] = (for (i <- 0 until width * height + 1) yield null)(collection.breakOut)


  override def decrStackSize(index: Int, count: Int): ItemStack = {
    val itemstack: ItemStack = ItemStackHelper.getAndSplit(this.stackList.toArray, index, count)

    if (itemstack != null) this.eventHandler.onCraftMatrixChanged(this)

    itemstack
  }

  override def closeInventory(player: EntityPlayer) = Unit

  override def getSizeInventory: Int = stackList.length

  override def clear(): Unit = stackList.clear()

  override def getInventoryStackLimit: Int = 64

  override def markDirty(): Unit = Unit


  // TODO: possible type restriction
  override def isItemValidForSlot(index: Int, stack: ItemStack): Boolean = true

  override def openInventory(player: EntityPlayer): Unit = Unit

  override def getFieldCount: Int = 0

  override def getField(id: Int): Int = 0

  override def setInventorySlotContents(index: Int, stack: ItemStack): Unit = {
    stackList(index) = stack
    // TODO: on change handler
  }

  override def isUseableByPlayer(player: EntityPlayer) = true

  override def getStackInSlot(index: Int): ItemStack = stackList(index)

  override def removeStackFromSlot(index: Int): ItemStack = ItemStackHelper.getAndRemove(stackList.toArray, index)

  override def setField(id: Int, value: Int) = Unit

  override def getDisplayName: ITextComponent = new TextComponentTranslation(this.getName, new Array[AnyRef](0))

  override def getName: String = "container.applyer"

  override def hasCustomName: Boolean = false
}
