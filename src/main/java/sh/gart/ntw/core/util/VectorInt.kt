package sh.gart.ntw.core.util

import org.bukkit.Location

class VectorInt(val x: Int = 0, val y: Int = 0, val z: Int = 0) {
    companion object {
        fun fromLocation(location: Location): VectorInt {
            return VectorInt(location.blockX, location.blockY, location.blockZ)
        }
    }

    override fun toString(): String {
        return "[$x, $y, $z]"
    }
}
