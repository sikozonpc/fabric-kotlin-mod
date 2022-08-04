package me.fabricmodtest.block.custom

import me.fabricmodtest.block.OreVariant
import net.minecraft.block.Block
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.world.BlockView


class MythrilOre(settings: Settings) : Block(settings) {
    companion object {
        fun getVariantID(variant: OreVariant): String = when (variant) {
            OreVariant.STONE -> "mythril_ore"
            OreVariant.NETHERRACK -> "netherrack_mythril_ore"
            OreVariant.DEEPSLATE -> "deepslate_mythril_ore"
        }
    }
}