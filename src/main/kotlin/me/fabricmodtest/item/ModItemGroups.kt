package me.fabricmodtest.item

import me.fabricmodtest.FabricMod
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier

object ModItemGroups {
    val GROUP: ItemGroup = FabricItemGroupBuilder.create(
        Identifier(FabricMod.MOD_ID, FabricMod.MOD_ID))
        .icon { ItemStack(ModItems.MYTHRIL_INGOT) }
        .build()
}