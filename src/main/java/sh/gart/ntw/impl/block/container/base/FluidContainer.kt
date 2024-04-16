package sh.gart.ntw.impl.block.container.base

import net.kyori.adventure.text.Component
import org.bukkit.Material
import sh.gart.ntw.core.enum.StorageType

open class FluidContainer(
    id: String,
    displayName: Component,
    material: Material,
    size: Int,
) : Container(id, displayName, material, StorageType.Fluid, size) {
    val holding: Material = Material.AIR

    override fun fillStatusString(): String {
        return "${super.amount}b/${super.size}b"
    }

    override fun toString(): String {
        return "FluidContainer($material [${super.amount}/${super.size}])"
    }
}
