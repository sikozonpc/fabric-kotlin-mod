package me.fabricmodtest.util

import me.fabricmodtest.FabricMod
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.tag.TagKey
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


object ModTags {
    object Blocks {
        val DOWSING_ROD_DETECTABLE_BLOCKS: TagKey<Block> = createTag("dowsing_rod_detectable_blocks")

        private fun createTag(name: String): TagKey<Block> {
            return TagKey.of(Registry.BLOCK_KEY, Identifier(FabricMod.MOD_ID, name))
        }

        private fun createCommonTag(name: String): TagKey<Block> {
            return TagKey.of(Registry.BLOCK_KEY, Identifier("c", name))
        }
    }

    object Items {
        val MYTHRIL_INGOTS: TagKey<Item> = createCommonTag("mythril_ingots")
        val MYTHRIL_NUGGETS: TagKey<Item> = createCommonTag("mythril_nuggets")

        private fun createTag(name: String): TagKey<Item> {
            return TagKey.of(Registry.ITEM_KEY, Identifier(FabricMod.MOD_ID, name))
        }

        private fun createCommonTag(name: String): TagKey<Item> {
            return TagKey.of(Registry.ITEM_KEY, Identifier("c", name))
        }
    }
}