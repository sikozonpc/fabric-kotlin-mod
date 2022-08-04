package me.fabricmodtest.item.custom.tools

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial


class ModSlownessSwordItem(
    toolMaterial: ToolMaterial,
    attackDamage: Int,
    attackSpeed: Float,
    settings: Settings,
) : SwordItem(toolMaterial, attackDamage, attackSpeed, settings) {
    override fun postHit(stack: ItemStack, target: LivingEntity, attacker: LivingEntity): Boolean {
        target.addStatusEffect(
            StatusEffectInstance(StatusEffects.SLOWNESS, 200, 2),
            attacker,
        )
        return super.postHit(stack, target, attacker)
    }
}