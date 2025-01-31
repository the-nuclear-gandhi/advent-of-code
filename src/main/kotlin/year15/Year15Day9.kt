package year15

import algorithm.solveTSP
import core.Day
import core.InputConverter.Companion.toLines

class Year15Day9 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int =
        solveTSP(distanceMap(input)) { it.min() }

    override fun part2(input: List<String>): Int =
        solveTSP(distanceMap(input)) { it.max() }

    private fun distanceMap(input: List<String>): Array<IntArray> {
        val locations = input.flatMap {
            it.split(" ").let { tokens -> listOf(tokens[0], tokens[2]) }
        }
            .distinct()

        return Array(locations.size) { IntArray(locations.size) }.apply {
            input.map {
                val origin = it.substringBefore("to").trim()
                val destination = it.substringAfter("to").substringBefore("=").trim()
                val distance = it.substringAfter("=").trim()

                listOf(origin, destination, distance)
            }.forEach { (origin, destination, distance) ->
                val indexOfOrigin = locations.indexOf(origin)
                val indexOfDestination = locations.indexOf(destination)

                this[indexOfOrigin][indexOfDestination] = distance.toInt()
                this[indexOfDestination][indexOfOrigin] = distance.toInt()
            }
        }
    }

}
