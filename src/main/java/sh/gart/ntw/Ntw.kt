package sh.gart.ntw

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import sh.gart.ntw.commands.NtwCommand
import sh.gart.ntw.commands.NtwCommandActions
import sh.gart.ntw.core.block.BlockManager
import sh.gart.ntw.core.events.CustomItemEvents

class Ntw : JavaPlugin() {
    companion object {
        private var instance: Ntw? = null

        fun getInstance(): Ntw {
            return instance!!
        }
    }

    override fun onEnable() {
        // Plugin startup logic
        instance = this

        server.commandMap.register("ntw", NtwCommand)
        NtwCommandActions.registerActions()

        Loader.load()

        Bukkit.getPluginManager().registerEvents(CustomItemEvents, this)
        Bukkit.getPluginManager().registerEvents(BlockManager.instance, this)

        this.logger.info("Enabled!")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
