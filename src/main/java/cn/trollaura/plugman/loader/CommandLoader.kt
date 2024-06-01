package cn.trollaura.plugman.loader


import cn.trollaura.api.输出
import cn.trollaura.plugman.commands.*
import snw.jkook.command.ConsoleCommandExecutor
import snw.jkook.command.ConsoleCommandSender
import snw.jkook.command.JKookCommand
import snw.jkook.message.component.card.CardBuilder
import snw.jkook.message.component.card.Size
import snw.jkook.message.component.card.Theme
import snw.jkook.message.component.card.element.MarkdownElement
import snw.jkook.message.component.card.element.PlainTextElement
import snw.jkook.message.component.card.module.HeaderModule
import snw.jkook.message.component.card.module.SectionModule
import snw.jkook.plugin.Plugin
import java.util.*
import java.util.stream.Collectors


/**
@author tRollaURa_
@since 2024/5/19
 */
class CommandLoader(plugin: Plugin) {
 init {

  JKookCommand("plugman","/")
   .executesUser(UserMainCommand(plugin))
   .executesConsole(ConsoleMainCommand())
   .addSubcommand(JKookCommand("reloadConfig")
    .executesUser(UserReloadConfigCommand(plugin))
    .executesConsole(ConsoleReloadConfigCommand(plugin)))

   .addSubcommand(JKookCommand("list")
    .executesUser(UserListCommand(plugin))
    .executesConsole(ConsoleListCommand(plugin)))
   .addSubcommand(JKookCommand("help")
    .executesUser(UserMainCommand(plugin))
    .executesConsole(ConsoleMainCommand()))
   .addSubcommand(JKookCommand("info")
    .executesUser(UserInfoCommand(plugin)))
   .addSubcommand(JKookCommand("enable")
    .executesUser(UserEnableCommand(plugin))
    .executesConsole(ConsoleEnableCommand(plugin)))
   .addSubcommand(JKookCommand("disable")
    .executesUser(UserDisableCommand(plugin))
    .executesConsole(ConsoleDisableCommand(plugin)))
   .addSubcommand(JKookCommand("unload")
    .executesUser(UserUnloadCommand(plugin))
    .executesConsole(ConsoleUnloadCommand(plugin)))
   .addSubcommand(JKookCommand("load")
    .executesUser(UserLoadCommand(plugin))
    .executesConsole(ConsoleLoadCommand(plugin)))
   .addSubcommand(JKookCommand("reload")
    .executesUser(UserReloadCommand(plugin))
    .executesConsole(ConsoleReloadCommand(plugin)))
   .register(plugin)







 }
}