package year25

import core.Day
import core.InputConverter.Companion.toLineBlocks
import shared.LineBlock
import shared.toLongList

class Year25Day5 : Day<List<LineBlock>>(::toLineBlocks) {

    override fun part1(input: List<LineBlock>): Int = input[0].map { it.toLongRange() }
        .run {
            input[1].filter { it.isNotBlank() }
                .map(String::toLong)
                .count { n -> this.any { n in it } }
        }

    override fun part2(input: List<LineBlock>): Long = input[0].map { it.toLongRange() }
        .run {
            val ranges = mutableSetOf<LongRange>()

            for (range in this) {
                ranges.removeAll { it in range }

                if (ranges.none { range.first in it || range.last in it }) {
                    ranges += range
                } else if (ranges.none { range in it }) {
                    val newStart = ranges.filter { range.first in it }.maxOfOrNull { it.last }?.inc() ?: range.first
                    val newEnd = ranges.filter { range.last in it }.minOfOrNull { it.first }?.dec() ?: range.last

                    ranges += LongRange(newStart, newEnd)
                }
            }

            ranges.sumOf { it.last - it.first + 1 }
        }

    private fun String.toLongRange(): LongRange = this.toLongList("-").let { LongRange(it.first(), it.last()) }
    private operator fun LongRange.contains(other: LongRange): Boolean =
        this.first <= other.first && this.last >= other.last
}
