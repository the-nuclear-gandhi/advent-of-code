package year21

import shared.Day
import shared.InputConverter.Companion.toLines

class Year21Day2 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Long =
        sumByDirection(input, "forward") * (sumByDirection(input, "down") - sumByDirection(input, "up"))

    override fun part2(input: List<String>): Long {
        val distance = sumByDirection(input, "forward")
        var depth = 0L
        var aim = 0L

        input.forEach {
            val units = it.substringAfter(" ").toLong()
            when (it.substringBefore(" ")) {
                "forward" -> depth += units * aim
                "down" -> aim += units
                "up" -> aim -= units
            }
        }

        return distance * depth
    }

    private fun sumByDirection(input: List<String>, direction: String): Long =
        input.filter { it.startsWith(direction) }.sumOf { it.substringAfter(" ").toLong() }

}
