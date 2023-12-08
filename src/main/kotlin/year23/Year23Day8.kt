package year23

import core.Day
import core.InputConverter.Companion.toLines

class Year23Day8 : Day<List<String>>(::toLines) {
    override fun part1(input: List<String>): Int = with(parseInput(input)) {
        treeLength("AAA", this) { it == "ZZZ" }
    }

    override fun part2(input: List<String>): Long = with(parseInput(input)) {
        connections.keys.filter { it.endsWith("A") }
            .map {
                treeLength(it, this) { node -> node.endsWith("Z") }.toLong()
            }
            .reduce { acc, i -> acc / gcd(acc, i) * i }
    }

    private fun parseInput(input: List<String>): NavigationMap = input.let {
        val instructions = input[0]

        val connections = input.drop(1)
            .associate {
                val value = it.substringBefore("=").trim()
                val connections = it.substringAfter("(").substringBefore(")")
                    .split(",")
                    .map { token -> token.trim() }
                    .let { list -> list[0] to list[1] }

                value to connections
            }

        NavigationMap(instructions, connections)
    }

    private fun treeLength(startingNode: String, navigationMap: NavigationMap, endCondition: (String) -> Boolean): Int =
        with(navigationMap) {
            var index = 0
            var node = startingNode
            while (!endCondition(node)) {
                val command = instructions[index % instructions.length]
                val connections = connections.getValue(node)
                node = when (command) {
                    'R' -> connections.second
                    'L' -> connections.first
                    else -> throw RuntimeException("Unknown command")
                }
                index++
            }

            index
        }


    private fun gcd(a: Long, b: Long): Long = if (b == 0L) {
        a
    } else {
        gcd(b, a % b)
    }

    private data class NavigationMap(val instructions: String, val connections: Map<String, Pair<String, String>>)
}
