package sh.gart.ntw.core.util

import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.util.BlockIterator

class Util {
    companion object {
        fun getTargetBlock(
            player: Player,
            range: Int,
        ): Block {
            val iter = BlockIterator(player, range)
            var lastBlock: Block = iter.next()
            while (iter.hasNext()) {
                lastBlock = iter.next()
                if (lastBlock.getType() === Material.AIR) continue
                break
            }
            return lastBlock
        }
    }
}
