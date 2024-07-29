package year15

import core.Day
import core.InputConverter.Companion.toLines

class Year15Day16 : Day<List<String>>(::toLines) {

    private val targetAuntSue = mapOf(
        "children" to 3,
        "cats" to 7,
        "samoyeds" to 2,
        "pomeranians" to 3,
        "akitas" to 0,
        "vizslas" to 0,
        "goldfish" to 5,
        "trees" to 3,
        "cars" to 2,
        "perfumes" to 1,
    )

    override fun part1(input: List<String>): Int = findAuntSue(input) { key, map ->
        map[key]?.let { it == targetAuntSue[key] } ?: true
    }

    override fun part2(input: List<String>): Int = findAuntSue(input) { key, map ->
        map[key]?.let {
            when (key) {
                "cats", "trees" -> it > targetAuntSue.getValue(key)
                "pomeranians", "goldfish" -> it < targetAuntSue.getValue(key)
                else -> it == targetAuntSue[key]
            }
        } ?: true
    }

    private fun findAuntSue(input: List<String>, mappingFunction: (String, Map<String, Int>) -> Boolean) =
        inputToAuntSueList(input).filterValues {
            targetAuntSue.keys.map { key -> mappingFunction(key, it) }.reduce { acc, b -> acc && b }
        }
            .keys.first()

    private fun inputToAuntSueList(input: List<String>) = input.associate {
        val id = it.substringAfter(" ").substringBefore(":").toInt()
        val auntSue = it.substringAfter(":").trim()
            .split(",")
            .associate { token -> token.split(":").let { (key, value) -> key.trim() to value.trim().toInt() } }
        id to auntSue
    }
}
