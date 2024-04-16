package sh.gart.ntw.impl.block.container.base

import net.kyori.adventure.text.Component
import org.bukkit.Material
import sh.gart.ntw.core.enum.StorageType

open class ItemContainer(
    id: String,
    displayName: Component,
    material: Material,
    size: Int,
) : Container(id, displayName, material, StorageType.Item, size) {
    val holding: Material = Material.AIR

    override fun toString(): String {
        return "ItemContainer($material [${super.amount}b/${super.size}b])"
    }
}
