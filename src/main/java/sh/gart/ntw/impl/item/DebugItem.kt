package sh.gart.ntw.impl.item

import net.kyori.adventure.bossbar.BossBar
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerMoveEvent
import sh.gart.ntw.Ntw
import sh.gart.ntw.core.BlockStorage
import sh.gart.ntw.core.enum.BlockType
import sh.gart.ntw.core.enum.StorageType
import sh.gart.ntw.core.item.CustomItem
import sh.gart.ntw.core.util.Util
import sh.gart.ntw.core.util.VectorInt
import sh.gart.ntw.impl.block.container.base.Container

class DebugItem : CustomItem("ntw.debug_item", Component.text("Debug Item"), Material.BLAZE_ROD) {
    private val barColorMap: MutableMap<StorageType, BossBar.Color> = mutableMapOf()

    init {
        barColorMap[StorageType.Item] = BossBar.Color.RED
        barColorMap[StorageType.Fluid] = BossBar.Color.BLUE
        barColorMap[StorageType.Energy] = BossBar.Color.YELLOW
    }

    override fun onLoad() {
        Bukkit.getPluginManager().registerEvents(this, Ntw.getInstance())
    }

    @EventHandler
    fun onMove(e: PlayerMoveEvent) {
        if (!isHoldingItem(e.player)) return

        val block = Util.getTargetBlock(e.player, 5)

        val bars = e.player.activeBossBars()
        var bar = bars.firstOrNull()

        if (block.type == Material.AIR) {
            if (bar != null) {
                e.player.hideBossBar(bar)
            }
        } else if (BlockStorage.instance.hasBlock(VectorInt.fromLocation(block.location))) {
            val netBlock = BlockStorage.instance.getBlock(VectorInt.fromLocation(block.location))!!

            val color = if (netBlock.self.blockType == BlockType.CONTAINER) this.barColorMap[(netBlock.self as Container).type]!! else BossBar.Color.BLUE
            val progress = if (netBlock.self.blockType == BlockType.CONTAINER) (netBlock.self as Container).fillStatus() else 1.0f

            if (bar == null) {
                bar = BossBar.bossBar(Component.text("${netBlock.type} ${if (netBlock.self.blockType == BlockType.CONTAINER) {(netBlock.self as Container).fillStatusString()} else {""}}",),
                        progress,
                        color,
                        BossBar.Overlay.PROGRESS,
                    )
                e.player.showBossBar(bar)
            } else {
                bar.name(Component.text("${netBlock.type} ${if (netBlock.self.blockType == BlockType.CONTAINER) {(netBlock.self as Container).fillStatusString()} else {""}}"))
                bar.color(color)
                bar.progress(progress)
            }
        } else {
            if (bar != null) {
                e.player.hideBossBar(bar)
            }
        }
    }
}
