package year23

import core.Day
import core.InputConverter.Companion.toLines
import shared.toLongList

class Year23Day6 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Long = input.let {
        val times = it.first().toLongList(" ")
        val distances = it.last().toLongList(" ")

        times.mapIndexed { index, time -> time to distances[index] }
    }
        .map { (time, distance) -> countWaysToWin(time, distance) }
        .reduce { acc, i -> i * acc }

    override fun part2(input: List<String>): Long = input.map {
        it.substringAfter(":").split(" ")
            .filter { token -> token.isNotEmpty() }
            .joinToString("")
            .toLong()
    }
        .let { countWaysToWin(it[0], it[1]) }

    private fun countWaysToWin(time: Long, distance: Long): Long = (1..time)
        .count { it * (time - it) > distance }
        .toLong()
}
