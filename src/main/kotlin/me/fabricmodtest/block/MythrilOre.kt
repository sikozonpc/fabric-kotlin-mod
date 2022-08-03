package me.fabricmodtest.block

import net.minecraft.item.Item


class MythrilOre(settings: Settings) : Item(settings) {
    companion object {
        fun getVariantID(variant: OreVariant): String = when (variant) {
            OreVariant.STONE -> "mythril_ore"
            OreVariant.NETHERRACK -> "netherrack_mythril_ore"
            OreVariant.DEEPSLATE -> "deepslate_mythril_ore"
        }
    }
}