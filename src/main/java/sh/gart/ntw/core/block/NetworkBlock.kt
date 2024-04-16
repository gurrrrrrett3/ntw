package sh.gart.ntw.core.block

import sh.gart.ntw.core.Network
import sh.gart.ntw.core.util.VectorInt
import java.util.UUID

class NetworkBlock(public val position: VectorInt, val self: CustomBlock) {
    val type: String = self.id
    val id: UUID = UUID.randomUUID()
    val network: Network? = null

    override fun toString(): String {
        return "NetworkBlock()"
    }
}
