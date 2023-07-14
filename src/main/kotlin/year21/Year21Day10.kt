package year21

import shared.Day
import shared.InputConverter.Companion.toLines

class Year21Day10 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = input.mapNotNull { parseLine(it).firstUnbalancedBracket }
        .sumOf {
            when (it) {
                ')' -> 3
                ']' -> 57
                '}' -> 1197
                '>' -> 25137
                else -> 0
            }.toInt()
        }

    override fun part2(input: List<String>): Long =
        input.map { parseLine(it) }
            .filter { it.firstUnbalancedBracket == null }
            .map {
                it.unmatchedOpeningBrackets.reversed().map { c ->
                    when (c) {
                        '(' -> 1
                        '[' -> 2
                        '{' -> 3
                        '<' -> 4
                        else -> 0
                    }
                }
                    .fold(0L) { acc, i -> acc * 5 + i }
                    .toLong()
            }
            .sorted()
            .let { it[it.size / 2] }

    private fun parseLine(s: String): ParseResult {
        val openingBrackets = mutableListOf<Char>()
        var firstUnbalancedBracket: Char? = null
        var i = 0
        while (firstUnbalancedBracket == null && i < s.length) {
            when {
                s[i].isOpeningBracket() -> openingBrackets.add(s[i])
                s[i].isClosingBracket() ->
                    if (openingBrackets.isEmpty() || openingBrackets.removeLast() != s[i].matchingOpeningBracket()) {
                        firstUnbalancedBracket = s[i]
                    }
            }
            i++
        }

        return if (firstUnbalancedBracket != null) {
            ParseResult(firstUnbalancedBracket, listOf())
        } else {
            ParseResult(null, openingBrackets)
        }
    }

    private fun Char.matchingOpeningBracket(): Char = when (this) {
        ')' -> '('
        '>' -> '<'
        ']' -> '['
        '}' -> '{'
        else -> Char.MIN_VALUE
    }

    private fun Char.isOpeningBracket(): Boolean = this in arrayOf('(', '<', '[', '{')
    private fun Char.isClosingBracket(): Boolean = this in arrayOf(')', '>', ']', '}')

    private data class ParseResult(val firstUnbalancedBracket: Char?, val unmatchedOpeningBrackets: List<Char>)
}
