package year22

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point

class Year22Day9 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = solve(input, 2)

    override fun part2(input: List<String>): Int = solve(input, 10)

    private fun solve(input: List<String>, knots: Int) = with(MutableList(knots) { Point(0, 0) }) {
        input.map { s -> s.split(" ").let { it[0] to it[1].toInt() } }
            .map { (direction, distance) ->
                val movementFunction: (Int) -> Int = when (direction) {
                    "R", "U" -> Int::inc
                    "L", "D" -> Int::dec
                    else -> { i -> i }
                }

                val visited = mutableSetOf<Point>()
                repeat(distance) {
                    val head = this[0]
                    this[0] = when (direction) {
                        "R", "L" -> Point(movementFunction(head.x), head.y)
                        "U", "D" -> Point(head.x, movementFunction(head.y))
                        else -> head
                    }

                    for (i in 0 until this.size - 1) {
                        this[i + 1] = moveTail(this[i], this[i + 1])
                    }

                    visited += this.last()
                }

                visited
            }
            .flatten()
            .toSet().size
    }

    private fun moveTail(head: Point, tail: Point): Point =
        when {
            head.x - tail.x > 1 -> Point(head.x - 1, head.y)
            head.x - tail.x < -1 -> Point(head.x + 1, head.y)
            head.y - tail.y > 1 -> Point(head.x, head.y - 1)
            head.y - tail.y < -1 -> Point(head.x, head.y + 1)
            else -> tail
        }
}
