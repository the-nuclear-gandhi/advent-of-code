package year22

import core.Day
import core.InputConverter.Companion.toLineBlocks
import shared.LineBlock

class Year22Day11 : Day<List<LineBlock>>(::toLineBlocks) {

    override fun part1(input: List<LineBlock>): Long =
        calculateMonkeyBusiness(input.map { createMonkey(it) }, 20) { it / 3 }

    override fun part2(input: List<LineBlock>): Long = input.map { createMonkey(it) }.let { monkeys ->
        val worryLevelTestProduct = monkeys.map { it.test }.reduce(Long::times)
        calculateMonkeyBusiness(monkeys, 10000) { it % worryLevelTestProduct }
    }

    private fun calculateMonkeyBusiness(monkeys: List<Monkey>, rounds: Int, worryLevelModifier: (Long) -> Long): Long =
        repeat(rounds) {
            for (monkey in monkeys) {
                monkey.inspect(worryLevelModifier).map { (id, item) -> monkeys[id].items += item }
            }
        }.let { monkeys.map { it.inspectedItemCount } }
            .sortedDescending()
            .take(2)
            .reduce(Long::times)


    private fun createMonkey(input: List<String>): Monkey {
        val items = input.findFirstBySubstring("items")
            .substringAfter(":")
            .split(",")
            .mapNotNull { it.trim().toLongOrNull() }
            .toMutableList()

        val testDivisor = input.findFirstBySubstring("Test").findNumber().toLong()
        val targetOnTrue = input.findFirstBySubstring("true").findNumber()
        val targetOnFalse = input.findFirstBySubstring("false").findNumber()

        val worryLevel = parseWorryLevelFunction(input.findFirstBySubstring("Operation"))

        return Monkey(items, worryLevel, testDivisor, targetOnTrue, targetOnFalse)
    }

    private fun parseWorryLevelFunction(source: String): (Long) -> Long {
        assert(source.substringAfter(":").substringBefore("=").trim() == "new")

        val tokens = source.substringAfter("=").trim().split(" ")
        val operation: (Long, Long) -> Long = when (tokens[1]) {
            "+" -> Long::plus
            "-" -> Long::minus
            "*" -> Long::times
            "/" -> Long::div
            else -> throw UnsupportedOperationException("Could not parse worry level operation")
        }

        return { w ->
            val firstOperand = tokens.first().toLongOrNull() ?: w
            val secondOperand = tokens.last().toLongOrNull() ?: w
            operation(firstOperand, secondOperand)
        }
    }

    private fun List<String>.findFirstBySubstring(substr: String): String = this.first { it.contains(substr) }
    private fun String.findNumber(): Int = this.split(" ").firstNotNullOf { it.toIntOrNull() }

    private class Monkey(
        val items: MutableList<Long>,
        val worryLevel: (Long) -> Long,
        val test: Long,
        val targetOnTrue: Int,
        val targetOnFalse: Int
    ) {
        var inspectedItemCount = 0L

        fun inspect(worryLevelModifier: (Long) -> Long): List<Pair<Int, Long>> {
            inspectedItemCount += items.size

            val inspectedItems = items.map {
                val newItem = worryLevelModifier(worryLevel(it))
                val target = test(newItem)
                target to newItem
            }
            items.clear()

            return inspectedItems
        }

        private fun test(value: Long): Int = if (value % test == 0L) {
            targetOnTrue
        } else {
            targetOnFalse
        }
    }
}
