package year15

import core.Day
import core.InputConverter.Companion.toLines

class Year15Day19 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = Pair(input.last(), input.dropLast(1)).let { (molecule, rules) ->
        rules.map { it.split(" ").let { tokens -> tokens.first() to tokens.last() } }
            .map { (sequence, replacement) ->
                molecule.windowed(sequence.length)
                    .mapIndexedNotNull { index, s ->
                        s.takeIf { it == sequence }
                            ?.let { molecule.replaceRange(index, index + it.length, replacement) }
                    }
            }
            .flatten()
            .distinct()
            .size
    }

    /* solution from the comments here: https://www.reddit.com/r/adventofcode/comments/3xflz8/day_19_solutions/ */
    override fun part2(input: List<String>): Int = input.last().let { molecule ->
        val subtractForE = input.dropLast(1)
            .map { it.split(" ").let { tokens -> tokens.first() to tokens.last() } }
            .filter { it.first == "e" }
            .let { rules ->
                if (rules.any { it.second in molecule }) {
                    0
                } else {
                    1
                }
            }

        molecule.count { it.isUpperCase() } - molecule.countSubstring("Ar") -
            molecule.countSubstring("Rn") - 2 * molecule.countSubstring("Y") - subtractForE
    }

    private fun String.countSubstring(substring: String): Int {
        var count = 0
        var s = this
        while (substring in s) {
            count++
            s = s.drop(s.indexOf(substring) + substring.length)
        }

        return count
    }
}
