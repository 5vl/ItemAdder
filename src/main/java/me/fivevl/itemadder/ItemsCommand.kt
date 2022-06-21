package me.fivevl.itemadder

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ItemsCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender !is Player) {
            sender.sendMessage(Utils.color("<red>Only players can use this command"))
            return true
        }
        val p = sender.player!!
        if (p.hasPermission("itemadder.items")) {
            p.openInventory(ItemsGui.getGui())
            Utils.inItemsGui.add(p)
        } else {
            p.sendMessage(Utils.color("<red>You don't have permission to use this command"))
        }
        return true
    }
}