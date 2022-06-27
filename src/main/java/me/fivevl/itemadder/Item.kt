package me.fivevl.itemadder

import me.fivevl.itemadder.types.AbilityType
import me.fivevl.itemadder.types.ItemType
import me.fivevl.itemadder.types.Rarity
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import java.util.*
import kotlin.collections.HashMap

class Item(val uniqueName: String, name: String, private val rarity: Rarity, material: Material, private val type: ItemType, private var lore: String) {
    val finalItem: ItemStack
    val abilities = HashMap<Ability, AbilityType>()

    init {
        val item = ItemStack(material)
        val meta = item.itemMeta
        meta.displayName(Utils.color("<!i>${rarity.color}$name"))
        meta.lore(Utils.loreBuilder(lore, "", rarity.formatted + " " + type.type))
        item.itemMeta = meta
        finalItem = item
        Items.items[uniqueName] = this
    }

    fun addAbility(abilityType: AbilityType, addLore: String, ability: Ability) {
        abilities[ability] = abilityType
        val clickType = if (abilityType == AbilityType.LEFT_CLICK) "Left click" else if (abilityType == AbilityType.RIGHT_CLICK) "Right click" else "Other type"
        val meta = finalItem.itemMeta
        val sj = StringJoiner("\n")
        sj.add(lore)
        sj.add(" ")
        sj.add("<yellow><bold>$clickType: <gold>${ability.name}")
        sj.add(addLore)
        sj.add(" ")
        sj.add(rarity.formatted + " " + type.type)
        val newLore = Utils.loreBuilder(sj.toString())
        lore = sj.toString()
        meta.lore(newLore)
        finalItem.itemMeta = meta
    }
}