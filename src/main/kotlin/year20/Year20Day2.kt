package year20

import core.Day
import core.InputConverter.Companion.toLines

class Year20Day2 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = input.map { PasswordPolicy.fromString(it) }
        .count { it.password.count { c -> c == it.letter } in it.times }

    override fun part2(input: List<String>): Int = input.map { PasswordPolicy.fromString(it) }
        .count { "${it.password[it.times.first - 1]}${it.password[it.times.last - 1]}".count { c -> c == it.letter } == 1 }

    private data class PasswordPolicy(val times: IntRange, val letter: Char, val password: String) {
        companion object {
            fun fromString(s: String): PasswordPolicy = s.split(" ")
                .let { (entries, letter, password) ->
                    val times = entries.split("-").map { it.toInt() }
                    PasswordPolicy(times[0]..times.last(), letter[0], password)
                }
        }
    }
}
