package sh.gart.ntw.impl.block.container.base

import net.kyori.adventure.text.Component
import org.bukkit.Material
import sh.gart.ntw.core.enum.StorageType

class EnergyContainer(
    id: String,
    displayName: Component,
    material: Material,
    size: Int,
) : Container(id, displayName, material, StorageType.Energy, size) {
    override fun fillStatusString(): String {
        return "${super.amount}kw /${super.size}kw"
    }

    override fun toString(): String {
        return "EnergyContainer(${super.amount}kw/${super.size}kw)"
    }
}
