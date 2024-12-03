package year15

import core.Day
import core.InputConverter.Companion.toLines

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
                            "jie" -> i += getConditionalOffset(registers, address) { it % 2 == 0L }
                            "jio" -> i += getConditionalOffset(registers, address) { it == 1L }
                            else -> throw RuntimeException("Unknown command")
                        }
                    }
                }

                registers.getValue("b")
            }

    private fun getConditionalOffset(
        registers: Map<String, Long>,
        address: String,
        condition: (Long) -> Boolean
    ): Int {
        val registerKey = address.substringBefore(",")
        val offset = address.substringAfter(",").trim().toInt()

        return registers[registerKey]?.takeIf { condition(it) }?.let { offset } ?: 1
    }
}
