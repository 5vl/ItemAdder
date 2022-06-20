package me.fivevl.itemadder

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(InteractListener(), this)
        getCommand("items")?.setExecutor(ItemsCommand())
        Item("TEST_ITEM", Utils.color("<blue>Test Item"), Rarity.EPIC, Material.STONE_SWORD, Type.WEAPON, "<red>The most basic testing</red>\n<blue>sword, by 5vl</blue>")
        Utils.items["TEST_ITEM"]!!.addAbility(AbilityType.RIGHT_CLICK) {
            val e = AbilityType.RIGHT_CLICK.event
            e.player.sendMessage(Utils.color("<red>You right clicked the TEST_ITEM!"))
        }
    }
}