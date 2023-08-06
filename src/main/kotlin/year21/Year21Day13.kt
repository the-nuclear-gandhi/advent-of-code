package year21

import shared.Day
import shared.InputConverter.Companion.toLines
import shared.Point

class Year21Day13 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = parseInput(input).let { (points, instructions) ->
        foldByInstruction(points, instructions.first()).size
    }

    override fun part2(input: List<String>): Unit = parseInput(input).let { (points, instructions) ->
        val newPoints =
            instructions.fold(points) { acc, instruction -> foldByInstruction(acc, instruction) }

        val maxX = newPoints.maxOf { it.x }
        val maxY = newPoints.maxOf { it.y }

        for (y in 0..maxY) {
            for (x in 0..maxX) {
                if (Point(x, y) in newPoints) {
                    print("%")
                } else {
                    print(" ")
                }
            }
            println()
        }
    }

    private fun parseInput(input: List<String>): Pair<MutableSet<Point>, List<Instruction>> {
        val firstInstructionLine = input.first { it.startsWith("fold") }
        val points = input.subList(0, input.indexOf(firstInstructionLine))
            .map { Point.fromString(it) }
            .toMutableSet()

        val instructions = input.subList(input.indexOf(firstInstructionLine), input.size)
            .map { it.substringAfter("along").trim().split("=") }
            .map { (type, coordinate) -> Instruction(type, coordinate.toInt()) }

        return points to instructions
    }

    private fun foldByInstruction(points: Set<Point>, instruction: Instruction): MutableSet<Point> {
        val targetCoordinate: (Point) -> Int = if (instruction.type == "x") { point ->
            point.x
        } else { point ->
            point.y
        }

        val pointProducer: (Int, Point) -> Point = if (instruction.type == "x") { n, point ->
            Point(n, point.y)
        } else { n, point ->
            Point(point.x, n)
        }

        val max = points.maxOf { targetCoordinate(it) }
        val newPoints = points.filter { targetCoordinate(it) < instruction.coordinate }
            .toMutableSet()

        var i = 1
        while (instruction.coordinate + i <= max) {
            points.filter { targetCoordinate(it) == instruction.coordinate + i }
                .map { pointProducer(instruction.coordinate - i, it) }
                .let { newPoints.addAll(it) }
            i++
        }

        return newPoints
    }

    private data class Instruction(val type: String, val coordinate: Int)
}
