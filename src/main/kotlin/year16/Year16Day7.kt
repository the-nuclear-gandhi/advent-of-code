package year16

import core.Day
import core.InputConverter.Companion.toLines

class Year16Day7 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = input.map { it.tokenize() }
        .count { (outside, inside) ->
            inside.none { it.containsTargetSequence() } && outside.any { it.containsTargetSequence() }
        }

    override fun part2(input: List<String>): Int = input.map { it.tokenize() }
        .count { (outside, inside) ->
            outside.flatMap { it.windowed(3) }
                .filter { it[0] == it[2] && it[0] != it[1] }
                .any {
                    inside.any { s -> s.contains("${it[1]}${it[0]}${it[1]}") }
                }
        }

    private fun String.tokenize(): Pair<List<String>, List<String>> = this.run {
        var s = this
        val outsideTokens = mutableListOf<String>()
        val insideTokens = mutableListOf<String>()
        while (s.contains("[") || s.contains("]")) {
            outsideTokens += s.takeWhile { it.isLetter() }
            s = s.dropWhile { it.isLetter() }.run { this.drop(1) }
            insideTokens += s.takeWhile { it.isLetter() }
            s = s.dropWhile { it.isLetter() }.run { this.drop(1) }
        }

        outsideTokens += s

        outsideTokens to insideTokens
    }

    private fun String.containsTargetSequence(): Boolean = this.windowed(4).any {
        it.take(2) == it.takeLast(2).reversed() && it[0] != it[1]
    }
}
