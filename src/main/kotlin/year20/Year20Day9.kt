package year20

import core.Day
import core.InputConverter.Companion.toLines

class Year20Day9(private val preambleLength: Int = 25) : Day<List<Long>>(::prepareInput) {

    private companion object {
        private fun prepareInput(input: String): List<Long> = toLines(input).map { it.toLong() }
    }

    override fun part1(input: List<Long>): Long = findInvalidNumber(input)

    override fun part2(input: List<Long>): Long = with(findInvalidNumber(input)) {
        input.indices.firstNotNullOf { index ->
            var endIndex = index + 1
            var items = input.subList(index, endIndex)
            while (items.sum() < this) {
                endIndex++
                items = input.subList(index, endIndex)
            }

            items.takeIf { it.sum() == this }
        }
            .let { it.min() + it.max() }
    }

    private fun findInvalidNumber(input: List<Long>): Long = input.windowed(preambleLength + 1)
        .firstNotNullOf { list ->
            val target = list.last()
            val numbers = list - target

            target.takeIf { numbers.none { target - it != it && (target - it) in numbers } }
        }
}
