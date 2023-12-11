package year15

import core.Day
import core.InputConverter.Companion.toLines
import shared.toIntList

class Year15Day14 : Day<List<String>>(::toLines) {

    private data class Deer(val speed: Int, val flyingTime: Int, val restingTime: Int)

    override fun part1(input: List<String>): Int = solvePart1(input, 2503)

    override fun part2(input: List<String>): Int = solvePart2(input, 2503)

    internal fun solvePart1(input: List<String>, time: Int): Int =
        inputToDeerList(input).maxOf { deer -> distanceAtTime(time, deer) }

    internal fun solvePart2(input: List<String>, time: Int): Int {
        val deerList = inputToDeerList(input)
        val score = IntArray(deerList.size)

        for (t in 1..time + 1) {
            val distances = deerList.map { distanceAtTime(t, it) }
            val maxDistance = distances.maxOrNull()!!

            distances.mapIndexed { index, distance -> index to distance }
                .filter { it.second == maxDistance }
                .forEach { score[it.first]++ }
        }

        return score.maxOrNull()!!
    }

    private fun inputToDeerList(input: List<String>): List<Deer> =
        input.map { it.toIntList() }
            .map { (speed, flyingTime, restingTime) -> Deer(speed, flyingTime, restingTime) }

    private fun distanceAtTime(time: Int, deer: Deer): Int {
        val totalPeriods = time / (deer.flyingTime + deer.restingTime)
        val remainingTime = time % (deer.flyingTime + deer.restingTime)

        var distance = deer.speed * deer.flyingTime * totalPeriods
        distance += if (remainingTime >= deer.flyingTime) {
            deer.speed * deer.flyingTime
        } else {
            deer.speed * (remainingTime % deer.flyingTime)
        }

        return distance
    }
}
