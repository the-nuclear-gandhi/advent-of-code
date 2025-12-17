package year25

import core.Day
import core.InputConverter.Companion.toLines

class Year25Day7 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = calculateLightPaths(input).second

    override fun part2(input: List<String>): Long = calculateLightPaths(input).first.last().sum()

    private fun calculateLightPaths(input: List<String>): Pair<Array<LongArray>, Int> = parseInput(input).let {
        var activations = 0

        (1..it.lastIndex).forEach { i ->
            it[i].indices.filter { j -> it[i - 1][j] != 0L }
                .forEach { j ->
                    when (input[i][j]) {
                        '.' -> it[i][j] += it[i - 1][j]
                        '^' -> {
                            if (j > 0) {
                                it[i][j - 1] += it[i - 1][j]
                            }

                            if (j < it[i].size - 1) {
                                it[i][j + 1] += it[i - 1][j]
                            }

                            activations++
                        }
                    }
                }
        }

        it to activations
    }

    private fun parseInput(input: List<String>): Array<LongArray> =
        Array(input.size) { LongArray(input[0].length) { 0L } }.apply {
            this[0].indices.first { input[0][it] == 'S' }.let { this[0][it] = 1 }
        }
}
