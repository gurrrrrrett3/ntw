package sh.gart.ntw.core.block

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import sh.gart.ntw.core.enum.BlockType
import sh.gart.ntw.core.util.Keys

open class CustomBlock(val id: String, val blockType: BlockType, val name: Component, val material: Material, val handler: BlockHandler? = null) {
    override fun toString(): String {
        return "CustomBlock($id, $name, $material)"
    }

    fun getItemStack(): ItemStack {
        val item = ItemStack(material)
        val meta = item.itemMeta

        meta.persistentDataContainer.set(Keys.customItemType, PersistentDataType.STRING, id)
        meta.displayName(name)
        item.itemMeta = meta

        return item
    }
}
