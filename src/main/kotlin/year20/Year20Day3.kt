package year20

import core.Day
import core.InputConverter.Companion.toLines

class Year20Day3 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = treesOnSlope(input, 3, 1)

    override fun part2(input: List<String>): Long = listOf(
        treesOnSlope(input, 1, 1),
        treesOnSlope(input, 3, 1),
        treesOnSlope(input, 5, 1),
        treesOnSlope(input, 7, 1),
        treesOnSlope(input, 1, 2)
    )
        .map { it.toLong() }
        .reduce { acc, i -> i * acc }

    private fun treesOnSlope(input: List<String>, right: Int, down: Int): Int {
        val coordinates = buildList {
            var x = 0
            var y = 0
            while (x < input.size) {
                this += input[x][y]
                x += down
                y = (y + right) % input[0].length
            }
        }

        return coordinates.count { it == '#' }
    }
}
