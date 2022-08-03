package me.fabricmodtest.block

import me.fabricmodtest.FabricMod
import me.fabricmodtest.block.custom.MythrilBlock
import me.fabricmodtest.block.custom.MythrilOre
import me.fabricmodtest.item.ItemsGroup
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

enum class OreVariant { STONE, DEEPSLATE, NETHERRACK }

object BlocksRegistry {
    @JvmStatic val MYTHRIL_BLOCK = registerBlock(
        MythrilBlock.ID,
        Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool().luminance(6)),
        ItemsGroup.GROUP,
    )
    @JvmStatic val MYTHRIL_ORE = registerBlock(
        MythrilOre.getVariantID(OreVariant.STONE),
        Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()),
        ItemsGroup.GROUP,
    )
    @JvmStatic val MYTHRIL_ORE_DEEPSLATE = registerBlock(
        MythrilOre.getVariantID(OreVariant.DEEPSLATE),
        Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()),
        ItemsGroup.GROUP,
    )
    val MYTHRIL_ORE_NETHERRACK = registerBlock(
        MythrilOre.getVariantID(OreVariant.NETHERRACK),
        Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()),
        ItemsGroup.GROUP,
    )

    fun register() {
        FabricMod.Logger.info("[${FabricMod.MOD_ID}] Registering blocks...")
    }

    private fun registerBlock(name: String, block: Block, itemGroup: ItemGroup): Block {
        registerBlockItem(name, block, itemGroup)
        return Registry.register(Registry.BLOCK, Identifier(FabricMod.MOD_ID, name), block)
    }

    private fun registerBlockItem(name: String, block: Block, itemGroup: ItemGroup): Item {
        return Registry.register(
            Registry.ITEM,
            Identifier(FabricMod.MOD_ID, name),
            BlockItem(block, FabricItemSettings().group(itemGroup)),
        )
    }
}