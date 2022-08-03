package me.fabricmodtest

import me.fabricmodtest.block.BlocksRegistry
import me.fabricmodtest.item.FoodComponentsRegistry
import me.fabricmodtest.item.ItemsRegistry
import net.fabricmc.api.ModInitializer
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger


object FabricMod : ModInitializer {
    const val MOD_ID = "fabricmodtest"

    val Logger: Logger = LogManager.getLogger(MOD_ID)

    override fun onInitialize() {
        ItemsRegistry.register()
        FoodComponentsRegistry.register()
        BlocksRegistry.register()

        Logger.info("Fabric Test Mod has been initialized.")
    }
}