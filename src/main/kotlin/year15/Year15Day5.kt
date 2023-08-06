package year15

import core.Day
import core.InputConverter.Companion.toLines

class Year15Day5 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = input
        .asSequence()
        .filter { Regex("[aeiou]").findAll(it).count() >= 3 }
        .filter { it.contains(Regex("([a-z])\\1")) }
        .filterNot { it.contains(Regex("ab|cd|pq|xy")) }
        .count()

    override fun part2(input: List<String>): Int = input
        .asSequence()
        .filter {
            it.asSequence()
                .zipWithNext { a, b -> Regex("$a$b") }
                .filterIndexed { index, regex -> regex.findAll(it, index + 2).any() }
                .any()
        }
        .filter {
            it.filterIndexed { index, c -> index < it.length - 2 && it[index + 2] == c }.any()
        }
        .count()

}
