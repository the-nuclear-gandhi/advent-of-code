package year24

import core.Day
import core.InputConverter.Companion.toLineBlocks
import shared.LineBlock
import shared.toIntList

class Year24Day5 : Day<List<LineBlock>>(::toLineBlocks) {

    override fun part1(input: List<LineBlock>): Int = with(getRules(input[0])) {
        getNumberLists(input[1]).filter { it.all { n -> isInCorrectOrder(n, it, this) } }
            .sumOf { it[it.size / 2] }
    }

    override fun part2(input: List<LineBlock>): Int = with(getRules(input[0])) {
        getNumberLists(input[1]).filterNot { it.all { n -> isInCorrectOrder(n, it, this) } }
            .map { fixListOrder(it, this) }
            .sumOf { it[it.size / 2] }
    }

    private fun getRules(input: List<String>): Map<Int, List<Int>> =
        input.map { it.split("|").map(String::toInt) }
            .map { it[0] to it[1] }
            .let { list ->
                list.associate {
                    it.first to list.filter { pair -> pair.first == it.first }.map { pair -> pair.second }
                }
            }

    private fun getNumberLists(input: List<String>): List<List<Int>> = input.filter { it.isNotBlank() }
        .map { it.toIntList(",") }

    private fun isInCorrectOrder(n: Int, list: List<Int>, rules: Map<Int, List<Int>>): Boolean =
        rules[n]?.let { numbers ->
            numbers.all { list.indexOf(it) == -1 || list.indexOf(it) > list.indexOf(n) }
        } ?: true

    private fun fixListOrder(list: List<Int>, rules: Map<Int, List<Int>>): List<Int> {
        val originalList = list.toMutableList()
        val result = mutableListOf<Int>()
        while (originalList.isNotEmpty()) {
            val n = originalList.removeFirst()
            val testList = result.toMutableList()

            (0..result.size).firstNotNullOfOrNull { index ->
                testList.add(index, n)
                if (testList.all { num -> isInCorrectOrder(num, testList, rules) }) {
                    index
                } else {
                    testList.remove(n)
                    null
                }
            }?.let {
                result.add(it, n)
            } ?: RuntimeException("No insert position found for number=$n (original list = $list, current result = $result)")
        }

        return result.toList()
    }
}
