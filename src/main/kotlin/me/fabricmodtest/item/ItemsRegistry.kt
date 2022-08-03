package me.fabricmodtest.item

import me.fabricmodtest.FabricMod
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.registry.FuelRegistry
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ItemsRegistry {
    val MYTHRIL_INGOT = registerItem(
        Mythrilngot.ID,
        Mythrilngot(FabricItemSettings().group(FabricMod.MOD_ITEMS_GROUP)),
    )
    val MYTHRIL_NUGGET = registerItem(
        MythrilNugget.ID,
        MythrilNugget(FabricItemSettings().group(FabricMod.MOD_ITEMS_GROUP)),
    )
    val MYTHRIL_RAW = registerItem(
        RawMythril.ID,
        RawMythril(FabricItemSettings().group(FabricMod.MOD_ITEMS_GROUP)),
    )

    fun register() {
        FuelRegistry.INSTANCE.add(MYTHRIL_RAW, 300)

        FabricMod.Logger.info("[${FabricMod.MOD_ID}] Registering items...")
    }

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registry.ITEM, Identifier(FabricMod.MOD_ID, name), item)
    }
}