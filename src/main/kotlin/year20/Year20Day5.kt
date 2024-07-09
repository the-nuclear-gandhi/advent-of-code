package year20

import core.Day
import core.InputConverter.Companion.toLines

class Year20Day5 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = input.maxOf { it.toSeatID() }

    override fun part2(input: List<String>): Int = input.map { it.toSeatID() }
        .sorted()
        .zipWithNext()
        .first { it.second - it.first > 1 }
        .let { it.first + 1 }

    private fun String.toSeatID(): Int {
        require(this.length == 10) { "Invalid input string length" }

        val seat = object {
            var row = 0..127
            var column = 0..7

            val id by lazy { row.first * 8 + column.first }
        }

        this.map {
            when (it) {
                'F' -> seat.row = seat.row.lowerHalf()
                'B' -> seat.row = seat.row.upperHalf()
                'L' -> seat.column = seat.column.lowerHalf()
                'R' -> seat.column = seat.column.upperHalf()
                else -> throw RuntimeException("Unexpected character: $it")
            }
        }

        return seat.id
    }

    private fun IntRange.lowerHalf(): IntRange = this.first..<this.first + this.count() / 2
    private fun IntRange.upperHalf(): IntRange = this.last - this.count() / 2 + 1..this.last
}
