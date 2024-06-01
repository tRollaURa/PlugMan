package cn.trollaura.plugman.commands

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
import java.io.File

/**
@author tRollaURa_
@since 2024/6/1
 */
class UserReloadCommand(val plugin: Plugin) : UserCommandExecutor {
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

val plgname = plugin.core.pluginManager.getPlugin(p1[0].toString())!!.file.name
   plugin.core.pluginManager.removePlugin(plugin.core.pluginManager.getPlugin(p1[0].toString())!!)
   val card = CardBuilder()
    .setTheme(Theme.SUCCESS)
    .setSize(Size.LG)
    .addModule(SectionModule(PlainTextElement("[PlugMan] 已经重载${plugin.core.pluginManager.loadPlugin(File("${plugin.file.parentFile}\\${plgname}")).description.name}!")))
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
class ConsoleReloadCommand(val plugin: Plugin) : ConsoleCommandExecutor {
 override fun onCommand(p0: ConsoleCommandSender?, p1: Array<out Any>?) {
   try {
    if (p1?.isEmpty()!!) {
     输出("[PlugMan] 你要看的插件呢?",false," PlugMan >> ")
     return
    }

    val plgname = plugin.core.pluginManager.getPlugin(p1[0].toString())!!.file.name
    plugin.core.pluginManager.removePlugin(plugin.core.pluginManager.getPlugin(p1[0].toString())!!)
    输出("[PlugMan] 已经重载${plugin.core.pluginManager.loadPlugin(File("${plugin.file.parentFile}\\${plgname}")).description.name}!",false," PlugMan >> ")
   }catch (e: Exception) {
    输出(   "[PlugMan] 出现错误!",false," PlugMan >> ")
    e.printStackTrace()
   }


 }


}