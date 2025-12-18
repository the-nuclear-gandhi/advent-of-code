package year15

import core.Day
import core.InputConverter.Companion.trimming
import shared.md5
import kotlin.experimental.and

class Year15Day4 : Day<String>(::trimming) {

    override fun part1(input: String): Int = findHexByPrefix(input) {
        it.take(2).all { byte -> byte == 0.toByte() } && it[2] and 0xf0.toByte() == 0.toByte()
    }
    override fun part2(input: String): Int = findHexByPrefix(input) {
        it.take(3).all { byte -> byte == 0.toByte() }
    }

    private fun findHexByPrefix(s: String, numberSearchFunction: (ByteArray) -> Boolean): Int {
        var answer = 0
        var number = 0

        while (answer == 0) {
            val md5 = "$s$number".md5()
            if (numberSearchFunction(md5)) {
                answer = number
            }

            number++
        }

        return answer
    }
}
