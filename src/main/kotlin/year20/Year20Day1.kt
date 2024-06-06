package year20

import core.Day
import core.InputConverter

class Year20Day1 : Day<List<Int>>(InputConverter::toInts) {

    override fun part1(input: List<Int>): Int = input.firstNotNullOfOrNull {
        input.find { n -> it + n == 2020 }?.let { n -> n * it }
    } ?: 0

    override fun part2(input: List<Int>): Int = input.firstNotNullOfOrNull {
        input.find { n -> (2020 - it - n) in input }?.let { n -> n * it * (2020 - it - n) }
    } ?: 0
}
