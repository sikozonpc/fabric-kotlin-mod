package me.fabricmodtest.block

import me.fabricmodtest.FabricMod
import me.fabricmodtest.block.custom.*
import me.fabricmodtest.item.ModItemGroups
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.FenceBlock
import net.minecraft.block.FenceGateBlock
import net.minecraft.block.Material
import net.minecraft.block.PressurePlateBlock
import net.minecraft.block.SlabBlock
import net.minecraft.block.WallBlock
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.world.World


enum class OreVariant { STONE, DEEPSLATE, NETHERRACK }

object BlocksRegistry {
    @JvmStatic
    val MYTHRIL_BLOCK = registerBlock(
        MythrilBlock.ID,
        Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool().luminance(6)),
        ModItemGroups.GROUP,
    )
    @JvmStatic
    val MYTHRIL_ORE = registerBlock(
        MythrilOre.getVariantID(OreVariant.STONE),
        Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()),
        ModItemGroups.GROUP,
    )
    @JvmStatic
    val MYTHRIL_ORE_DEEPSLATE = registerBlock(
        MythrilOre.getVariantID(OreVariant.DEEPSLATE),
        Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()),
        ModItemGroups.GROUP,
    )
    @JvmStatic
    val MYTHRIL_ORE_NETHERRACK = registerBlock(
        MythrilOre.getVariantID(OreVariant.NETHERRACK),
        Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()),
        ModItemGroups.GROUP,
    )
    @JvmStatic
    val SPEEDY_BLOCK = registerBlock(
        SpeedyBlock.ID,
        SpeedyBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
        ModItemGroups.GROUP,
        "block.fabricmodtest.speedy_block.tooltip",
    )
    @JvmStatic
    val MYTHRIL_BUTTON = registerBlock(
        ModStoneButtonBlock.ID,
        ModStoneButtonBlock(FabricBlockSettings.of(Material.METAL).requiresTool().noCollision()),
        ModItemGroups.GROUP,
    )
    @JvmStatic
    val MYTHRIL_PRESSURE_PLATE = registerBlock(
        ModPressurePlateBlock.ID,
        ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING ,FabricBlockSettings.of(Material.METAL).requiresTool()),
        ModItemGroups.GROUP,
    )
    @JvmStatic
    val MYTHRIL_FENCE = registerBlock(
        "mythril_fence",
        FenceBlock(FabricBlockSettings.of(Material.METAL).requiresTool()),
        ModItemGroups.GROUP,
    )
    @JvmStatic
    val MYTHRIL_FENCE_GATE = registerBlock(
        "mythril_fence_gate",
        FenceGateBlock(FabricBlockSettings.of(Material.METAL).requiresTool()),
        ModItemGroups.GROUP,
    )
    @JvmStatic
    val MYTHRIL_WALL = registerBlock(
        "mythril_wall",
        WallBlock(FabricBlockSettings.of(Material.METAL).requiresTool()),
        ModItemGroups.GROUP,
    )
    @JvmStatic
    val MYTHRIL_SLAB = registerBlock(
        "mythril_slab",
        SlabBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
        ModItemGroups.GROUP,
    )
    @JvmStatic
    val MYTHRIL_STAIRS = registerBlock(
        "mythril_stairs",
        ModStairsBlock(MYTHRIL_BLOCK.defaultState, FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
        ModItemGroups.GROUP,
    )
    @JvmStatic
    val KAUPEN_DOOR = registerBlock(
        "kaupen_door",
        ModDoorBlock(FabricBlockSettings.of(Material.WOOD).nonOpaque()),
        ModItemGroups.GROUP,
    )
    @JvmStatic
    val KAUPEN_TRAPDOOR = registerBlock(
        "kaupen_trapdoor",
        ModTrapdoorBlock(FabricBlockSettings.of(Material.WOOD).nonOpaque()),
        ModItemGroups.GROUP,
    )

    fun register() {
        FabricMod.Logger.info("[${FabricMod.MOD_ID}] Registering blocks...")
    }

    private fun registerBlock(name: String, block: Block, itemGroup: ItemGroup, tooltipKey: String = ""): Block {
        registerBlockItem(name, block, itemGroup, tooltipKey)
        return Registry.register(Registry.BLOCK, Identifier(FabricMod.MOD_ID, name), block)
    }

    private fun registerBlockItem(name: String, block: Block, itemGroup: ItemGroup, tooltipKey: String = ""): Item {
        return Registry.register(
            Registry.ITEM,
            Identifier(FabricMod.MOD_ID, name),
            object : BlockItem(block, FabricItemSettings().group(itemGroup)) {
                override fun appendTooltip(
                    stack: ItemStack?,
                    world: World?,
                    tooltip: MutableList<Text>?,
                    context: TooltipContext?,
                ) {
                    if (tooltipKey.isEmpty()) return
                    tooltip?.add(TranslatableText(tooltipKey))
                }
            }
        )
    }
}