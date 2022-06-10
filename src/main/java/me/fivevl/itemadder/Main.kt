package me.fivevl.itemadder

import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        Item("TEST_ITEM", Utils.color("<blue>Test Item"), Rarity.EPIC, Material.STONE_SWORD, Type.SWORD, Utils.loreBuilder("<blue>Test Lore"))
    }
}