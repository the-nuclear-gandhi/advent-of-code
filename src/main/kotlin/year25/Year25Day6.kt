package year25

import core.Day
import core.InputConverter.Companion.toLines
import shared.toLongList

class Year25Day6 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Long {
        val operations = input.last().split(" ").filter(String::isNotBlank)
        val numbers = input.dropLast(1).map { it.toLongList(" ") }

        return operations.indices.sumOf {
            numbers.map { list -> list[it] }.reduce { acc, n -> reduceByOperation(operations[it], acc, n) }
        }
    }

    override fun part2(input: List<String>): Long {
        val operations = input.last().split(" ").filter(String::isNotBlank)
        val numberLines = input.dropLast(1)

        val spaces = numberLines[0].indices.filter { numberLines.all { s -> s[it] == ' ' } }

        return operations.indices.reversed().sumOf { i ->
            val numberStart = if (i - 1 in spaces.indices) spaces[i - 1] + 1 else 0
            val numberEnd = if (i in spaces.indices) spaces[i] else numberLines[0].length

            (numberEnd - 1  downTo numberStart).map { index ->
                numberLines.map { it[index] }.joinToString("")
            }
                .map { it.trim().toLong() }
                .reduce { acc, n -> reduceByOperation(operations[i], acc, n) }
        }
    }

    private fun reduceByOperation(operation: String, acc: Long, n: Long): Long = if (operation == "+") {
        acc + n
    } else {
        acc * n
    }
}
