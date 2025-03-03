package year15

import core.Day
import core.InputConverter.Companion.toInts

class Year15Day17(private val target: Int = 150) : Day<List<Int>>(::toInts) {

    override fun part1(input: List<Int>): Int = (1..input.size).sumOf {
        combinations(
            input,
            IntArray(it),
            0,
            input.size - 1,
            0,
            it
        ).count { combination -> combination.sum() == target }
    }

    override fun part2(input: List<Int>): Int = (1..input.size).map {
        combinations(
            input,
            IntArray(it),
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
