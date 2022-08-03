package me.fabricmodtest.item

import me.fabricmodtest.FabricMod
import me.fabricmodtest.item.custom.food.GrapeItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings

object FoodComponentsRegistry {
	@JvmStatic val GRAPE = ItemsRegistry.registerItem(
		GrapeItem.ID,
		GrapeItem(FabricItemSettings().group(ItemsGroupRegistry.GROUP).food(GrapeItem.foodComponent)),
	)

	fun register() {
		FabricMod.Logger.info("[${FabricMod.MOD_ID}] Registering food items...")
	}
}