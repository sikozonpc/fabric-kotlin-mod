package me.fabricmodtest.item.custom

import me.fabricmodtest.util.ModTags
import net.minecraft.block.Block
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.ActionResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import net.minecraft.world.World


class DowsingRodItem(settings: Settings) : Item(settings) {
    companion object {
        val ID = "dowsing_rod"
    }

    override fun useOnBlock(context: ItemUsageContext?): ActionResult {
        if (context?.world === null) return super.useOnBlock(context)


        if (context.world.isClient()) {
            val positionClicked = context.blockPos
            val player = context.player
            var foundBlock = false

            // Because in this minecraft version the world goes to -64
            val worldOffset = 64
            for (i in 0..positionClicked.y + worldOffset) {
                val blockBelow = context.world.getBlockState(positionClicked.down(i)).block

                if (isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.down(i), player!!, blockBelow)
                    foundBlock = true
                    break
                }
            }

            if (!foundBlock) {
                player?.sendMessage(TranslatableText("item.fabricmodtest.dowsing_rod.no_valuables"), false)
            }
        }

        context.stack.damage(1, context.player) { it?.sendToolBreakStatus(it.activeHand) }

        return super.useOnBlock(context)
    }

    override fun appendTooltip(
        stack: ItemStack?, world: World?, tooltip: MutableList<Text>?, context: TooltipContext?
    ) {
        when {
            Screen.hasShiftDown() -> tooltip?.add(TranslatableText("item.fabricmodtest.dowsing_rod.tooltip.shift"))
            else -> tooltip?.add(TranslatableText("item.fabricmodtest.dowsing_rod.tooltip"))
        }
    }

    private fun outputValuableCoordinates(blockPos: BlockPos, player: PlayerEntity, blockBelow: Block) {
        val bellowBlockName = blockBelow.asItem().name.string.toString()
        player.sendMessage(
            LiteralText("Found $bellowBlockName at (${blockPos.x}, ${blockPos.y}, ${blockPos.z})"), false
        )
    }

    private fun isValuableBlock(block: Block): Boolean = Registry.BLOCK.getOrCreateEntry(
        Registry.BLOCK.getKey(block).get()
    ).isIn(ModTags.Blocks.DOWSING_ROD_DETECTABLE_BLOCKS)
}