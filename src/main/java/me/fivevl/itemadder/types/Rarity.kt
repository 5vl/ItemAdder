package me.fivevl.itemadder.types

enum class Rarity(val formatted: String, val color: String) {
    COMMON("<white><bold>COMMON", "<white>"),
    UNCOMMON("<lime><bold>UNCOMMON", "<lime>"),
    RARE("<blue><bold>RARE", "<blue>"),
    EPIC("<dark_purple><bold>EPIC", "<dark_purple>"),
    LEGENDARY("<gold><bold>LEGENDARY", "<gold>"),
    MYTHIC("<pink><bold>MYTHIC", "<pink>"),
    SPECIAL("<red><bold>SPECIAL", "<red>"),
}