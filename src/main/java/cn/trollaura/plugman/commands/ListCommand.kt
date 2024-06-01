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
import java.util.*
import java.util.stream.Collectors

/**
@author tRollaURa_
@since 2024/5/25
 */
class ConsoleListCommand(val plugin: Plugin) : ConsoleCommandExecutor {

 override fun onCommand(p0: ConsoleCommandSender?, p1: Array<out Any>?) {
  val plugins: Array<Plugin> = plugin.core.pluginManager.plugins
  val result = String.format("%s (%d): %s",
   "Plugins: ",
   plugins.size,
   java.lang.String.join(", ",
    Arrays.stream(plugins)
     .map { plugin: Plugin ->
      plugin.description.name
     }
     .collect(Collectors.toSet())
   )
  )
  输出(result, false, "Plugman | ")
 }
}
class UserListCommand(val plugin: Plugin) : UserCommandExecutor {

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
  val plugins: Array<Plugin> = plugin.core.pluginManager.plugins
  val result = String.format("%s (%d): %s",
   "Plugins: ",
   plugins.size,
   java.lang.String.join(", ",
    Arrays.stream(plugins)
     .map { plugin: Plugin ->
      "`${plugin.description.name}`"
     }
     .collect(Collectors.toSet())
   )
  )
  p2!!.reply("[PlugMan] $result")
 }
}