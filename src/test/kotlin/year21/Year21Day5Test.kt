package year21

import core.DayTest

private val defaultInput = """
    0,9 -> 5,9
    8,0 -> 0,8
    9,4 -> 3,4
    2,2 -> 2,1
    7,0 -> 7,4
    6,4 -> 2,0
    0,9 -> 2,9
    3,4 -> 1,4
    0,0 -> 8,8
    5,5 -> 8,2
""".trimIndent()

class Year21Day5Test : DayTest<List<String>, Int, Int>(
    Year21Day5::class.java,
    listOf(
        defaultInput to 5
    ),
    listOf(
        defaultInput to 12
    )
)
