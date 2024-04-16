package sh.gart.ntw.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import sh.gart.ntw.Ntw

object NtwCommandTabComplete : TabCompleter {
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?,
    ): MutableList<String> {
        Ntw.getInstance().logger.info("Tab complete")
        return mutableListOf("help", "version")
    }
}
