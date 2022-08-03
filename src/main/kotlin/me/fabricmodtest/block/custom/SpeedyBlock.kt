package me.fabricmodtest.block.custom

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.text.LiteralText
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


class SpeedyBlock(settings: Settings) : Block(settings) {
    companion object {
        val ID = "speedy_block"
    }

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult,
    ): ActionResult {
        // Called 4 time on right click:
        // 2 Times on the Server (for each Hand)
        // 2 Times on the Client (for each Hand)
        when {
            world.isClient() -> {
                when (hand) {
                    Hand.MAIN_HAND -> player.sendMessage(LiteralText("CLIENT: This is THE CLIENT! MAIN HAND!"), false);
                    else -> player.sendMessage(LiteralText("CLIENT: This is THE CLIENT! OFF HAND!"), false);
                }
            }
        }

        return ActionResult.PASS;
    }

    override fun onSteppedOn(world: World, pos: BlockPos, state: BlockState, entity: Entity) {
        when {
            !world.isClient() -> {
                if (entity !is LivingEntity) return
                entity.addStatusEffect(StatusEffectInstance(StatusEffects.SPEED, 300))
            }
        }

        return super.onSteppedOn(world, pos, state, entity)
    }
}