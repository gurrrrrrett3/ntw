package sh.gart.ntw.core.block

open class BlockHandler(final val id: String) {
    fun onBreak() {
        throw Error("BlockHandler not implemented.")
    }

    fun onPlace() {
        throw Error("BlockHandler not implemented.")
    }

    fun onInteract() {
        throw Error("BlockHandler not implemented.")
    }

    fun onTick() {
        throw Error("BlockHandler not implemented.")
    }
}
