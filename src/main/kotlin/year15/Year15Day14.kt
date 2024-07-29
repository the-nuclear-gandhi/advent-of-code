package year15

import core.Day
import core.InputConverter.Companion.toLines
import shared.toIntList

class Year15Day14(private val time: Int = 2503) : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = inputToDeerList(input).maxOf { distanceAtTime(time, it) }

    override fun part2(input: List<String>): Int = inputToDeerList(input).let { deerList ->
        IntArray(deerList.size).apply {
            for (t in 1..time + 1) {
                val distances = deerList.map { distanceAtTime(t, it) }
                distances.max().let {
                    distances.mapIndexed { index, distance ->
                        if (distance == it) {
                            this[index]++
                        }
                    }
                }
            }
        }.max()
    }

    private fun inputToDeerList(input: List<String>): List<Deer> = input.map { it.toIntList() }
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

    private data class Deer(val speed: Int, val flyingTime: Int, val restingTime: Int)
}
