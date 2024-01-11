package year23

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point
import shared.PointRange
import kotlin.math.absoluteValue

class Year23Day18 : Day<List<String>>(::toLines) {
    override fun part1(input: List<String>): Long = input.map { it.split(" ") }
        .map { Instruction(it[0], it[1].toInt()) }
        .let { solve(it) }

    private fun solve(instructions: List<Instruction>): Long {
        var start = Point(0, 0)
        val ranges = instructions.map { it.toPointRange(start).also { range -> start = range.end } }
        val area =
            ranges.sumOf { (start, end) -> start.x * end.y.toLong() - start.y * end.x.toLong() }.absoluteValue / 2

        return area + ranges.sumOf { it.size - 1 } / 2 + 1
    }

    override fun part2(input: List<String>): Long = input.map { it.split(" ").last() }
        .map {
            val distance = it.drop(2).take(5).toInt(16)
            val instruction = when (it.dropLast(1).last().digitToInt()) {
                0 -> "R"
                1 -> "D"
                2 -> "L"
                3 -> "U"
                else -> throw RuntimeException("Unsupported operation")
            }

            Instruction(instruction, distance)
        }
        .let { solve(it) }

    private data class Instruction(val direction: String, val length: Int) {
        fun toPointRange(start: Point): PointRange = when (direction) {
            "R" -> Point(start.x, start.y + length)
            "D" -> Point(start.x + length, start.y)
            "L" -> Point(start.x, start.y - length)
            "U" -> Point(start.x - length, start.y)
            else -> throw RuntimeException("Unsupported operation")
        }.run {
            PointRange(start, this)
        }
    }
}
