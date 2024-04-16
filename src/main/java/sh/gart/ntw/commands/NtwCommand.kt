package sh.gart.ntw.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

object NtwCommand : Command("ntw") {
    override fun execute(
        sender: CommandSender,
        commandLabel: String,
        args: Array<out String>?,
    ): Boolean {
        if (args == null || args.isEmpty()) {
            return this.runAction("help", sender, null)
        }

        return this.runAction(args[0], sender, args.sliceArray(1 until args.size))
    }

    private fun runAction(
        name: String,
        sender: CommandSender,
        args: Array<out String>?,
    ): Boolean {
        val action = NtwCommandActions.actions[name] ?: return this.runAction("help", sender, null)
        val result = action.action(sender, args)

        if (result != null) {
            sender.sendMessage(result)
        }

        return true
    }
}
