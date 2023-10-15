package io.huvz

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info

object MarkerFriend : KotlinPlugin(
    JvmPluginDescription(
        id = "io.huvz.MarkerFriend",
        name = "MarkerFriend",
        version = "0.1.0",
    ) {
        author("huvz")
    }
) {
    override fun onEnable() {
        logger.info { "Plugin loaded" }
    }
}