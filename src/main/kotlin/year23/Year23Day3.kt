package year23

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point

class Year23Day3 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = parseNumbers(input)
        .filter { number ->
            number.neighbours(input)
                .map { input[it.x][it.y] }
                .any { !(it == '.' || it.isDigit()) }
        }
        .sumOf { it.value }

    override fun part2(input: List<String>): Int = parseNumbers(input)
        .asSequence()
        .mapNotNull { number ->
            number.neighbours(input)
                .firstOrNull { input[it.x][it.y] == '*' }
                ?.let { number to it }
        }
        .groupBy({ it.second }, { it.first })
        .filter { it.value.size == 2 }
        .map { it.value.map { number -> number.value } }
        .sumOf { it.first() * it.last() }

    private fun parseNumbers(input: List<String>): List<Number> = input.flatMapIndexed { row, s ->
        var buffer = ""
        val points = mutableListOf<Point>()
        val foundNumbers = mutableListOf<Number>()
        for (i in s.indices) {
            if (s[i].isDigit()) {
                buffer += s[i]
                points += Point(row, i)
            } else if (buffer.isNotEmpty()) {
                foundNumbers += Number(buffer.toInt(), points.toList())
                buffer = ""
                points.clear()
            }
        }
        if (buffer.isNotEmpty()) {
            foundNumbers += Number(buffer.toInt(), points.toList())
        }

        foundNumbers
    }

    private data class Number(val value: Int, val points: List<Point>)

    private fun Number.neighbours(input: List<String>): List<Point> = this.points.flatMap { it.neighbours(true) }
        .toSet()
        .filter { it.x in input.indices && it.y in input[0].indices }
}
