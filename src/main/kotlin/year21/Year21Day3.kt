package year21

import shared.Day

class Year21Day3 : Day<List<String>>() {
    override fun getInput(): List<String> = inputResource().asLines()

    override fun part1(input: List<String>): Long {
        val gammaRateString = input[0].indices.mapNotNull {
            input.groupBy { s -> s[it] }.maxByOrNull { entry -> entry.value.size }?.key
        }
            .joinToString("")

        val epsilonRateString =
            Integer.toBinaryString(gammaRateString.toInt(2).inv()).takeLast(gammaRateString.length)

        return gammaRateString.toLong(2) * epsilonRateString.toLong(2)
    }

    override fun part2(input: List<String>): Long {
        val oxygenRating = calculateRating(input, '1') {
            it.maxByOrNull { entry -> entry.value.size }
        }

        val co2Rating = calculateRating(input, '0') {
            it.minByOrNull { entry -> entry.value.size }
        }

        return oxygenRating.toLong(2) * co2Rating.toLong(2)
    }

    private fun calculateRating(
        input: List<String>,
        defaultValue: Char,
        criterion: (Map<Char, List<String>>) -> Map.Entry<Char, List<String>>?
    ): String {
        var ratingList = input
        var index = 0
        while (ratingList.size > 1) {
            val entries = ratingList.groupBy { it[index] }
            val criterionEntry = criterion(entries)
            val firstValue = entries.values.first()
            ratingList = if (entries.all { it.value.size == firstValue.size }) {
                entries[defaultValue] ?: firstValue
            } else {
                criterionEntry?.value ?: ratingList
            }

            index++
        }

        return ratingList[0]
    }
}
