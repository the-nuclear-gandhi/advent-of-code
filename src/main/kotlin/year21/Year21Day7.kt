package year21

import core.Day
import shared.toIntList
import kotlin.math.abs

class Year21Day7 : Day<String>(::prepareInput) {

    private companion object {
        private fun prepareInput(input: String): String = input.replace("\n", "")
    }

    override fun part1(input: String): Int = inputToSortedList(input).let {
        val size = it.size
        val median = if (size % 2 != 0) {
            it[size / 2]
        } else {
            (it[size / 2 - 1] + it[size / 2]) / 2
        }

        it.sumOf { n -> abs(n - median) }
    }

    override fun part2(input: String): Int = inputToSortedList(input).let {
        (0..it.maxOf { n -> n }).minOf { i ->
            it.sumOf { n -> abs(n - i) * (abs(n - i) + 1) / 2 }
        }
    }

    private fun inputToSortedList(input: String) = input.toIntList(",").sorted()
}
