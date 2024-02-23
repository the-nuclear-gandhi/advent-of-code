package year21

import core.DayTest

private val defaultInput = """
    5483143223
    2745854711
    5264556173
    6141336146
    6357385478
    4167524645
    2176841721
    6882881134
    4846848554
    5283751526
""".trimIndent()

class Year21Day11Test : DayTest<List<String>, Int, Int>(
    Year21Day11::class.java,
    listOf(
        defaultInput to 1656
    ),
    listOf(
        defaultInput to 195
    )
)
