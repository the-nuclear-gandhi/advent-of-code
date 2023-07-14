package year15

import shared.Day
import shared.InputConverter.Companion.toInts

class Year15Day17 : Day<List<Int>>(::toInts) {

    override fun part1(input: List<Int>): Int = solvePart1(input, 150)

    override fun part2(input: List<Int>): Int = solvePart2(input, 150)

    internal fun solvePart1(input: List<Int>, target: Int) = (1..input.size).sumOf {
        combinations(
            input,
            IntArray(it) { 0 },
            0,
            input.size - 1,
            0,
            it
        ).count { combination -> combination.sum() == target }
    }

    internal fun solvePart2(input: List<Int>, target: Int): Int = (1..input.size).map {
        combinations(
            input,
            IntArray(it) { 0 },
            0,
            input.size - 1,
            0,
            it
        ).count { combination -> combination.sum() == target }
    }.first { it > 0 }

    private fun combinations(
        items: List<Int>,
        buffer: IntArray,
        start: Int,
        end: Int,
        index: Int,
        length: Int
    ): List<IntArray> {
        val result = mutableListOf<IntArray>()
        if (index == length) {
            result.add(buffer.clone())
            return result
        }

        var i = start
        while (i <= end && end - i + 1 >= length - index) {
            buffer[index] = items[i]
            result.addAll(combinations(items, buffer, i + 1, end, index + 1, length))
            i++
        }
        return result
    }
}
