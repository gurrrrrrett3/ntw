package sh.gart.ntw.commands

import org.bukkit.command.CommandSender

data class CommandAction(
    val name: String,
    val description: String,
    val action: (sender: CommandSender, args: Array<out String>?) -> String?,
)
