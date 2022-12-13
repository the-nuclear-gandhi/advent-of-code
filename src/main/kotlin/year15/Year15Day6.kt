package year15

import shared.Day

class Year15Day6 : Day<List<String>>() {

    override fun getInput(): List<String> = inputResource().asLines()

    override fun part1(input: List<String>): Int =
        calculate(input, Array(1000) { Array(1000) { false } }, ::transformPart1)
            .flatten()
            .count { it }

    override fun part2(input: List<String>): Long =
        calculate(input, Array(1000) { Array(1000) { 0 } }, ::transformPart2)
            .flatten()
            .sumOf { it.toLong() }

    private fun <T> calculate(input: List<String>, map: Array<Array<T>>, transform: (String, T) -> T): Array<Array<T>> {
        input.forEach {
            val tokens = it.split(" ")

            val start = parsePoint(tokens[tokens.size - 3])
            val end = parsePoint(tokens.last())

            for (x in start.first..end.first) {
                for (y in start.second..end.second) {
                    map[x][y] = transform(it, map[x][y])
                }
            }
        }

        return map
    }

    private fun parsePoint(s: String): Pair<Int, Int> =
        Pair(s.substringBefore(",").toInt(), s.substringAfter(",").toInt())

    private fun transformPart1(command: String, item: Boolean): Boolean = when {
        command.startsWith("toggle") -> !item
        command.startsWith("turn on") -> true
        command.startsWith("turn off") -> false
        else -> item
    }

    private fun transformPart2(command: String, item: Int): Int = when {
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
