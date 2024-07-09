package year20

import core.Day
import core.InputConverter.Companion.toLineBlocks
import shared.LineBlock

class Year20Day6 : Day<List<LineBlock>>(::toLineBlocks) {

    override fun part1(input: List<LineBlock>): Int = input.sumOf { group ->
        group.flatMap { it.toList() }.toSet().size
    }

    override fun part2(input: List<LineBlock>): Int = input.sumOf { group ->
        group.flatMap { it.toList() }.toSet()
            .count { group.filter { it.isNotBlank() }.all { s -> it in s } }
    }
}
