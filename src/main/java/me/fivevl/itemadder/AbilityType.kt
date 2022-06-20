package me.fivevl.itemadder

import org.bukkit.event.player.PlayerInteractEvent

enum class AbilityType(val event: PlayerInteractEvent) {
    LEFT_CLICK(Utils.interactEvent),
    RIGHT_CLICK(Utils.interactEvent)
}