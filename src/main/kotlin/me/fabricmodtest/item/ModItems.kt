package me.fabricmodtest.item

import me.fabricmodtest.FabricMod
import me.fabricmodtest.item.custom.*
import me.fabricmodtest.item.custom.tools.*
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ShovelItem
import net.minecraft.item.SwordItem
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModItems {
    @JvmStatic  val MYTHRIL_INGOT = registerItem(
        Mythrilngot.ID,
        Mythrilngot(FabricItemSettings().group(ModItemGroups.GROUP)),
    )
    @JvmStatic val MYTHRIL_NUGGET = registerItem(
        MythrilNugget.ID,
        MythrilNugget(FabricItemSettings().group(ModItemGroups.GROUP)),
    )
    @JvmStatic val MYTHRIL_RAW = registerItem(
        RawMythril.ID,
        RawMythril(FabricItemSettings().group(ModItemGroups.GROUP)),
    )
    @JvmStatic val DOWSING_ROD = registerItem(
        DowsingRodItem.ID,
        DowsingRodItem(FabricItemSettings().group(ModItemGroups.GROUP).maxDamage(16)),
    )
    @JvmStatic val LILAC_FLOWER_BULB = registerItem(
        LilacFlowerBulb.ID,
        LilacFlowerBulb(FabricItemSettings().group(ModItemGroups.GROUP)),
    )
    @JvmStatic val MYTHRIL_SWORD = registerItem(
        "mythril_sword",
        ModSlownessSwordItem(ModToolMaterials.MYTHRIL, 1, 2f, FabricItemSettings().group(ModItemGroups.GROUP)),
    )
    @JvmStatic val MYTHRIL_AXE = registerItem(
        "mythril_axe",
        ModAxeItem(ModToolMaterials.MYTHRIL, 3f, 1f, FabricItemSettings().group(ModItemGroups.GROUP)),
    )
    @JvmStatic val MYTHRIL_HOE = registerItem(
        "mythril_hoe",
        ModHoeItem(ModToolMaterials.MYTHRIL, 0, 0f, FabricItemSettings().group(ModItemGroups.GROUP)),
    )
    @JvmStatic val MYTHRIL_SHOVEL = registerItem(
        "mythril_shovel",
        ShovelItem(ModToolMaterials.MYTHRIL, 1f, 1f, FabricItemSettings().group(ModItemGroups.GROUP)),
    )
    @JvmStatic val MYTHRIL_PICKAXE = registerItem(
        "mythril_pickaxe",
        ModPickaxeItem(ModToolMaterials.MYTHRIL, 2, 5f, FabricItemSettings().group(ModItemGroups.GROUP)),
    )

    fun register() {
        FabricMod.Logger.info("[${FabricMod.MOD_ID}] Registering items...")
    }

    fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registry.ITEM, Identifier(FabricMod.MOD_ID, name), item)
    }
}