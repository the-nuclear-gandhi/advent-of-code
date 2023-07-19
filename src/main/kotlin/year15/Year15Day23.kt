package year15

import shared.Day
import shared.InputConverter.Companion.toLines

class Year15Day23 : Day<List<String>>(::toLines) {
    override fun part1(input: List<String>): Long = solve(mutableMapOf("a" to 0L, "b" to 0L), input)

    override fun part2(input: List<String>): Long = solve(mutableMapOf("a" to 1L, "b" to 0L), input)

    private fun solve(registers: MutableMap<String, Long>, input: List<String>): Long =
        input.map { it.substringBefore(" ") to it.substringAfter(" ") }
            .run {
                var i = 0
                while (i < this.size) {
                    this[i].let { (command, address) ->
                        when (command) {
                            "hlf" -> registers.computeIfPresent(address) { _, v -> v / 2 }.also { i++ }
                            "tpl" -> registers.computeIfPresent(address) { _, v -> v * 3 }.also { i++ }
                            "inc" -> registers.computeIfPresent(address) { _, v -> v + 1 }.also { i++ }
                            "jmp" -> i += address.toInt()
                            "jie" -> {
                                val registerKey = address.substringBefore(",")
                                val offset = address.substringAfter(",").trim().toInt()
                                registers[registerKey]?.let {
                                    i += if (it % 2 == 0L) {
                                        offset
                                    } else {
                                        1
                                    }
                                }
                            }

                            "jio" -> {
                                val registerKey = address.substringBefore(",")
                                val offset = address.substringAfter(",").trim().toInt()
                                registers[registerKey]?.let {
                                    i += if (it == 1L) {
                                        offset
                                    } else {
                                        1
                                    }
                                }
                            }

                            else -> throw RuntimeException("Unknown command")
                        }
                    }
                }

                registers.getValue("b")
            }

}
