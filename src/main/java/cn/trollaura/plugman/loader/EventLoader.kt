package cn.trollaura.plugman.loader

import snw.jkook.JKook.getCore
import snw.jkook.event.Listener
import snw.jkook.plugin.Plugin

/**
@author tRollaURa_
@since 2024/5/19
 */
class EventLoader(val plugin: Plugin) {
    val listeners = mutableListOf<Listener>()

    fun load() {
    }

    fun init() {
        load()
        listeners.forEach {
            getCore().eventManager.registerHandlers(plugin, it)
        }
    }
}