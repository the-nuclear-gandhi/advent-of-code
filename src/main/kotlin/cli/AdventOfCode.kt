package cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.check
import com.github.ajalt.clikt.parameters.arguments.optional
import com.github.ajalt.clikt.parameters.types.int
import com.github.ajalt.clikt.parameters.types.path
import com.github.ajalt.clikt.parameters.types.restrictTo
import core.AdventOfCodeRunner
import java.nio.file.Path

class AdventOfCode : CliktCommand() {
    private val year: Int by argument(help = "Advent of Code year")
        .int()
        .restrictTo(2015..2025)
    private val day: Int by argument(help = "Advent of Code day")
        .int()
        .check("day must be between 1 and 25 or between 1 and 12 for year 2025") {
            val availableDays = if (year == 2025) {
                1..12
            } else {
                1..25
            }
            it in availableDays
        }
    private val inputPath: Path? by argument(name = "INPUT", help = "Path to the problem input file")
        .path(mustExist = true)
        .optional()

    override fun run() = AdventOfCodeRunner(year, day, inputPath).run()
}

fun main(args: Array<String>) = AdventOfCode().main(args)
