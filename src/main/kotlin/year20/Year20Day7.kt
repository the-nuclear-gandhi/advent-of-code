package year20

import core.Day
import core.InputConverter.Companion.toLines

class Year20Day7 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = inputToBagMap(input).run {
        val containers = this.entries.filter { (_, value) -> value.any { it.second == "shiny gold" } }
            .map { it.key }
            .toMutableSet()

        do {
            val addedContainers = this.entries.filter { (_, value) -> value.any { it.second in containers } }
                .map { it.key }
                .count { containers.add(it) }
        } while (addedContainers > 0)

        containers.size
    }

    override fun part2(input: List<String>): Int = inputToBagMap(input).run {
        getBagCount("shiny gold", this)
    }

    private fun inputToBagMap(input: List<String>): Map<String, List<Pair<Int, String>>> =
        input.map { it.replace(Regex("bags?\\.?"), "") }
            .associate { line ->
                val key = line.substringBefore(" contain").trim()
                val value = line.substringAfter("contain ").split(" , ")
                    .map { it.trim() }
                    .let { tokens ->
                        if (tokens.any { it.first().isDigit() }) {
                            tokens.map {
                                it.first().digitToInt() to it.substringAfter(" ").trim()
                            }
                        } else {
                            listOf()
                        }
                    }

                key to value
            }

    private fun getBagCount(key: String, bagMap: Map<String, List<Pair<Int, String>>>): Int =
        bagMap[key]?.let { list ->
            list.sumOf { (count, type) -> count + count * getBagCount(type, bagMap) }
        } ?: 0
}
