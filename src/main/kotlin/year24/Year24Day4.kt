package year24

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point
import shared.PointRange

class Year24Day4 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int {
        val horizontalMatches =
            input.sumOf { it.windowed(4).count { s -> s.isPattern("XMAS") } }

        val verticalMatches =
            input[0].indices.map { index -> input.map { it[index] } }.map { String(it.toCharArray()) }
                .sumOf { it.windowed(4).count { s -> s.isPattern("XMAS") } }

        val diagonalMatches = input.getAllCharacterCoordinates('X')
            .sumOf {
                listOf(
                    PointRange(it, Point(it.x - 3, it.y - 3)),
                    PointRange(it, Point(it.x - 3, it.y + 3)),
                    PointRange(it, Point(it.x + 3, it.y + 3)),
                    PointRange(it, Point(it.x + 3, it.y - 3))
                )
                    .map { range -> input.getStringByCoordinateRange(range) }
                    .count { s -> s.isPattern("XMAS") }
            }

        return horizontalMatches + verticalMatches + diagonalMatches
    }

    override fun part2(input: List<String>): Int = input.getAllCharacterCoordinates('A')
        .count {
            listOf(
                PointRange(Point(it.x - 1, it.y - 1), Point(it.x + 1, it.y + 1)),
                PointRange(Point(it.x + 1, it.y - 1), Point(it.x - 1, it.y + 1))
            )
                .map { range -> input.getStringByCoordinateRange(range) }
                .all { s -> s.isPattern("MAS") }
        }

    private fun String.isPattern(pattern: String): Boolean {
        require(pattern.isNotBlank()) { "Pattern cannot be blank" }
        return this == pattern || this == pattern.reversed()
    }

    private fun List<String>.getAllCharacterCoordinates(char: Char): Set<Point> =
        this.flatMapIndexed { x, s ->
            s.mapIndexedNotNull { y, c -> Point(x, y).takeIf { c == char } }
        }
            .toSet()

    private fun List<String>.getStringByCoordinateRange(range: PointRange): String =
        range.values.filter { it.x in this.indices && it.y in this[it.x].indices }
            .map { this[it.x][it.y] }
            .joinToString("")
}
