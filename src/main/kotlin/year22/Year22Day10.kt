package year22

import core.Day
import core.InputConverter.Companion.toLines

class Year22Day10 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = with(Device()) {
        val inputIterator = input.iterator()
        while (this.cycles < 220) {
            this.runCommand(inputIterator.next())
        }

        this.signalLevels.sum()
    }

    override fun part2(input: List<String>): String = with(Device()) {
        input.forEach { this.runCommand(it) }
            .let { this.crt }
            .also { crt -> crt.chunked(40).forEach { println(it) } }
    }

    private class Device {
        private var x = 1

        var cycles = 0
        var signalLevels = mutableListOf<Int>()
        var crt = ""

        fun runCommand(command: String) = when {
            command.startsWith("noop") -> runCycle()
            command.startsWith("addx") -> {
                repeat(2) {
                    runCycle()
                }
                x += command.substringAfter(" ").toInt()
            }

            else -> println("Unsupported command: $command")
        }

        private fun runCycle() {
            crt += drawPixel(cycles, x)
            cycles++
            if (cycles % 40 == 20) {
                signalLevels += x * cycles
            }
        }

        private fun drawPixel(cycle: Int, x: Int): String = if (cycle % 40 in x - 1..x + 1) {
            "#"
        } else {
            "."
        }
    }
}
