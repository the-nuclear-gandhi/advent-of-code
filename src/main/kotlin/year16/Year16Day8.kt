package year16

import core.Day
import core.InputConverter.Companion.toLines
import shared.toIntList

class Year16Day8 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = executeInstructions(input).run {
        this.sumOf { row -> row.count { it } }
    }

    override fun part2(input: List<String>) = executeInstructions(input).run {
        this.forEach { row ->
            row.forEach {
                if (it) print("#") else print(".")
            }
            println()
        }
    }

    private fun executeInstructions(input: List<String>): Array<BooleanArray> =
        Array(6) { BooleanArray(50) }.apply {
            input.forEach {
                when {
                    it.contains("row") -> {
                        val parameters = extractRowOrColumnParameters(it)
                        val newRow = shift(this[parameters.first], parameters.second)
                        this[parameters.first] = newRow
                    }

                    it.contains("column") -> {
                        val parameters = extractRowOrColumnParameters(it)
                        val newColumn =
                            shift(this.map { row -> row[parameters.first] }.toBooleanArray(), parameters.second)
                        this.indices.forEach { i ->
                            this[i][parameters.first] = newColumn[i]
                        }
                    }

                    else -> {
                        val parameters = it.split(" ")
                            .last()
                            .toIntList("x")
                            .run { first() to last() }

                        (0..<parameters.second).map { x ->
                            (0..<parameters.first).map { y ->
                                this[x][y] = true
                            }
                        }
                    }
                }
            }
        }

    private fun extractRowOrColumnParameters(input: String): Pair<Int, Int> = input.substringAfter("=")
        .toIntList(" by ")
        .run { first() to last() }

    private fun shift(array: BooleanArray, value: Int): BooleanArray {
        val arraySize = array.size
        val newArray = BooleanArray(arraySize)

        array.indices.forEach { i ->
            val newIndex = i + value
            val index = if (newIndex < 0) {
                arraySize + newIndex + 1
            } else {
                newIndex % arraySize
            }

            newArray[index] = array[i]
        }

        return newArray
    }
}
