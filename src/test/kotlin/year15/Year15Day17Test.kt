package year15

import core.DayTest

private val defaultInput = """
    20
    15
    10
    5
    5
""".trimIndent()

class Year15Day17Test : DayTest<List<Int>, Int, Int>(
    Year15Day17(25),
    listOf(
        defaultInput to 4
    ),
    listOf(
        defaultInput to 3
    )
)
