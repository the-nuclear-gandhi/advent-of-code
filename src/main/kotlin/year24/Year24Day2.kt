package year24

import core.Day
import core.InputConverter.Companion.toLines
import shared.toIntList
import kotlin.math.abs

class Year24Day2 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = input.map { it.toIntList().zipWithNext() }
        .count { it.isSafePerDefault() }

    override fun part2(input: List<String>): Int = input.map { it.toIntList() }
        .count { isSafeOrCanBeMadeSafe(it) }

    private fun List<Pair<Int, Int>>.isSafePerDefault(): Boolean =
        this.all { (a, b) -> inSafeDistance(a, b) } && this.map { (a, b) -> direction(a, b) }.toSet().size == 1

    private fun isSafeOrCanBeMadeSafe(list: List<Int>): Boolean {
        val listOfPairs = list.zipWithNext()
        if (listOfPairs.isSafePerDefault()) {
            return true
        }

        val anomalyPairIndices = listOfPairs.filter { (a, b) -> !inSafeDistance(a, b) }
            .map { listOfPairs.indexOf(it) }
            .toMutableSet()

        val signs = listOfPairs.map { (a, b) -> direction(a, b) }
        val signGroups = signs.groupBy { it }.filterNot { it.key == 0 }
        if (signGroups.size > 1) {
            val anomalySign = signGroups.map { (k, v) -> k to v.size }
                .let { groups -> groups.first { it.second == groups.minOf { group -> group.second } }.first }

            signs.mapIndexedNotNull { index, sign -> index.takeIf { sign == anomalySign } }
                .toSet()
                .apply { anomalyPairIndices.addAll(this) }
        }

        return anomalyPairIndices.flatMap {
            listOf(
                list.subList(0, it) + list.subList(it + 1, list.size),
                list.subList(0, it + 1) + list.subList(it + 2, list.size)
            )
        }
            .let { modifiedLists -> modifiedLists.any { it.zipWithNext().isSafePerDefault() } }
    }

    private fun inSafeDistance(a: Int, b: Int): Boolean = abs(a - b) in 1..3
    private fun direction(a: Int, b: Int): Int = a.compareTo(b)
}
