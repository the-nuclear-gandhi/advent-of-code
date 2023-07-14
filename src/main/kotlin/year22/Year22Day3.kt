package year22

import shared.Day
import shared.InputConverter.Companion.toLines

class Year22Day3 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int =
        input.map {
            it.take(it.length / 2)
                .toSet()
                .intersect(it.substring(it.length / 2).toSet())
                .single()
        }
            .sumOf { it.priority() }

    override fun part2(input: List<String>): Int =
        input.chunked(3)
            .map {
                it[0].toSet()
                    .intersect(it[1].toSet())
                    .intersect(it[2].toSet())
                    .single()
            }
            .sumOf { it.priority() }

    private fun Char.priority(): Int = if (this.isLowerCase()) {
        this - 'a' + 1
    } else {
        this - 'A' + 27
    }
}
