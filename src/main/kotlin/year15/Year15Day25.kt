package year15

import core.Day
import core.InputConverter.Companion.noOp

class Year15Day25 : Day<String>(::noOp) {

    override fun part1(input: String): Long {
        val targetRow = input.substringAfter("row").substringBefore(",").trim().toInt()
        val targetColumn = input.substringAfter("column").substringBefore(".").trim().toInt()

        var number = 20151125L
        var row = 1
        var rowLength = 2
        var target = 0L
        while (target == 0L) {
            for (y in 0 until rowLength) {
                number *= 252533
                number %= 33554393
                if (row - y == targetRow - 1 && y == targetColumn - 1) {
                    target = number
                }
            }
            row++
            rowLength++
        }

        return target
    }

    override fun part2(input: String) = Unit
}
