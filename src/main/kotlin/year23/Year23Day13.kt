package year23

import core.Day
import core.InputConverter.Companion.toLineBlocks
import shared.LineBlock

class Year23Day13 : Day<List<LineBlock>>(::toLineBlocks) {

    override fun part1(input: List<LineBlock>): Int =
        input.sumOf { perfectSymmetryFactor(it.indexedColumns()) + perfectSymmetryFactor(it.indexedRows()) * 100 }

    override fun part2(input: List<LineBlock>): Int =
        input.sumOf { pattern ->
            val columns = pattern.indexedColumns()
            val rows = pattern.indexedRows()

            val verticalIndices = findSmudges(columns).flatMap { perfectSymmetryIndices(it) }
                .toMutableSet() - perfectSymmetryIndices(columns).toSet()
            val horizontalIndices = findSmudges(rows).flatMap { perfectSymmetryIndices(it) }
                .toMutableSet() - perfectSymmetryIndices(rows).toSet()

            when {
                horizontalIndices.isNotEmpty() && verticalIndices.isNotEmpty() -> throw RuntimeException("Both horizontal & vertical symmetry found with smudge fix")
                horizontalIndices.isEmpty() && verticalIndices.isEmpty() -> throw RuntimeException("No new symmetry found for any of the smudge fixes")
                else -> if (horizontalIndices.isNotEmpty()) {
                    horizontalIndices.first().second * 100
                } else {
                    verticalIndices.first().second
                }
            }
        }

    private fun perfectSymmetryFactor(patterns: List<Pair<Int, String>>): Int =
        perfectSymmetryIndices(patterns).firstOrNull()?.second ?: 0

    private fun perfectSymmetryIndices(patterns: List<Pair<Int, String>>): List<Pair<Int, Int>> =
        patterns.zipWithNext().filter { it.first.second == it.second.second }
            .map { (p1, p2) -> p1.first to p2.first }
            .filter { (left, right) ->
                var counter = 0
                var perfectlySymmetrical = true
                while (left - counter in patterns.indices && right + counter in patterns.indices) {
                    if (patterns[left - counter].second == patterns[right + counter].second) {
                        counter++
                    } else {
                        perfectlySymmetrical = false
                        break
                    }
                }

                perfectlySymmetrical
            }

    private fun findSmudges(patterns: List<Pair<Int, String>>): List<List<Pair<Int, String>>> =
        patterns.flatMapIndexed { i, pattern ->
            patterns.filterIndexed { j, it -> j > i && distance(pattern.second, it.second) == 1 }
                .flatMap {
                    listOf(
                        patterns.toMutableList().apply { this[i] = i to it.second },
                        patterns.toMutableList().apply { this[it.first] = it.first to pattern.second }
                    )
                }
        }

    private fun distance(s1: String, s2: String): Int =
        require(s1.length == s2.length) {
            "Strings must be of the same length to calculate distance, received s1=$s1, s2=$s2"
        }
            .run { s1.indices.count { s1[it] != s2[it] } }

    private fun List<String>.indexedColumns(): List<Pair<Int, String>> =
        this[0].indices.map { index -> this.filter { it.isNotEmpty() }.map { it[index] } }
            .mapIndexed { index, chars -> index to String(chars.toCharArray()) }

    private fun List<String>.indexedRows(): List<Pair<Int, String>> =
        this.filter { it.isNotEmpty() }.mapIndexed { index, s -> index to s }
}
