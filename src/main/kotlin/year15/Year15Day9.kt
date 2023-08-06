package year15

import algorithm.solveTSP
import core.Day
import core.InputConverter.Companion.toLines

class Year15Day9 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int =
        solveTSP(distanceMap(input)) { collection -> collection.minOrNull() ?: 0 }

    override fun part2(input: List<String>): Int =
        solveTSP(distanceMap(input)) { collection -> collection.maxOrNull() ?: 0 }

    private fun distanceMap(input: List<String>): Array<IntArray> {
        val locations = input.map {
            it.split(" ").let { tokens -> listOf(tokens[0], tokens[2]) }
        }
            .flatten()
            .distinct()

        val distanceMap = Array(locations.size) { IntArray(locations.size) { 0 } }
        input.map {
            val origin = it.substringBefore("to").trim()
            val destination = it.substringAfter("to").substringBefore("=").trim()
            val distance = it.substringAfter("=").trim()

            listOf(origin, destination, distance)
        }
            .forEach { (origin, destination, distance) ->
                val indexOfOrigin = locations.indexOf(origin)
                val indexOfDestination = locations.indexOf(destination)

                distanceMap[indexOfOrigin][indexOfDestination] = distance.toInt()
                distanceMap[indexOfDestination][indexOfOrigin] = distance.toInt()
            }

        return distanceMap
    }

}
