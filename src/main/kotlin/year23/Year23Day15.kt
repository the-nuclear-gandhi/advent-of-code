package year23

import core.Day
import core.InputConverter.Companion.noOp

class Year23Day15 : Day<String>(::noOp) {
    override fun part1(input: String): Int =
        input.replace("\n", "").split(",")
            .sumOf { hash(it) }

    override fun part2(input: String): Int = mutableMapOf<Int, MutableList<String>>().let { boxes ->
        input.replace("\n", "").split(",")
            .map {
                val label = it.takeWhile { c -> c.isLowerCase() }
                val box = hash(label)
                val operation = it[label.length]

                when (operation) {
                    '-' -> boxes.computeIfPresent(box) { _, list ->
                        list.apply { this.removeIf { s -> s.startsWith(label) } }
                    }

                    '=' -> {
                        val element = "$label ${it.last().digitToInt()}"
                        boxes.compute(box) { _, list ->
                            list?.apply {
                                val existingItemIndex = list.indexOfFirst { s -> s.startsWith(label) }
                                if (existingItemIndex > -1) {
                                    this[existingItemIndex] = element
                                } else {
                                    this += element
                                }
                            } ?: mutableListOf(element)
                        }
                    }

                    else -> throw RuntimeException("Unsupported operation")
                }
            }

        boxes
    }
        .filter { it.value.isNotEmpty() }
        .map { (k, v) -> v.mapIndexed { index, s -> (k + 1) * (index + 1) * s.last().digitToInt() }.sum() }
        .sum()


    private fun hash(s: String): Int = s.chars().reduce(0) { acc, c -> (acc + c) * 17 % 256 }
}
