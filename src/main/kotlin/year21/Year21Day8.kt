package year21

import shared.Day

class Year21Day8 : Day<List<String>>() {
    override fun getInput(): List<String> = inputResource().asLines()

    override fun part1(input: List<String>): Int = input.map { it.substringAfter(" | ").trim() }
        .flatMap { it.split(" ") }
        .count { it.length in listOf(2, 3, 4, 7) }

    override fun part2(input: List<String>): Long =
        input.map {
            val patterns = it.substringBefore(" | ").trim().split(" ")
            val numbers = it.substringAfter(" | ").trim().split(" ")

            patterns to numbers
        }
            .sumOf { (patterns, numbers) ->
                val segments = mutableMapOf<Int, Set<Char>>()

                segments[1] = patterns.first { it.length == 2 }.toSet()
                segments[7] = patterns.first { it.length == 3 }.toSet()
                segments[4] = patterns.first { it.length == 4 }.toSet()
                segments[8] = patterns.first { it.length == 7 }.toSet()

                patterns.filter { it.length == 6 }
                    .map { it.toSet() }
                    .forEach {
                        val index = when {
                            it.containsAll(segments[7]!!) && it.containsAll(segments[4]!!) -> 9
                            !it.containsAll(segments[1]!!) -> 6
                            else -> 0
                        }
                        segments[index] = it
                    }

                patterns.filter { it.length == 5 }
                    .map { it.toSet() }
                    .forEach {
                        val index = when {
                            it.containsAll(segments[7]!!) -> 3
                            segments[6]!!.containsAll(it) -> 5
                            else -> 2
                        }
                        segments[index] = it
                    }

                numbers.map {
                    segments.filter { segment -> segment.value.size == it.length }
                        .keys
                        .first { key -> it.toSet().containsAll(segments[key]!!) }
                }
                    .joinToString("")
                    .toLong()
            }
}
