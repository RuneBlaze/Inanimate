package xyz.unfound.inanimate

import net.minecraft.block.Block
import net.minecraft.item.{Item, ItemBlock}
import net.minecraftforge.fml.common.registry.GameRegistry

/**
  * Created by lbq on 9/10/16.
  */
class CommonProxy {
  def registerBlock(block : Block, registryName : String) : Unit = {
    block.setRegistryName("inanimate", registryName)
    block.setUnlocalizedName(block.getRegistryName.toString)
    block.setCreativeTab(Inanimate.TAB)

    val iblock = new ItemBlock(block)
    iblock.setRegistryName(block.getRegistryName)
    GameRegistry.register(block)
    GameRegistry.register(iblock)
  }

  def registerItem(item : Item, registerName : String) : Unit = {
    item.setRegistryName("inanimate", registerName)
    item.setUnlocalizedName(item.getRegistryName.toString)
    item.setCreativeTab(Inanimate.TAB)
    GameRegistry.register(item)
  }
}
