package me.fivevl.itemadder

import me.fivevl.itemadder.types.AbilityType
import me.fivevl.itemadder.types.ItemType
import me.fivevl.itemadder.types.Rarity
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

class Item(uniqueName: String, name: Component, rarity: Rarity, material: Material, type: ItemType, lore: String) {
    val finalItem: ItemStack
    val abilities = HashMap<(PlayerInteractEvent) -> Unit, AbilityType>()

    init {
        val item = ItemStack(material)
        val meta = item.itemMeta
        meta.displayName(name)
        meta.lore(Utils.loreBuilder(lore, "", rarity.formatted + " " + type.type))
        item.itemMeta = meta
        finalItem = item
        Items.items[uniqueName] = this
    }

    fun addAbility(type: AbilityType, runnable: (PlayerInteractEvent) -> Unit) {
        abilities[runnable] = type
    }
}