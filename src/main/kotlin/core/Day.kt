package core

import org.slf4j.LoggerFactory

abstract class Day<INPUT>(private val inputConverter: (String) -> INPUT) {
    private val log by lazy {
        LoggerFactory.getLogger(javaClass.simpleName)
    }

    private companion object {
        private const val answer = "Answer for Part {}:"
    }

    fun solve(input: String) = inputConverter(input).let {
        log.info(answer, 1)
        printResult(part1(it))
        log.info(answer, 2)
        printResult(part2(it))
    }

    internal abstract fun part1(input: INPUT): Any
    internal abstract fun part2(input: INPUT): Any

    private fun printResult(output: Any): Unit = output.let {
        if (it !is Unit) {
            log.info(it.toString())
        }
    }
}
