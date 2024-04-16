package sh.gart.ntw.core

import sh.gart.ntw.Ntw
import sh.gart.ntw.core.block.NetworkBlock
import sh.gart.ntw.core.util.VectorInt

class BlockStorage {
    companion object {
        val instance = BlockStorage()
    }

    val blocks: MutableMap<String, NetworkBlock> = mutableMapOf()

    fun addBlock(block: NetworkBlock) {
        blocks[block.position.toString()] = block

        Ntw.getInstance().logger.info("Added block at ${block.position}")
    }

    fun removeBlock(block: NetworkBlock) {
        blocks.remove(block.position.toString())

        Ntw.getInstance().logger.info("Removed block at ${block.position}")
    }

    fun removeBlockAt(position: VectorInt) {
        blocks.remove(position.toString())

        Ntw.getInstance().logger.info("Removed block at $position")
    }

    fun getBlock(position: VectorInt): NetworkBlock? {
        return blocks[position.toString()]
    }

    fun hasBlock(position: VectorInt): Boolean {
        return blocks.containsKey(position.toString())
    }
}
