package sh.gart.ntw.impl.block.container.base

import net.kyori.adventure.text.Component
import org.bukkit.Material
import sh.gart.ntw.core.block.CustomBlock
import sh.gart.ntw.core.enum.BlockType
import sh.gart.ntw.core.enum.StorageType

open class Container(
    id: String,
    displayName: Component,
    material: Material,
    final val type: StorageType,
    public final val size: Int,
) : CustomBlock(
        id,
        BlockType.CONTAINER,
        displayName,
        material,
    ) {
    val amount: Int = 0

    fun fillStatus(): Float {
        return amount.toFloat() / size.toFloat()
    }

    open fun fillStatusString(): String {
        return "${amount}/${size}"
    }

    override fun toString(): String {
        return "Container([$amount/$size])"
    }
}
