package me.fabricmodtest.item.custom.tools

import me.fabricmodtest.item.ModItems
import net.fabricmc.yarn.constants.MiningLevels
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.util.Lazy
import java.util.function.Supplier


enum class ModToolMaterials(
    private val miningLevel: Int,
    private val itemDurability: Int,
    private val miningSpeed: Float,
    private val attackDamage: Float,
    private val enchantability: Int,
    repairIngredient: Supplier<Ingredient>,
) :
    ToolMaterial {
    MYTHRIL(MiningLevels.IRON, 560, 10.0f, 2.5f, 24,
        Supplier { Ingredient.ofItems(ModItems.MYTHRIL_INGOT) });

    private val repairIngredient: Lazy<Ingredient>

    init {
        this.repairIngredient = Lazy(repairIngredient)
    }

    override fun getDurability(): Int = itemDurability
    override fun getMiningSpeedMultiplier(): Float = miningSpeed
    override fun getAttackDamage(): Float = attackDamage
    override fun getMiningLevel(): Int = miningLevel
    override fun getEnchantability(): Int = enchantability
    override fun getRepairIngredient(): Ingredient = repairIngredient.get()
}
