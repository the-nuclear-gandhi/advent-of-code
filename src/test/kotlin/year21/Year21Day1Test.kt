package year21

import core.DayTest

private val defaultInput = """
    199
    200
    208
    210
    200
    207
    240
    269
    260
    263
""".trimIndent()

class Year21Day1Test : DayTest<List<Int>, Int, Int>(
    Year21Day1::class.java,
    listOf(
        defaultInput to 7
    ),
    listOf(
        defaultInput to 5
    )
)
