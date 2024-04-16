package sh.gart.ntw.commands

import org.bukkit.entity.Player
import sh.gart.ntw.Ntw
import sh.gart.ntw.core.item.ItemManager

class NtwCommandActions {
    companion object {
        val actions: MutableMap<String, CommandAction> = mutableMapOf()

        private fun register(action: CommandAction) {
            Ntw.getInstance().logger.info("Registering action: ${action.name}")
            actions[action.name] = action
        }

        fun registerActions() {
            register(
                CommandAction("help", "Show help message.") { sender, _ ->
                    val actions = actions.values.joinToString("\n") { "§b${it.name}§r - ${it.description}" }
                    return@CommandAction "§bAvailable commands:\n$actions"
                },
            )
            register(
                CommandAction("version", "Show plugin version.") { _, _ ->
                    return@CommandAction "§bVersion: §r${Ntw.getInstance().description.version}"
                },
            )
            register(
                CommandAction("give", "Give yourself an ntw item.") { sender, args ->
                    if (args == null || args.isEmpty()) {
                        return@CommandAction "§cUsage: /ntw give <item>"
                    }

                    val itemName = args?.get(0) ?: return@CommandAction "§cUsage: /ntw give <item>"
                    val item = ItemManager.instance.getItemStack(itemName) ?: return@CommandAction "§cItem not found: $itemName"

                    (sender as? Player)?.inventory?.addItem(item)

                    return@CommandAction "§bGiven item: §r$itemName"
                },
            )
        }
    }
}
