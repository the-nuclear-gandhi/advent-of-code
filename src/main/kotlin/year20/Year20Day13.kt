package year20

import core.Day
import core.InputConverter.Companion.toLines

class Year20Day13 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = parseInput(input).let { (targetTime, buses) ->
        buses.filterNotNull()
            .associateWith { it * (targetTime / it + 1) - targetTime }
            .entries
            .minBy { it.value }
            .let { it.key * it.value }
    }

    override fun part2(input: List<String>): Long = parseInput(input).let { (_, buses) ->
        val busesByIndex = buses.indices.filter { buses[it] != null }.zip(buses.filterNotNull())

        var time = 0L
        var step = busesByIndex[0].second.toLong()
        var currentIndex = 1

        while (currentIndex < busesByIndex.size) {
            time += step

            if ((time + busesByIndex[currentIndex].first) % busesByIndex[currentIndex].second == 0L) {
                step *= busesByIndex[currentIndex].second
                currentIndex++
            }
        }

        time
    }

    private fun parseInput(input: List<String>): Pair<Int, List<Int?>> =
        input[0].toInt() to input[1].split(",").map(String::toIntOrNull)
}
