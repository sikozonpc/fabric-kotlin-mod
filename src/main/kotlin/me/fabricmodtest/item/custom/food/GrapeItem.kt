package me.fabricmodtest.item.custom.food

import net.minecraft.item.FoodComponent
import net.minecraft.item.Item


class GrapeItem(settings: Settings) : Item(settings) {
    companion object {
        val ID = "grape"
        val foodComponent: FoodComponent = FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()
    }
}