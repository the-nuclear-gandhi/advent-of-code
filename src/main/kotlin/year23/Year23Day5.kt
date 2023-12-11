package year23

import core.Day
import core.InputConverter.Companion.toLineBlocks
import shared.LineBlock
import shared.toLongList

class Year23Day5 : Day<List<LineBlock>>(::toLineBlocks) {
    override fun part1(input: List<LineBlock>): Long = with(inputToAlmanac(input)) {
        this.seeds.minOf { findLastMapping(it, mappings) }
    }

    override fun part2(input: List<LineBlock>): Long = with(inputToAlmanac(input)) {
        this.seeds.chunked(2)
            .map { it.first()..<it.first() + it.last() }
            .minOf {
                it.fold(Long.MAX_VALUE) { acc, i ->
                    findLastMapping(i, mappings).takeIf { value -> value < acc } ?: acc
                }
            }
    }

    private fun inputToAlmanac(input: List<LineBlock>): Almanac {
        val seeds = input[0][0].substringAfter(":")
            .trim()
            .toLongList(" ")

        val mappings = input.drop(1)
            .map { mapping ->
                mapping.drop(1)
                    .filter { it.isNotEmpty() }
                    .map { it.toLongList(" ") }
                    .associate { it[1]..<it[1] + it[2] to it[0]..<it[0] + it[2] }
            }

        return Almanac(seeds, mappings)
    }

    private fun findLastMapping(number: Long, mappings: List<Map<LongRange, LongRange>>): Long =
        mappings.fold(number) { acc, mapping ->
            mapping.keys.firstOrNull { k -> acc in k }
                ?.let { key -> mapping[key]?.let { range -> range.first + acc - key.first } } ?: acc
        }

    private data class Almanac(
        val seeds: List<Long>,
        val mappings: List<Map<LongRange, LongRange>>
    )
}
