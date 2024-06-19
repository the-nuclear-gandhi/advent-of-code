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
            "byr" -> value.isAFourDigitNumber() && value.toInt() in 1920..2002
            "iyr" -> value.isAFourDigitNumber() && value.toInt() in 2010..2020
            "eyr" -> value.isAFourDigitNumber() && value.toInt() in 2020..2030
            "hgt" -> if (value.contains("cm")) {
                value.takeWhile { c -> c.isDigit() }.toInt() in 150..193
            } else {
                value.takeWhile { c -> c.isDigit() }.toInt() in 59..76
            }
            "hcl" -> value.matches(Regex("#[0-9a-f]{6}"))
            "ecl" -> value in setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
            "pid" -> value.matches(Regex("\\d{9}"))
            else -> true
        }
    }

    private fun String.isAFourDigitNumber(): Boolean = this.matches(Regex("\\d{4}"))

    private val requiredKeys = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
}
