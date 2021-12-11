package year21

import shared.Day

class Year21Day6 : Day<String>() {
    override fun getInput(): String = inputResource().asString().replace("\n", "")

    override fun part1(input: String): Long = simulateLanternFishPopulation(input, 80)

    override fun part2(input: String): Long = simulateLanternFishPopulation(input, 256)

    private fun simulateLanternFishPopulation(input: String, days: Int): Long = input.split(",")
        .map { it.toInt() }
        .let { fish -> LongArray(9) { fish.count { n -> n == it }.toLong() } }
        .apply {
            repeat(days) {
                this[(it + 7) % 9] += this[it % 9]
            }
        }
        .sum()
}
