package me.fivevl.itemadder

import me.fivevl.itemadder.types.AbilityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.player.PlayerInteractEvent
import kotlin.math.roundToInt

class InteractListener : Listener {
    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        if (e.item == null) return
        for (check in Items.items.values) {
            if (check.finalItem.isSimilar(e.item)) {
                for (ability in check.abilities.keys) {
                    if ((check.abilities[ability]!! == AbilityType.RIGHT_CLICK && (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK)) || (check.abilities[ability]!! == AbilityType.LEFT_CLICK && (e.action == Action.LEFT_CLICK_AIR || e.action == Action.LEFT_CLICK_BLOCK))) {
                        val cooldownSeconds = ability.run(e)
                        if (cooldownSeconds != null) {
                            // This counts up i cba to change rn
                            e.player.sendMessage(Utils.color("<red>This ability is on cooldown for ${(cooldownSeconds * 10.0).roundToInt() / 10.0} seconds."))
                        }
                    }
                }
            }
        }
    }

    @Suppress("deprecation")
    @EventHandler
    fun onInvClick(e: InventoryClickEvent) {
        if (e.whoClicked !is Player) return
        if (!Utils.inItemsGui.contains(e.whoClicked as Player)) return
        e.isCancelled = true
        if (e.currentItem == null) return
        e.whoClicked.inventory.addItem(e.currentItem!!)
    }

    @EventHandler
    fun onInvClose(e: InventoryCloseEvent) {
        Utils.inItemsGui.remove(e.player)
    }
}