package year15

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point

class Year15Day18 : Day<List<String>>(::toLines) {
    override fun part1(input: List<String>): Int = solvePart1(input, 100)

    override fun part2(input: List<String>): Int = solvePart2(input, 100)

    internal fun solvePart1(input: List<String>, times: Int): Int {
        var lightMap = input.map { s ->
            s.map { it == '#' }.toList()
        }

        repeat(times) {
            lightMap = lightMap.mapIndexed { x, lightRow ->
                lightRow.mapIndexed { y, b ->
                    val neighboursOn = countNeighboursOn(lightMap, x, y)
                    neighboursOn == 3 || (b && neighboursOn == 2)
                }
            }
        }

        return lightMap.flatten().count { it }
    }

    private fun countNeighboursOn(lightMap: List<List<Boolean>>, x: Int, y: Int): Int = Point(x, y)
        .neighbours(true)
        .filter { it.x in lightMap.indices && it.y in lightMap[0].indices }
        .count { lightMap[it.x][it.y] }

    internal fun solvePart2(input: List<String>, times: Int): Int {
        val cornerPoints = setOf(
            Point(0, 0),
            Point(0, input[0].length - 1),
            Point(input.size - 1, 0),
            Point(input.size - 1, input[0].length - 1)
        )

        var lightMap = input.mapIndexed { x, s ->
            s.mapIndexed { y, c -> Point(x, y) in cornerPoints || c == '#' }.toList()
        }

        repeat(times) {
            lightMap = lightMap.mapIndexed { x, lightRow ->
                lightRow.mapIndexed { y, b ->
                    val neighboursOn = countNeighboursOn(lightMap, x, y)
                    Point(x, y) in cornerPoints || (neighboursOn == 3 || (b && neighboursOn == 2))
                }
            }
        }

        return lightMap.flatten().count { it }
    }
}
