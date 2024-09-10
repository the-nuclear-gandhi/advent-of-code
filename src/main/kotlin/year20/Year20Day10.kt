package year20

import core.Day
import core.InputConverter.Companion.toInts

class Year20Day10 : Day<List<Int>>(::toInts) {

    override fun part1(input: List<Int>): Int = input.toMutableList()
        .apply {
            this += 0
            this += this.max() + 3
        }
        .sorted()
        .windowed(2)
        .map { it[1] - it[0] }
        .let { list -> list.count { it == 1 } * list.count { it == 3 } }

    override fun part2(input: List<Int>): Long {
        val max = input.max()
        val counts = Array(max + 4) { 0L }
        counts[0] = 1

        input.toMutableList().apply { this += max + 3 }
            .sorted()
            .forEach { n ->
                counts[n] = counts.indices.filter { n - it <= 3 }.sumOf { counts[it] }
            }

        return counts.last()
    }
}
