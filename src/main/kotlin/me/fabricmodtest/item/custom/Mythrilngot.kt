package me.fabricmodtest.item.custom

import me.fabricmodtest.FabricMod
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.Formatting
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World


class Mythrilngot(settings: Settings) : Item(settings) {
    companion object {
        val ID = "mythril_ingot"
    }

    override fun use(world: World, playerEntity: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0f, 1.0f)
        playerEntity.experienceLevel = 42
        return TypedActionResult.success(playerEntity.getStackInHand(hand))
    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?,
    ) {
        tooltip?.add(TranslatableText("item.${FabricMod.MOD_ID}.$ID.tooltip").formatted(Formatting.DARK_AQUA))
    }
}