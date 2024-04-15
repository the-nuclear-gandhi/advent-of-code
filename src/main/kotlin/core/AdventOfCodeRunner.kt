package core

import com.github.ajalt.clikt.core.ProgramResult
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

class AdventOfCodeRunner(private val year: Int, private val day: Int, private val inputPath: Path) {
    private val log: Logger = LoggerFactory.getLogger(javaClass.simpleName)

    private companion object {
        private const val welcome = "Welcome to the Advent of Code CLI!"
        private const val solving = "Solving the Advent of Code puzzle for year {}, day {}"
        private const val loadedSolutionClass = "Loaded solution class"
        private const val usingInput = "Using input file at {}"

        private const val errorClassNotFound = "Solution class for year {}, day {} not found, please try another problem"
        private const val errorCouldNotLoadInput = "Could not load program input: {}"
    }

    fun run() = runCatching {
        log.info(welcome)
        log.info(solving, year, day)

        val solutionClass = loadSolutionClass(year, day)
        val solution = solutionClass.getDeclaredConstructor().newInstance() as Day<*>
        val input = loadInput(inputPath)

        solution.solve(input)
    }.onFailure {
        when (it) {
            is ClassNotFoundException -> log.error(errorClassNotFound, year, day)
            is IOException -> log.error(errorCouldNotLoadInput, it.message)
            else -> log.error(it.message)
        }
    }.let {
        if (it.isFailure) {
            throw ProgramResult(1)
        }
    }

    private fun loadSolutionClass(year: Int, day: Int): Class<*> = (year % 2000).let {
        val solutionClass = Class.forName("year${it}.Year${it}Day${day}")
        require(Day::class.java.isAssignableFrom(solutionClass)) { "Solution class not assignable to Day" }
        solutionClass
    }.also { log.info(loadedSolutionClass) }

    private fun loadInput(inputPath: Path): String = Files.readString(inputPath)
        .also { log.info(usingInput, inputPath) }

}
