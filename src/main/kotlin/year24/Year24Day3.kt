package year24

import core.Day
import core.InputConverter.Companion.noOp

class Year24Day3 : Day<String>(::noOp) {

    override fun part1(input: String): Int =
        Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)").findAll(input).sumOf {
            it.groupValues[1].toInt() * it.groupValues[2].toInt()
        }

    override fun part2(input: String): Int {
        val mulCommands = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)").findAll(input)
        val doCommands = Regex("do\\(\\)").findAll(input)
        val dontCommands = Regex("don't\\(\\)").findAll(input)

        val commands = (mulCommands + doCommands + dontCommands).sortedBy { it.range.first }

        var sum = 0
        var enabled = true
        for (command in commands) {
            when {
                command.value.startsWith("mul") -> if (enabled) {
                    sum += command.groupValues[1].toInt() * command.groupValues[2].toInt()
                }
                command.value.startsWith("do()") -> enabled = true
                command.value.startsWith("don't") -> enabled = false
            }
        }

        return sum
    }
}
