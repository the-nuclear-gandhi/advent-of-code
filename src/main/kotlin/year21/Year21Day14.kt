package year21

import shared.Day
import kotlin.streams.toList

class Year21Day14 : Day<List<String>>() {
    override fun getInput(): List<String> = inputResource().asLines()

    override fun part1(input: List<String>): Long = calculatePolymer(input, 10)

    override fun part2(input: List<String>): Long = calculatePolymer(input, 40)

    private fun calculatePolymer(input: List<String>, times: Int): Long {
        val template = input[0]
        val mappings = input.subList(1, input.size)
            .map { it.split("->").map { token -> token.trim() } }
            .associate { (key, insert) -> key to listOf("${key[0]}${insert}", "${insert}${key[1]}") }

        var counts = template.windowed(2)
            .groupBy { it }
            .map { (key, occurrences) -> key to occurrences.size.toLong() }
            .toMap()

        repeat(times) {
            counts = mappings.flatMap { (key, value) -> listOf(key to value.first(), key to value.last()) }
                .map { (key, product) -> product to (counts[key] ?: 0L) }
                .groupBy { it.first }
                .map { (product, groups) -> product to groups.sumOf { (_, count) -> count } }
                .toMap()
        }

        val letterCounts = counts.keys.flatMap { it.chars().toList() }
            .map { it.toChar() }
            .distinct()
            .associateWith { counts.filterKeys { key -> key.startsWith(it) }.values.sum() }
            .toMutableMap()
            .apply {
                this.computeIfPresent(template.last()) { _, v -> v + 1 }
            }

        return letterCounts.maxOf { it.value } - letterCounts.minOf { it.value }
    }
}
