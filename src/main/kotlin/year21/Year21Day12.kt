package year21

import shared.Day
import shared.InputConverter.Companion.toLines

class Year21Day12 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int =
        countPaths("start", parseInput(input), listOf()) { nextCave, visited ->
            isVisitedSmallCave(nextCave, visited)
        }

    override fun part2(input: List<String>): Int =
        countPaths("start", parseInput(input), listOf()) { nextCave, visited ->
            isVisitedSmallCave(nextCave, visited) && anySmallCaveVisitedTwice(visited)
        }

    private fun countPaths(
        current: String,
        paths: List<Pair<String, String>>,
        visited: List<String>,
        filteringPredicate: (String, List<String>) -> Boolean
    ): Int =
        if (current == "end") {
            1
        } else {
            paths.filter { it.first == current || it.second == current }
                .flatMap { setOf(it.first, it.second) }
                .filterNot { it == current || it == "start" }
                .filterNot { filteringPredicate(it, visited + current) }
                .sumOf { countPaths(it, paths, visited + current, filteringPredicate) }
        }

    private fun parseInput(input: List<String>): List<Pair<String, String>> = input.map {
        it.split("-").let { tokens -> tokens[0] to tokens[1] }
    }

    private fun isVisitedSmallCave(name: String, visited: List<String>): Boolean = isSmallCave(name) && name in visited

    private fun isSmallCave(name: String): Boolean = name.all { it.isLowerCase() }

    private fun anySmallCaveVisitedTwice(visitedCaves: List<String>): Boolean = visitedCaves.filter { isSmallCave(it) }
        .groupBy { it }
        .any { (_, value) -> value.size > 1 }
}
