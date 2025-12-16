package year25

import core.Day
import core.InputConverter.Companion.toLines

class Year25Day7 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = parseInput(input).let {
        var activeSplitters = 0

        (1..it.lastIndex).forEach { i ->
            it[i].indices.filter { j -> it[i - 1][j] != 0L }.forEach { j ->
                when (input[i][j]) {
                    '.' -> it[i][j] = it[i - 1][j]
                    '^' -> {
                        if (j > 0) {
                            it[i][j - 1] = it[i - 1][j]
                        }

                        if (j < it[i].size - 1) {
                            it[i][j + 1] = it[i - 1][j]
                        }

                        activeSplitters++
                    }
                }
            }
        }

        return activeSplitters
    }

    override fun part2(input: List<String>): Long = parseInput(input).apply {
        (1..this.lastIndex).forEach { i ->
            this[i].indices.filter { this[i - 1][it] != 0L }
                .forEach { j ->
                    when (input[i][j]) {
                        '.' -> this[i][j] += this[i - 1][j]
                        '^' -> {
                            if (j > 0) {
                                this[i][j - 1] += this[i - 1][j]
                            }

                            if (j < this[i].size - 1) {
                                this[i][j + 1] += this[i - 1][j]
                            }
                        }
                    }
                }
        }
    }.last().sum()

    private fun parseInput(input: List<String>): Array<LongArray> =
        Array(input.size) { LongArray(input[0].length) { 0L } }.apply {
            this[0].indices.first { input[0][it] == 'S' }.let { this[0][it] = 1 }
        }
}
