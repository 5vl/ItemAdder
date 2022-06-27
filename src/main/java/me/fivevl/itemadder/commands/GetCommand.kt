package me.fivevl.itemadder.commands

import me.fivevl.itemadder.Items
import me.fivevl.itemadder.Utils
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GetCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(Utils.color("<red>You must be a player to use this command!"))
            return true
        }
        val p = sender.player!!
        if (!p.hasPermission("itemadder.get")) {
            p.sendMessage(Utils.color("<red>You don't have permission to use this command!"))
            return true
        }
        val item = Items.items[args[0]]
        if (item == null) {
            p.sendMessage(Utils.color("<red>Item not found! Please use the unique name."))
            return true
        }
        when (args.size) {
            1 -> {
                p.inventory.addItem(item.finalItem)
                p.sendMessage(Utils.color("<green>You have been given the item ${item.uniqueName}!"))
            }
            2 -> {
                val target = Bukkit.getPlayer(args[1])
                if (target == null) {
                    p.sendMessage(Utils.color("<red>Player not found!"))
                    return true
                }
                target.inventory.addItem(item.finalItem)
                p.sendMessage(Utils.color("<green>You have given ${target.name} the item ${item.uniqueName}"))
                target.sendMessage(Utils.color("<green>You have been given the item ${item.uniqueName}"))
            }
            else -> {
                p.sendMessage(Utils.color("<red>Usage: /get <item> [player]"))
            }
        }
        return true
    }
}