package me.fivevl.itemadder.commands

import me.fivevl.itemadder.Items
import me.fivevl.itemadder.ItemsGui
import me.fivevl.itemadder.Utils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ItemsCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(Utils.color("<red>You must be a player to use this command!"))
            return true
        }
        val p = sender.player!!
        if (!p.hasPermission("itemadder.items")) {
            p.sendMessage(Utils.color("<red>You don't have permission to use this command!"))
            return true
        }
        if (Items.items.isEmpty()) {
            p.sendMessage(Utils.color("<red>There are no items!"))
            return true
        }
        p.openInventory(ItemsGui.getGui())
        Utils.inItemsGui.add(p)
        return true
    }
}