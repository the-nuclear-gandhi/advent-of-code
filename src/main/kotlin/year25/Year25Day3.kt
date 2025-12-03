package year25

import core.Day
import core.InputConverter.Companion.toLines

class Year25Day3 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = input.sumOf { findNumber(it, 2).toInt() }

    override fun part2(input: List<String>): Long = input.sumOf { findNumber(it, 12).toLong() }

    private fun findNumber(input: String, length: Int): String {
        var number = ""
        var remainingDigits = length
        var index = 0

        while (length - number.length > 0) {
            val maxDigit = input.mapIndexed { index, digit -> index to digit.digitToInt() }
                .sortedByDescending { it.second }
                .filter { it.first >= index && input.length - it.first >= remainingDigits }
                .maxBy { it.second }

            number += maxDigit.second
            index = maxDigit.first + 1
            remainingDigits--
        }

        return number
    }
}
