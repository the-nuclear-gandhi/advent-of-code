package year15

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point

class Year15Day18(private val repetitions: Int = 100) : Day<List<String>>(::toLines) {
    override fun part1(input: List<String>): Int {
        var lightMap = input.map { s -> s.map { it == '#' } }

        repeat(repetitions) {
            lightMap = lightMap.mapIndexed { x, lightRow ->
                lightRow.mapIndexed { y, b ->
                    val neighboursOn = countNeighboursOn(lightMap, x, y)
                    neighboursOn == 3 || (b && neighboursOn == 2)
                }
            }
        }

        return lightMap.flatten().count { it }
    }

    override fun part2(input: List<String>): Int {
        val cornerPoints = setOf(
            Point(0, 0),
            Point(0, input[0].length - 1),
            Point(input.size - 1, 0),
            Point(input.size - 1, input[0].length - 1)
        )

        var lightMap = input.mapIndexed { x, s ->
            s.mapIndexed { y, c -> Point(x, y) in cornerPoints || c == '#' }
        }

        repeat(repetitions) {
            lightMap = lightMap.mapIndexed { x, lightRow ->
                lightRow.mapIndexed { y, b ->
                    val neighboursOn = countNeighboursOn(lightMap, x, y)
                    Point(x, y) in cornerPoints || (neighboursOn == 3 || (b && neighboursOn == 2))
                }
            }
        }

        return lightMap.flatten().count { it }
    }

    private fun countNeighboursOn(lightMap: List<List<Boolean>>, x: Int, y: Int): Int = Point(x, y)
        .neighbours(true)
        .filter { it.x in lightMap.indices && it.y in lightMap[0].indices }
        .count { lightMap[it.x][it.y] }
}
