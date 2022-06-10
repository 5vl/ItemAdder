package me.fivevl.itemadder

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage

object Utils {
    fun color(s: String): Component {
        return MiniMessage.miniMessage().deserialize(s)
    }
    fun loreBuilder(vararg arr: String): ArrayList<Component> {
        val lore = ArrayList<Component>()
        for (s in arr) {
            lore.add(color(s))
        }
        return lore
    }
}