package me.fabricmodtest.item.custom.tools

import net.minecraft.item.HoeItem
import net.minecraft.item.ToolMaterial

class ModHoeItem(
    material: ToolMaterial,
    attackDamage: Int,
    attackSpeed: Float,
    settings: Settings,
) : HoeItem(material, attackDamage, attackSpeed, settings)