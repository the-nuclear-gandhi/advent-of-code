package year24

import core.Day
import core.InputConverter.Companion.toLines
import kotlin.math.abs

class Year24Day1 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = inputToListOfIntLists(input).let { lists ->
        val firstList = lists.first().sorted()
        val secondList = lists.last().sorted()

        firstList.mapIndexed { index, i -> abs(i - secondList[index]) }.sum()
    }

    override fun part2(input: List<String>): Int = inputToListOfIntLists(input).let { lists ->
        lists.first().sumOf { it * lists.last().count { n -> n == it } }
    }

    private fun inputToListOfIntLists(input: List<String>): List<List<Int>> =
        input.map { s -> s.split(" ").filter { it.isNotEmpty() } }
            .map { list -> list.map { it.toInt() } }
            .let { lists ->
                listOf(
                    lists.map { it.first() },
                    lists.map { it.last() }
                )
            }
}
