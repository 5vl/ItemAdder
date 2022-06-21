package me.fivevl.itemadder.types

enum class Rarity(val formatted: String) {
    COMMON("<white><bold>COMMON"),
    UNCOMMON("<lime><bold>UNCOMMON"),
    RARE("<blue><bold>RARE"),
    EPIC("<purple><bold>EPIC"),
    LEGENDARY("<gold><bold>LEGENDARY"),
    MYTHIC("<pink><bold>MYTHIC"),
    SPECIAL("<red><bold>SPECIAL")
}