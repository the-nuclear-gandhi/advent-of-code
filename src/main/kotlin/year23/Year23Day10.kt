package year23

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point
import kotlin.math.absoluteValue

class Year23Day10 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = findMainLoop(input).size / 2

    override fun part2(input: List<String>): Int = findMainLoop(input).run {
        val area = this.indices.sumOf { i ->
            val j = (i + 1) % this.size
            this[i].x * this[j].y - this[i].y * this[j].x
        }.absoluteValue / 2

        area - this.size / 2 + 1
    }

    private fun findMainLoop(input: List<String>): List<Point> {
        val start = input.flatMapIndexed { index, s ->
            s.indices.mapNotNull {
                Point(index, it).takeIf { _ -> s[it] == 'S' }
            }
        }
            .first()

        val queue = connectedNeighbours(start, input).toMutableList()
        val loop = mutableSetOf(start)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            connectedNeighbours(current, input).run {
                if (this.filter { it !in loop }.size == 1) {
                    queue.addFirst(this.first { it !in loop })
                    loop += current
                } else if (this.all { it in loop }) {
                    loop += current
                }
            }
        }

        return loop.toList()
    }

    private fun connectedNeighbours(point: Point, map: List<String>): List<Point> =
        point.neighbours()
            .filter { it.x in map.indices && it.y in map[it.x].indices }
            .filterNot { map[it.x][it.y] == '.' }
            .filter {
                val value = map[it.x][it.y]

                when (map[point.x][point.y]) {
                    'F' -> (value in southConnections && it.x > point.x) || (value in eastConnections && it.y > point.y)
                    '|' -> (value in northConnections && it.x < point.x) || (value in southConnections && it.x > point.x)
                    'L' -> (value in northConnections && it.x < point.x) || (value in eastConnections && it.y > point.y)
                    '-' -> (value in westConnections && it.y < point.y) || (value in eastConnections && it.y > point.y)
                    'J' -> (value in northConnections && it.x < point.x) || (value in westConnections && it.y < point.y)
                    '7' -> (value in southConnections && it.x > point.x) || (value in westConnections && it.y < point.y)
                    else -> when {
                        it.x < point.x -> value in northConnections
                        it.x > point.x -> value in southConnections
                        it.y < point.y -> value in westConnections
                        it.y > point.y -> value in eastConnections
                        else -> false
                    }
                }
            }

    private val northConnections = setOf('|', 'F', '7', 'S')
    private val southConnections = setOf('|', 'J', 'L', 'S')

    private val eastConnections = setOf('-', 'J', '7', 'S')
    private val westConnections = setOf('-', 'F', 'L', 'S')
}
