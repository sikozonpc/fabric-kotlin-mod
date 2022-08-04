package me.fabricmodtest.item.custom.tools

import net.minecraft.item.PickaxeItem
import net.minecraft.item.ToolMaterial

class ModPickaxeItem(
    material: ToolMaterial,
    attackDamage: Int,
    attackSpeed: Float,
    settings: Settings,
) : PickaxeItem(material, attackDamage, attackSpeed, settings)