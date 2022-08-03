package me.fabricmodtest.item

import me.fabricmodtest.FabricMod
import me.fabricmodtest.item.custom.*
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.registry.FuelRegistry
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ItemsRegistry {
    @JvmStatic  val MYTHRIL_INGOT = registerItem(
        Mythrilngot.ID,
        Mythrilngot(FabricItemSettings().group(ItemsGroupRegistry.GROUP)),
    )
    @JvmStatic val MYTHRIL_NUGGET = registerItem(
        MythrilNugget.ID,
        MythrilNugget(FabricItemSettings().group(ItemsGroupRegistry.GROUP)),
    )
    @JvmStatic val MYTHRIL_RAW = registerItem(
        RawMythril.ID,
        RawMythril(FabricItemSettings().group(ItemsGroupRegistry.GROUP)),
    )
    @JvmStatic val DOWSING_ROD = registerItem(
        DowsingRodItem.ID,
        DowsingRodItem(FabricItemSettings().group(ItemsGroupRegistry.GROUP).maxDamage(16)),
    )
    @JvmStatic val LILAC_FLOWER_BULB = registerItem(
        LilacFlowerBulb.ID,
        LilacFlowerBulb(FabricItemSettings().group(ItemsGroupRegistry.GROUP)),
    )

    fun register() {
        FuelRegistry.INSTANCE.add(MYTHRIL_RAW, 300)

        FabricMod.Logger.info("[${FabricMod.MOD_ID}] Registering items...")
    }

    fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registry.ITEM, Identifier(FabricMod.MOD_ID, name), item)
    }
}