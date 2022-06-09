package me.fivevl.itemadder

import net.kyori.adventure.text.Component

enum class Rarity(val formatted: Component) {
    COMMON(Utils.color("<white><bold>COMMON")),
    UNCOMMON(Utils.color("<lime><bold>UNCOMMON")),
    RARE(Utils.color("<blue><bold>RARE")),
    EPIC(Utils.color("<purple><bold>EPIC")),
    LEGENDARY(Utils.color("<gold><bold>LEGENDARY")),
    MYTHIC(Utils.color("<pink><bold>MYTHIC")),
    SPECIAL(Utils.color("<red><bold>SPECIAL"))
}