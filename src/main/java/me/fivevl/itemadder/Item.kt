package me.fivevl.itemadder

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Item(uniqueName: String, name: Component, rarity: Rarity, material: Material, type: Type, lore: String) {
    val finalItem: ItemStack
    val abilities = HashMap<Runnable, AbilityType>()

    init {
        val item = ItemStack(material)
        val meta = item.itemMeta
        meta.displayName(name)
        meta.lore(Utils.loreBuilder(lore, "", rarity.formatted + " " + type.type))
        item.itemMeta = meta
        finalItem = item
        Utils.items[uniqueName] = this
    }

    fun addAbility(type: AbilityType, runnable: Runnable) {
        abilities[runnable] = type
    }
}