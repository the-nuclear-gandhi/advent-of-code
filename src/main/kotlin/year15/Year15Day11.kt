package year15

import core.Day
import core.InputConverter.Companion.trimming

class Year15Day11 : Day<String>(::trimming) {

    override fun part1(input: String): String {
        var chars = input.toCharArray()
        do {
            chars = nextPassword(chars)
        } while (!isValidPassword(chars))
        return chars.joinToString("")
    }

    override fun part2(input: String): String = part1(part1(input))

    private fun nextPassword(chars: CharArray): CharArray {
        val incrementPositions = mutableSetOf(chars.size - 1)
        var i = chars.size - 2
        while (chars[i + 1] == 'z' && i > -1) {
            incrementPositions.add(i)
            i--
        }

        chars.indices
            .filter { incrementPositions.contains(it) }
            .map { chars[it] = 'a' + (chars[it] + 1 - 'a') % ('z' - 'a' + 1) }

        return chars
    }

    private fun isValidPassword(chars: CharArray) =
        !chars.any { it == 'i' || it == 'o' || it == 'l' } &&
            chars.filterIndexed { index, c -> index < chars.size - 2 && chars[index + 1] - c == 1 && chars[index + 2] - c == 2 }
                .any() &&
            chars.filterIndexed { index, c -> index < chars.size - 1 && chars[index + 1] == c && chars[index - 1] != c }
                .count() > 1
}
