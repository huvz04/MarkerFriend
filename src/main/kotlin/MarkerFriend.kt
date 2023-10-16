package io.huvz

import io.huvz.util.groupAll
import io.huvz.util.groupCheck
import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info

object MarkerFriend : KotlinPlugin(
    JvmPluginDescription(
        id = "io.huvz.MarkerFriend",
        name = "MarkerFriend",
        version = "0.1.1",
    ) {
        author("huvz")
    }

) {
    override fun onEnable() {
        CommandManager.registerCommand(groupCheck)
        CommandManager.registerCommand(groupAll)
        logger.info { "Plugin loaded" }
    }
}