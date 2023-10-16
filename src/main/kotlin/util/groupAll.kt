package io.huvz.util

import io.huvz.MarkerFriend
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.contact.ContactList
import net.mamoe.mirai.contact.NormalMember
import net.mamoe.mirai.contact.isOperator
import net.mamoe.mirai.contact.nameCardOrNick

object groupAll : SimpleCommand(MarkerFriend,"隔壁群友列表",description = "查询机器人所在的另一个群的相同人数") {
    @Handler
    suspend fun handle(sender: CommandSender, groupid:String)
    {

        val g2 = sender.subject?.id?.let { sender.bot?.getGroup(it) }
        var MemberListStr:StringBuilder  = StringBuilder()
        var groupid_CHECK: Long? = sender.subject?.id
        //MarkerFriend.logger.info("你群id：${g2?.id}")
        try{
            groupid_CHECK = groupid.toLong()
        }catch (e:Exception){
            sender.subject?.sendMessage("群号转化错误：请输入正确的群号")
            return
        }
        val g1 = groupid_CHECK.let { sender.bot?.getGroup(it) };
        //MarkerFriend.logger.info("目标群id${g1?.id}")
        if(g1?.id==null){
            sender.subject?.sendMessage("获取目标群失败喵")
            return
        }
        var list1 : ContactList<NormalMember>? = g2?.members;
        //MarkerFriend.logger.info("本群群友列表${list1.toString()}")
        var countSum  = 0
        if (list1 != null) {


            for(me in list1 ){
                //MarkerFriend.logger.info("正在查询群友${me in list1}")
                if(g1?.contains(me.id) == true && !me.isOperator() && (me.specialTitle.isEmpty()))
                {
                    countSum ++;
                    MemberListStr.append("QQ:${me.id}||名称:${me.nameCardOrNick}\n")
                }
            }
        }


        sender.subject?.sendMessage(
            "一共查获你群有${countSum}人在目标群聊中\n" +
                    "名单公示（已过滤管理员和有特殊头衔的群友）\n"+
                    MemberListStr
        )
    }


}