package year23

import core.Day
import core.InputConverter.Companion.toLines
import shared.toIntList

class Year23Day9 : Day<List<String>>(::toLines) {
    override fun part1(input: List<String>): Int = solve(input, ::followingNumber)

    override fun part2(input: List<String>): Int = solve(input, ::precedingNumber)

    private fun solve(input: List<String>, transformerFunction: (List<Int>) -> Int): Int =
        input.map { it.toIntList() }.sumOf { transformerFunction(it) }

    private fun followingNumber(list: List<Int>): Int = list.last() +
        if (list.hasAllSameElements()) {
            0
        } else {
            followingNumber(list.differences())
        }

    private fun precedingNumber(list: List<Int>): Int = list.first() -
        if (list.hasAllSameElements()) {
            0
        } else {
            precedingNumber(list.differences())
        }

    private fun List<Int>.hasAllSameElements(): Boolean = this.toSet().size == 1
    private fun List<Int>.differences(): List<Int> = this.zipWithNext { a, b -> b - a }
}
