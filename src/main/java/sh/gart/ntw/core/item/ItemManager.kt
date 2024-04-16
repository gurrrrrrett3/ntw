package sh.gart.ntw.core.item

import org.bukkit.inventory.ItemStack
import sh.gart.ntw.Ntw

class ItemManager {
    companion object {
        val instance = ItemManager()
    }

    private val items: MutableMap<String, CustomItem> = mutableMapOf()

    fun registerItem(item: CustomItem) {
        items[item.id] = item

        item.onLoad()
        Ntw.getInstance().logger.info("Registered item: ${item.id}")
    }

    fun getItem(name: String): CustomItem? {
        return items[name]
    }

    fun getItemStack(name: String): ItemStack? {
        return items[name]?.getItemStack()
    }
}
