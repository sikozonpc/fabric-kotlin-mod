package me.fabricmodtest.item

import me.fabricmodtest.FabricMod
import net.fabricmc.fabric.api.registry.FuelRegistry
import net.minecraft.item.Item

open class FuelItem(settings: Settings) : Item(settings) {
    init {
        registerAsFuel()
    }

    private fun registerAsFuel() {
        FuelRegistry.INSTANCE.add(this, 200)
        FabricMod.Logger.info("[${FabricMod.MOD_ID}] Registered Fuel for ${this.javaClass.name}")
    }
}