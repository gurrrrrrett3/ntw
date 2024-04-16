package sh.gart.ntw

import sh.gart.ntw.core.block.BlockManager
import sh.gart.ntw.core.item.ItemManager
import sh.gart.ntw.impl.block.container.TestFluidContainer
import sh.gart.ntw.impl.block.container.TestItemContainer
import sh.gart.ntw.impl.item.DebugItem

class Loader {
    companion object {
        fun load() {
            // ITEMS
            ItemManager.instance.registerItem(DebugItem())

            // BLOCKS
            BlockManager.instance.registerBlock(TestItemContainer())
            BlockManager.instance.registerBlock(TestFluidContainer())
        }
    }
}
