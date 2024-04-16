package sh.gart.ntw.core.util

import org.bukkit.NamespacedKey
import sh.gart.ntw.Ntw

class Keys {
    companion object {
        val customItemType: NamespacedKey = NamespacedKey(Ntw.getInstance(), "custom_item_type")
    }
}
