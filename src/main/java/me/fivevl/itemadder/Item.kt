package me.fivevl.itemadder

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Item(uniqueName: String, name: Component, rarity: Rarity, material: Material, type: Type, vararg lore: String) {
    object Items {
        val items = HashMap<String, Item>()
    }

    lateinit var finalItem: ItemStack

    init {
        val item = ItemStack(material)
        val meta = item.itemMeta
        meta.displayName(name)
        meta.lore(Utils.loreBuilder())
        Items.items[uniqueName] = this
    }
}