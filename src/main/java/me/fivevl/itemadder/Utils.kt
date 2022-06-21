package me.fivevl.itemadder

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.entity.Player

object Utils {
    val inItemsGui = ArrayList<Player>()
    fun color(s: String): Component {
        return MiniMessage.miniMessage().deserialize(s)
    }
    fun loreBuilder(vararg arr: String): ArrayList<Component> {
        val lore = ArrayList<Component>()
        for (s in arr) {
            if (s.contains("\n")) {
                for (ss in s.split("\n")) {
                    lore.add(color(ss))
                }
            } else {
                lore.add(color(s))
            }
        }
        return lore
    }
}