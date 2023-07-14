package year22

import shared.Day
import shared.InputConverter.Companion.toLines

class Year22Day4 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = parseRangePairs(input).count { (firstRange, secondRange) ->
        firstRange in secondRange || secondRange in firstRange
    }

    override fun part2(input: List<String>): Int = parseRangePairs(input).count { (firstRange, secondRange) ->
        firstRange overlaps secondRange
    }

    private fun parseRangePairs(input: List<String>): List<Pair<IntRange, IntRange>> =
        input.flatMap { it.split(",", "-") }
            .map { it.toInt() }
            .chunked(4)
            .map { it[0]..it[1] to it[2]..it[3] }

    private operator fun IntRange.contains(other: IntRange): Boolean = this.intersect(other) == other.toSet()
    private infix fun IntRange.overlaps(other: IntRange): Boolean = this.intersect(other).isNotEmpty()
}
