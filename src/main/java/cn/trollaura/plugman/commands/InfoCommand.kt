package cn.trollaura.plugman.commands

import snw.jkook.command.UserCommandExecutor
import snw.jkook.entity.User
import snw.jkook.message.Message
import snw.jkook.message.component.card.CardBuilder
import snw.jkook.message.component.card.Size
import snw.jkook.message.component.card.Theme
import snw.jkook.message.component.card.element.MarkdownElement
import snw.jkook.message.component.card.element.PlainTextElement
import snw.jkook.message.component.card.module.HeaderModule
import snw.jkook.message.component.card.module.SectionModule
import snw.jkook.plugin.Plugin

/**
@author tRollaURa_
@since 2024/5/25
 */
class UserInfoCommand(val plugin: Plugin) : UserCommandExecutor {
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
   val card = CardBuilder()
    .setTheme(Theme.INFO)
    .setSize(Size.LG)
    .addModule(HeaderModule("[PlugMan] Plugin Information: ${p1?.get(0)}"))
    .addModule(SectionModule(MarkdownElement("**- Version: ** `${plugin.core.pluginManager.getPlugin(p1?.get(0).toString())?.description?.version}`")))
    .addModule(SectionModule(MarkdownElement("**- Author: **`查无此人`")))
    .addModule(SectionModule(MarkdownElement("**- JKook-API: **`${plugin.core.pluginManager.getPlugin(p1?.get(0).toString())?.description?.apiVersion}`")))

    .addModule(SectionModule(MarkdownElement("**- Status: ** `${plugin.core.pluginManager.getPlugin(p1?.get(0).toString())?.isEnabled.toString()}`")))
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