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
import snw.jkook.message.component.card.element.MarkdownElement
import snw.jkook.message.component.card.element.PlainTextElement
import snw.jkook.message.component.card.module.SectionModule
import snw.jkook.plugin.Plugin

/**
@author tRollaURa_
@since 2024/5/25
 */
class UserReloadConfigCommand(val plugin: Plugin) : UserCommandExecutor {
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
      plugin.reloadConfig()
   val card = CardBuilder()
    .setTheme(Theme.PRIMARY)
    .setSize(Size.LG)
    .addModule(SectionModule(MarkdownElement("**[PlugMan] 已经重载配置文件!**")))
    .build()

   p2!!.reply(card)
  }catch (e: Exception) {
   val card = CardBuilder()
    .setTheme(Theme.PRIMARY)
    .setSize(Size.LG)
    .addModule(SectionModule(MarkdownElement("**[PlugMan] 重载配置文件失败!**")))
    .build()
   p2!!.reply(card)
  }
 }
}
class ConsoleReloadConfigCommand(val plugin: Plugin) : ConsoleCommandExecutor {
 override fun onCommand(p0: ConsoleCommandSender?, p1: Array<out Any>?) {
  try {
   plugin.reloadConfig()
   输出("[PlugMan] 已经重载配置文件!", false, "PlugMan >> ")
  }catch (e: Exception) {
   输出("[PlugMan] 重载配置文件失败!", false, "PlugMan >> ")
  }
 }
}