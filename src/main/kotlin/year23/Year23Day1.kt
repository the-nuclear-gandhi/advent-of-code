package year23

import core.Day
import core.InputConverter.Companion.toLines

class Year23Day1 : Day<List<String>>(::toLines) {
    override fun part1(input: List<String>): Int =
        input.map { it.filter { c -> c.isDigit() } }
            .map { "${it.first()}${it.last()}" }
            .sumOf { it.toInt() }

    override fun part2(input: List<String>): Int = mapOf(
        listOf("one", "1") to 1,
        listOf("two", "2") to 2,
        listOf("three", "3") to 3,
        listOf("four", "4") to 4,
        listOf("five", "5") to 5,
        listOf("six", "6") to 6,
        listOf("seven", "7") to 7,
        listOf("eight", "8") to 8,
        listOf("nine", "9") to 9,
    ).let { digits ->
        input.map { s ->
            with(digits.keys.flatten().filter { it in s }) {
                listOf(this.minBy { s.indexOf(it) }, this.maxBy { s.lastIndexOf(it) })
            }
        }
            .map { list -> list.map { digits.getValue(digits.keys.first { key -> it in key }) } }
            .sumOf { it.first() * 10 + it.last() }
    }


}
