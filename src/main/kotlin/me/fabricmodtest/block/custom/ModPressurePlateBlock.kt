package me.fabricmodtest.block.custom

import net.minecraft.block.PressurePlateBlock

class ModPressurePlateBlock(type: ActivationRule, settings: Settings) : PressurePlateBlock(type, settings) {
    companion object {
        val ID = "mythril_pressure_plate"
    }
}