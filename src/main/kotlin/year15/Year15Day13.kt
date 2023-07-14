package year15

import algorithm.solveTSP
import shared.Day
import shared.InputConverter.Companion.toLines

class Year15Day13 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = solveTSP(distanceMap(input), true, this::criterion)

    override fun part2(input: List<String>): Int = solveTSP(distanceMap(input, "Me"), true, this::criterion)

    private fun criterion(collection: Collection<Int>): Int = collection.maxOrNull() ?: 0

    private fun distanceMap(input: List<String>, vararg additionalPeople: String): Array<IntArray> {
        val people = input.map {
            it.split(" ").let { tokens -> listOf(tokens[0], tokens.last().removeSuffix(".")) }
        }
            .flatten()
            .distinct()
            .toMutableList()

        people.addAll(additionalPeople)

        val distanceMap = Array(people.size) { IntArray(people.size) { 0 } }
        input.map {
            it.split(" ").let { tokens -> listOf(tokens[0], tokens[2], tokens[3], tokens.last().removeSuffix(".")) }
        }
            .forEach { (fromPerson, change, amount, toPerson) ->
                val fromPersonIndex = people.indexOf(fromPerson)
                val toPersonIndex = people.indexOf(toPerson)

                val calculateDistance: (Int) -> Int = {
                    when (change) {
                        "gain" -> it + amount.toInt()
                        "lose" -> it - amount.toInt()
                        else -> it
                    }
                }

                distanceMap[fromPersonIndex][toPersonIndex] =
                    calculateDistance(distanceMap[fromPersonIndex][toPersonIndex])
                distanceMap[toPersonIndex][fromPersonIndex] =
                    calculateDistance(distanceMap[toPersonIndex][fromPersonIndex])
            }
        return distanceMap
    }
}
