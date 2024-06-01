package cn.trollaura.plugman.commands

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
import snw.jkook.message.component.card.module.HeaderModule
import snw.jkook.message.component.card.module.SectionModule
import snw.jkook.plugin.Plugin

/**
@author tRollaURa_
@since 2024/5/25
 */
class UserMainCommand(val plugin: Plugin) : UserCommandExecutor {
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

        val card = CardBuilder()
            .setTheme(Theme.PRIMARY)
            .setSize(Size.LG)
            .addModule(HeaderModule(PlainTextElement("Plugman For JKook by tRollaURa_", false)))
            .addModule(SectionModule(MarkdownElement("- `/plugman help` | 显示帮助列表 "), null, null))
            .addModule(SectionModule(MarkdownElement("- `/plugman list` | 显示插件列表"), null, null))
            .addModule(SectionModule(MarkdownElement("- `/plugman unload <插件名>` | 卸载插件"), null, null))
            .addModule(SectionModule(MarkdownElement("- `/plugman enable <插件名>` | 启用插件"), null, null))
            .addModule(SectionModule(MarkdownElement("- `/plugman disable <插件名>` | 禁用插件"), null, null))
            .addModule(SectionModule(MarkdownElement("- `/plugman reload` | 重载插件配置"), null, null))
            .addModule(SectionModule(MarkdownElement("- `/plugman info  <插件名>` | 查看插件内容"), null, null))
            .addModule(SectionModule(MarkdownElement("- `/plugman load  <插件文件名>` | 加载插件"), null, null))
            .addModule(SectionModule(MarkdownElement("- `/plugman reload  <插件名>` | 重载插件"), null, null))


            .build()

        p2!!.reply(card)
    }
}
class ConsoleMainCommand : ConsoleCommandExecutor {

    override fun onCommand(p0: ConsoleCommandSender?, p1: Array<out Any>?) {
        println(""" Plugman For JKook by tRollaURa_
            - /plugman help | 显示帮助列表 
            - /plugman list | 显示插件列表
            - /plugman unload <插件名> | 卸载插件
            - /plugman enable <插件名> | 启用插件
            - /plugman disable <插件名> | 禁用插件
            - /plugman reload | 重载插件配置
            - /plugman info <插件名> | 查看插件内容
            - /plugman load <插件文件名> | 加载插件
            
            
        """.trimIndent())
    }
}