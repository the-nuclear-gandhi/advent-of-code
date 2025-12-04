package year25

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point

class Year25Day4 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int =
        input.flatMapIndexed { index, s -> s.indices.map { Point(index, it) } }
            .count { input[it.x][it.y] == '@' && isMovable(it, input) }

    override fun part2(input: List<String>): Int =
        input.flatMapIndexed { index, s -> s.indices.map { Point(index, it) } }
            .run {
                val map = input.toMutableList()
                var sum = 0

                do {
                    val movablePoints = this.filter { map[it.x][it.y] == '@' && isMovable(it, map) }
                        .apply {
                            sum += this.size
                            this.forEach { map[it.x] = map[it.x].replaceRange(it.y, it.y + 1, "x") }
                        }
                } while (movablePoints.isNotEmpty())

                sum
            }

    private fun isMovable(point: Point, map: List<String>) = point.neighbours(true)
        .filter { it.x in map.indices && it.y in map[it.x].indices }
        .count { map[it.x][it.y] == '@' } < 4
}
