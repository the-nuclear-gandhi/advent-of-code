package year15

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point

class Year15Day6 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int =
        calculate(input, Array(1000) { Array(1000) { false } }, ::transformPart1)
            .flatten()
            .count { it }

    override fun part2(input: List<String>): Long =
        calculate(input, Array(1000) { Array(1000) { 0L } }, ::transformPart2)
            .flatten()
            .sumOf { it }

    private fun <T> calculate(input: List<String>, map: Array<Array<T>>, transform: (String, T) -> T): Array<Array<T>> =
        map.apply {
            input.forEach {
                val tokens = it.split(" ")

                val start = Point.fromString(tokens[tokens.size - 3])
                val end = Point.fromString(tokens.last())

                for (x in start.x..end.x) {
                    for (y in start.y..end.y) {
                        this[x][y] = transform(it, this[x][y])
                    }
                }
            }
        }

    private fun transformPart1(command: String, item: Boolean): Boolean = when {
        command.startsWith("toggle") -> !item
        command.startsWith("turn on") -> true
        command.startsWith("turn off") -> false
        else -> item
    }

    private fun transformPart2(command: String, item: Long): Long = when {
        command.startsWith("toggle") -> item + 2
        command.startsWith("turn on") -> item + 1
        command.startsWith("turn off") -> if (item > 0) {
            item - 1
        } else {
            item
        }

        else -> item
    }

}
