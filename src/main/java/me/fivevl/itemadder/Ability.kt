package me.fivevl.itemadder

import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerInteractEvent

class Ability(val name: String, private val cooldown: Double?, private val runnable: (PlayerInteractEvent) -> Unit) {
    private val cooldowns = HashMap<Player, Long>()

    fun run(e: PlayerInteractEvent): Double? {
        if (cooldown != null) {
            val player = e.player
            val now = System.currentTimeMillis()
            val last = cooldowns[player] ?: 0L
            if (now - last < cooldown * 1000) return ((now - last) / 1000).toDouble()
            cooldowns[player] = now
        }
        runnable.invoke(e)
        return null
    }
}