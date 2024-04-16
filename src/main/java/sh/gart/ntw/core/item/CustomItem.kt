package sh.gart.ntw.core.item

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import sh.gart.ntw.core.util.Keys

open class CustomItem(val id: String, val name: Component, val material: Material) : Listener {
    fun getItemStack(): ItemStack {
        val item = ItemStack(material)
        val meta = item.itemMeta

        meta.persistentDataContainer.set(Keys.customItemType, PersistentDataType.STRING, id)
        meta.displayName(name)
        item.itemMeta = meta

        return item
    }

    open fun onLoad() {
        // override this
    }

    fun isHoldingItem(player: Player): Boolean {
        val item = player.inventory.itemInMainHand
        val meta = item.itemMeta

        if (meta != null && meta.persistentDataContainer.has(Keys.customItemType, PersistentDataType.STRING)) {
            val id = meta.persistentDataContainer.get(Keys.customItemType, PersistentDataType.STRING)
            if (id == this.id) {
                return true
            }
        }

        return false
    }

    override fun toString(): String {
        return "CustomItem($id, $name, $material)"
    }
}
