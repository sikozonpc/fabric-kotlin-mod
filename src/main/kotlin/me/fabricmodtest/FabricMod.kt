package me.fabricmodtest

import me.fabricmodtest.block.BlocksRegistry
import me.fabricmodtest.item.ItemsRegistry
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger


object FabricMod : ModInitializer {
    const val MOD_ID = "fabricmodtest"

    val Logger: Logger = LogManager.getLogger(MOD_ID)

    override fun onInitialize() {
        ItemsRegistry.register()
        BlocksRegistry.register()

        Logger.info("Fabric Test Mod has been initialized.")
    }

    val MOD_ITEMS_GROUP: ItemGroup = FabricItemGroupBuilder.create(
        Identifier(MOD_ID, MOD_ID))
        .icon { ItemStack(Items.BOWL) }
        .build()
}