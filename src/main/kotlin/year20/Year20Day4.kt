package year20

import core.Day
import core.InputConverter.Companion.toLineBlocks
import shared.LineBlock

class Year20Day4 : Day<List<LineBlock>>(::toLineBlocks) {

    override fun part1(input: List<LineBlock>): Int = inputToPassportData(input).count { it.containsAllRequiredKeys() }

    override fun part2(input: List<LineBlock>): Int =
        inputToPassportData(input).count { it.containsAllRequiredKeys() && it.containsValidValues() }

    private fun inputToPassportData(input: List<LineBlock>): List<Map<String, String>> =
        input.map { it.joinToString(" ") }
            .map { it.split(Regex("\\s+")).filter { s -> s.isNotBlank() } }
            .map { list -> list.map { it.split(":") }.associate { it[0] to it[1] } }

    private fun Map<String, String>.containsAllRequiredKeys(): Boolean = this.keys.containsAll(requiredKeys)
    private fun Map<String, String>.containsValidValues(): Boolean = this.entries.all { (key, value) ->
        when (key) {
            "byr" -> value.isNumberOfLengthAndInRange(4, 1920..2002)
            "iyr" -> value.isNumberOfLengthAndInRange(4, 2010..2020)
            "eyr" -> value.isNumberOfLengthAndInRange(4, 2020..2030)
            "hgt" -> if (value.contains("cm")) {
                value.takeWhile { it.isDigit() }.toInt() in 150..193
            } else {
                value.takeWhile { it.isDigit() }.toInt() in 59..76
            }

            "hcl" -> value.matches(Regex("#[0-9a-f]{6}"))
            "ecl" -> value in validEyeColor
            "pid" -> value.isNumberOfLength(9)
            else -> true
        }
    }

    private fun String.isNumberOfLength(length: Int): Boolean = this.length == length && this.all { it.isDigit() }
    private fun String.isNumberOfLengthAndInRange(length: Int, range: IntRange): Boolean =
        this.isNumberOfLength(length) && this.toInt() in range

    private val requiredKeys = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    private val validEyeColor = setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
}
