package year20

import core.Day
import core.InputConverter.Companion.toLines

class Year20Day8 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = execute(input).accumulator

    override fun part2(input: List<String>): Int = input.mapIndexedNotNull { index, s ->
        input.takeIf { s.startsWith("nop") || s.startsWith("jmp") }
            ?.toMutableList()
            ?.apply {
                this[index] = when {
                    this[index].startsWith("nop") -> this[index].replace("nop", "jmp")
                    this[index].startsWith("jmp") -> this[index].replace("jmp", "nop")
                    else -> this[index]
                }
            }
            ?.let { execute(it) }
    }
        .firstOrNull { !it.loopDetected }?.accumulator ?: throw RuntimeException("No solution found")


    private fun execute(input: List<String>): ExecutionResult {
        var i = 0
        var acc = 0
        val visitedCommands = mutableSetOf<Int>()

        while (i !in visitedCommands && i in input.indices) {
            var nextCommand = i + 1
            val command = input[i].split(" ").let { it[0] to it[1].toInt() }
            when (command.first) {
                "acc" -> acc += command.second
                "jmp" -> nextCommand = i + command.second
            }

            visitedCommands += i
            i = nextCommand
        }

        return ExecutionResult(i in input.indices, acc)
    }

    private data class ExecutionResult(val loopDetected: Boolean, val accumulator: Int)
}
