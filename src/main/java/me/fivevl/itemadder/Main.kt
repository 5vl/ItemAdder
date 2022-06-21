package me.fivevl.itemadder

import me.fivevl.itemadder.types.AbilityType
import me.fivevl.itemadder.types.ItemType
import me.fivevl.itemadder.types.Rarity
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(InteractListener(), this)
        getCommand("items")?.setExecutor(ItemsCommand())
        Item("TEST_ITEM", Utils.color("<blue>Test Item"), Rarity.EPIC, Material.STONE_SWORD, ItemType.WEAPON, "<red>The most basic testing</red>\n<blue>sword, by 5vl</blue>")
        Items.items["TEST_ITEM"]!!.addAbility(AbilityType.RIGHT_CLICK) { e: PlayerInteractEvent ->
            e.player.sendMessage(Utils.color("<red>You right clicked the TEST_ITEM!"))
        }
    }
}