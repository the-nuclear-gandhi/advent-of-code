package year21

import core.DayTest

private val defaultInput = """
    2199943210
    3987894921
    9856789892
    8767896789
    9899965678
""".trimIndent()

class Year21Day9Test : DayTest<List<String>, Int, Long>(
    Year21Day9::class.java,
    listOf(
        defaultInput to 15
    ),
    listOf(
        defaultInput to 1134
    )
)
