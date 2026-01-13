package year16

import core.Day
import core.InputConverter.Companion.toLines

class Year16Day12 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = solve(input, IntArray(4) { 0 })

    override fun part2(input: List<String>): Int = solve(input, IntArray(4) { 0 }.apply { this[2] = 1 })

    private fun solve(input: List<String>, registers: IntArray): Int {
        var i = 0
        while (i in input.indices) {
            val command = input[i].split(' ')
            when (command[0]) {
                "cpy" -> {
                    val source = command[1].toIntOrNull() ?: registers[registerIndex(command[1][0])]
                    registers[registerIndex(command[2][0])] = source
                    i++
                }

                "inc" -> {
                    registers[registerIndex(command[1][0])]++
                    i++
                }

                "dec" -> {
                    registers[registerIndex(command[1][0])]--
                    i++
                }

                "jnz" -> {
                    val source = command[1].toIntOrNull() ?: registers[registerIndex(command[1][0])]
                    if (source != 0) {
                        i += command[2].toInt()
                    } else {
                        i++
                    }
                }
            }
        }

        return registers[0]
    }

    private fun registerIndex(register: Char): Int = register - 'a'
}
