package sh.gart.ntw.core.block

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.persistence.PersistentDataType
import sh.gart.ntw.core.BlockStorage
import sh.gart.ntw.core.item.CustomItem
import sh.gart.ntw.core.item.ItemManager
import sh.gart.ntw.core.util.Keys
import sh.gart.ntw.core.util.VectorInt

class BlockManager : Listener {
    companion object {
        val instance = BlockManager()
    }

    private val blocks: MutableMap<String, CustomBlock> = mutableMapOf()

    fun registerBlock(block: CustomBlock) {
        blocks[block.id] = block

        ItemManager.instance.registerItem(CustomItem(block.id, block.name, block.material))
    }

    fun getBlock(name: String): CustomBlock? {
        return blocks[name]
    }

    @EventHandler()
    fun onBlockPlace(e: BlockPlaceEvent) {
        val item = e.itemInHand
        val meta = item.itemMeta

        if (meta != null && meta.persistentDataContainer.has(Keys.customItemType, PersistentDataType.STRING)) {
            val id = meta.persistentDataContainer.get(Keys.customItemType, PersistentDataType.STRING)
            val block = instance.getBlock(id!!)
            if (block != null) {
                val networkBlock = NetworkBlock(VectorInt.fromLocation(e.blockPlaced.location), block)
                BlockStorage.instance.addBlock(networkBlock)
            }
        }
    }

    @EventHandler()
    fun onBlockBreak(e: BlockBreakEvent) {
        if (BlockStorage.instance.hasBlock(VectorInt.fromLocation(e.block.location))) {
            BlockStorage.instance.removeBlockAt(VectorInt.fromLocation(e.block.location))
        }
    }
}
