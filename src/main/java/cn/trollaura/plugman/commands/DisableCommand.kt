package cn.trollaura.plugman.commands

/**
@author tRollaURa_
@since 2024/5/25
 */

import cn.trollaura.api.输出
import snw.jkook.command.ConsoleCommandExecutor
import snw.jkook.command.ConsoleCommandSender
import snw.jkook.command.UserCommandExecutor
import snw.jkook.entity.User
import snw.jkook.message.Message
import snw.jkook.message.component.card.CardBuilder
import snw.jkook.message.component.card.Size
import snw.jkook.message.component.card.Theme
import snw.jkook.message.component.card.element.PlainTextElement
import snw.jkook.message.component.card.module.SectionModule
import snw.jkook.plugin.Plugin

/**
@author tRollaURa_
@since 2024/5/25
 */
class UserDisableCommand(val plugin: Plugin) : UserCommandExecutor {
 override fun onCommand(p0: User?, p1: Array<out Any>?, p2: Message?) {
  if (!plugin.config.getStringList("Controller").contains(p0!!.id)) {
   val card = CardBuilder()
    .setTheme(Theme.WARNING)
    .setSize(Size.LG)
    .addModule(SectionModule(PlainTextElement("[PlugMan] 你没有权限!")))
    .build()
   p2?.reply(card)
   p2?.reply("😓")
   return
  }

  try {
   if (p1?.isEmpty()!!) {
    val card = CardBuilder()
     .setTheme(Theme.WARNING)
     .setSize(Size.LG)
     .addModule(SectionModule(PlainTextElement("[PlugMan] 你要看的插件呢?")))
     .build()
    p2?.reply(card)
    return
   }
   if (p1[0].toString() == plugin.description.name) {
    val card = CardBuilder()
     .setTheme(Theme.DANGER)
     .setSize(Size.LG)
     .addModule(SectionModule(PlainTextElement("[PlugMan] 不是你∫β 吧，你™要把我害死?")))
     .build()
    p2?.reply(card)
    return
   }
   if (p1[0].toString() == "TrLib") {
    val card = CardBuilder()
     .setTheme(Theme.DANGER)
     .setSize(Size.LG)
     .addModule(SectionModule(PlainTextElement("[PlugMan] 不是你∫β 吧，你™要害死我的依赖前置?")))
     .build()
    p2?.reply(card)
    return
   }
   plugin.core.pluginManager.disablePlugin(plugin.core.pluginManager.getPlugin(p1[0].toString())!!)
   val card = CardBuilder()
    .setTheme(Theme.SUCCESS)
    .setSize(Size.LG)
    .addModule(SectionModule(PlainTextElement("[PlugMan] 已经关闭${plugin.core.pluginManager.getPlugin(p1[0].toString())!!.description.name}!")))
    .build()
   p2?.reply(card)

  }catch (e: Exception) {
   val card = CardBuilder()
    .setTheme(Theme.WARNING)
    .setSize(Size.LG)
    .addModule(SectionModule(PlainTextElement("[PlugMan] 出现错误!")))
    .build()
   p2?.reply(card)
   e.printStackTrace()
  }
 }
}

class ConsoleDisableCommand(val plugin: Plugin) : ConsoleCommandExecutor {
 override fun onCommand(p0: ConsoleCommandSender?, p1: Array<out Any>?) {
  try {
   if (p1?.isEmpty()!!) {
    输出("[PlugMan] 你要看的插件呢?",false," PlugMan | ")
    return
   }
   plugin.core.pluginManager.disablePlugin(plugin.core.pluginManager.getPlugin(p1[0].toString())!!)
   输出("[PlugMan] 已经关闭${plugin.core.pluginManager.getPlugin(p1[0].toString())!!.description.name}!",false," PlugMan | ")
  }catch (e: Exception) {
   输出(   "[PlugMan] 出现错误!",false," PlugMan | ")
   e.printStackTrace()
  }
 }

}