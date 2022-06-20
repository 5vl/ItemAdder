package me.fivevl.itemadder

import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory

object ItemsGui {
    fun getGui(): Inventory {
        val gui = Bukkit.createInventory(null, 54, Utils.color("Items"))
        for (item in Utils.items.values) {
            gui.addItem(item.finalItem)
        }
        return gui
    }
}