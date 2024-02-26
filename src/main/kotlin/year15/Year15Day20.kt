package year15

import core.Day

class Year15Day20 : Day<Int>(::prepareInput) {

    private companion object {
        private fun prepareInput(input: String): Int = input.replace("\n", "").toInt()
    }

    override fun part1(input: Int): Int = solve(input, { _, _ -> true }) { n -> 10 * n }

    override fun part2(input: Int): Int = solve(input, { j, i -> j < 51 * i }) { n -> 11 * n }

    private fun solve(
        input: Int,
        distributionBoundaryFunction: (Int, Int) -> Boolean,
        distributionAmountFunction: (Int) -> Int
    ) = with(IntArray(1000000) { 0 }) {
        for (i in 1 until this.size) {
            var j = i
            while (distributionBoundaryFunction(j, i) && j in this.indices) {
                this[j] += distributionAmountFunction(i)
                j += i
            }
        }

        this.indexOfFirst { it > input }
    }
}
