package io.huvz.config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

object qqGroupConfig : AutoSavePluginConfig("GroupConfig") {
    /**
     * 对比群聊
     */
    @ValueDescription("目标群聊")
    val SourceGroupid :Long by value(512555506L);

}