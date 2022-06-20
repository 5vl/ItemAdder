package me.fivevl.itemadder

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.player.PlayerInteractEvent

class InteractListener : Listener {
    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        if (e.item == null) return
        for (check in Utils.items.values) {
            if (check.finalItem == e.item) {
                for (ability in check.abilities.keys) {
                    if (check.abilities[ability]!! == AbilityType.RIGHT_CLICK && (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK)) {
                        ability.run()
                    }
                    if (check.abilities[ability]!! == AbilityType.LEFT_CLICK && (e.action == Action.LEFT_CLICK_AIR || e.action == Action.LEFT_CLICK_BLOCK)) {
                        ability.run()
                    }
                }
            }
        }
    }

    @EventHandler
    fun onInvClick(e: InventoryClickEvent) {
        if (e.whoClicked !is Player) return
        if (!Utils.inItemsGui.contains(e.whoClicked as Player)) return
        e.isCancelled = true
        if (e.currentItem == null) return
        e.whoClicked.inventory.addItem(e.currentItem!!)
        e.whoClicked.sendMessage(Utils.color("<green>Added <blue>${e.currentItem!!.itemMeta.displayName()} <green>to your inventory"))
    }

    @EventHandler
    fun onInvClose(e: InventoryCloseEvent) {
        Utils.inItemsGui.remove(e.player)
    }
}