package me.fivevl.itemadder

import me.fivevl.itemadder.types.AbilityType
import me.fivevl.itemadder.types.ItemType
import me.fivevl.itemadder.types.Rarity
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import java.util.*
import kotlin.collections.HashMap

class Item(uniqueName: String, name: String, private val rarity: Rarity, material: Material, private val type: ItemType, private val lore: String) {
    val finalItem: ItemStack
    val abilities = HashMap<(PlayerInteractEvent) -> Unit, AbilityType>()

    init {
        val item = ItemStack(material)
        val meta = item.itemMeta
        meta.displayName(Utils.color("<!i>${rarity.color}$name"))
        meta.lore(Utils.loreBuilder(lore, "", rarity.formatted + " " + type.type))
        item.itemMeta = meta
        finalItem = item
        Items.items[uniqueName] = this
    }

    fun addAbility(abilityType: AbilityType, name: String, addLore: String, runnable: (PlayerInteractEvent) -> Unit) {
        abilities[runnable] = abilityType
        val clickType = if (abilityType == AbilityType.LEFT_CLICK) "Left click" else if (abilityType == AbilityType.RIGHT_CLICK) "Right click" else "Other type"
        val meta = finalItem.itemMeta
        val newLore = meta.lore()!!
        val lastLine = newLore.last()!!
        newLore.remove(lastLine)
        val sj = StringJoiner("\n")
        for (line in newLore) {
            sj.add(line.toString())
        }
        meta.lore(Utils.loreBuilder(sj.toString(), "<yellow><bold>$clickType: <gold>$name", addLore, " ", rarity.formatted + " " + type.type))
        finalItem.itemMeta = meta
    }
}