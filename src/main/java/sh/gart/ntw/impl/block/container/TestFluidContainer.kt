package sh.gart.ntw.impl.block.container

import net.kyori.adventure.text.Component
import org.bukkit.Material
import sh.gart.ntw.impl.block.container.base.FluidContainer

class TestFluidContainer : FluidContainer(
    "fluid_container",
    Component.text("Fluid Container"),
    Material.BLUE_TERRACOTTA,
    64,
)
