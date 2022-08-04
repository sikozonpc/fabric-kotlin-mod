package me.fabricmodtest

import me.fabricmodtest.block.BlocksRegistry
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer

object FabricClientMod : ClientModInitializer {
    override fun onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.KAUPEN_DOOR, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.KAUPEN_TRAPDOOR, RenderLayer.getCutout())
    }
}