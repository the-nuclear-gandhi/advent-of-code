package shared

import org.slf4j.LoggerFactory

abstract class Day<INPUT> {
    private val log by lazy {
        LoggerFactory.getLogger(javaClass.simpleName)
    }

    private companion object Messages {
        private const val solving = "Solving Part {}"
    }

    fun solve() {
        val input = getInput()

        log.info(solving, 1)
        printResult(part1(input))
        log.info(solving, 2)
        printResult(part2(input))
    }

    internal abstract fun getInput(): INPUT
    internal abstract fun part1(input: INPUT): Any
    internal abstract fun part2(input: INPUT): Any

    internal fun inputResource(): InputResource {
        val year = javaClass.name.substringAfter("Year").substringBefore("Day")
        val day = javaClass.name.substringAfter("Day")

        return InputResource.forName("year$year/day$day.txt")
    }

    private fun printResult(output: Any): Unit = output.let {
        if (it !is Unit) {
            log.info(it.toString())
        }
    }
}
