package me.fivevl.itemadder

import me.fivevl.itemadder.commands.GetCommand
import me.fivevl.itemadder.commands.ItemsCommand
import me.fivevl.itemadder.types.AbilityType
import me.fivevl.itemadder.types.ItemType
import me.fivevl.itemadder.types.Rarity
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(InteractListener(), this)
        getCommand("items")?.setExecutor(ItemsCommand())
        getCommand("get")?.setExecutor(GetCommand())
        Item("TEST_ITEM", "Test Item", Rarity.EPIC, Material.STONE_SWORD, ItemType.WEAPON, "<red>The most basic testing</red>\n<blue>sword, by 5vl</blue>")
        val testAbility = Ability("Send Message", 3.0) {
            it.player.sendMessage(Utils.color("<red>You right clicked the TEST_ITEM!"))
        }
        Items.items["TEST_ITEM"]!!.addAbility(AbilityType.RIGHT_CLICK, "<light_purple>Sends you a nice message\n<light_purple>for using this item!", testAbility)
    }
}