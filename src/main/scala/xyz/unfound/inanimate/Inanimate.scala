package xyz.unfound.inanimate


import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraftforge.fml.common.{Mod, SidedProxy}
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.network.NetworkRegistry
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.relauncher.{Side, SideOnly}
import xyz.unfound.inanimate.block.Blocks
import xyz.unfound.inanimate.client.GuiHandler


@Mod(modid = "inanimate", version = "1.10.2-0.1.0", modLanguage = "scala")
object Inanimate {

  @SidedProxy(
    clientSide="xyz.unfound.inanimate.client.ClientProxy",
    serverSide="xyz.unfound.inanimate.CommonProxy")
  var proxy : CommonProxy = null

  @EventHandler def preInit(fMLPreInitializationEvent: FMLPreInitializationEvent) : Unit = {

  }

  val TAB = new CreativeTabs("Inanimate") {
    @SideOnly(Side.CLIENT)
    override def getTabIconItem: Item = Items.APPLE
  }



  @EventHandler def init(event: FMLInitializationEvent): Unit = {
    proxy.registerBlock(Blocks.APPLYER, "blockApplyer")
    NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler)
  }

}
