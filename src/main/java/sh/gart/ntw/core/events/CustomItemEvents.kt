package sh.gart.ntw.core.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

object CustomItemEvents : Listener {
    @EventHandler()
    public fun onMove(e: PlayerMoveEvent) {
    }
}
