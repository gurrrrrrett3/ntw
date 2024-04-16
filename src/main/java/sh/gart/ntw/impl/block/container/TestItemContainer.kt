package sh.gart.ntw.impl.block.container

import net.kyori.adventure.text.Component
import org.bukkit.Material
import sh.gart.ntw.impl.block.container.base.ItemContainer

class TestItemContainer : ItemContainer(
    "item_container",
    Component.text("Item Container"),
    Material.WHITE_TERRACOTTA,
    64,
)
