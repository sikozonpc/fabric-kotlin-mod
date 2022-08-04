package me.fabricmodtest.item.custom.tools

import net.minecraft.item.AxeItem
import net.minecraft.item.ToolMaterial

class ModAxeItem(
    material: ToolMaterial,
    attackDamage: Float,
    attackSpeed: Float,
    settings: Settings,
) : AxeItem(material, attackDamage, attackSpeed, settings)