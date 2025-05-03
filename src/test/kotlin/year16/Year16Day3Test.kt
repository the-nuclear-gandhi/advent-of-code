package year16

import core.DayTest

private val defaultInput = """
    5 10 25
    3 4 5
    6 8 17
    1 2 3
    25 35 45
    7 8 12
""".trimIndent()

class Year16Day3Test : DayTest<List<String>, Int, Int>(
    Year16Day3::class.java,
    listOf(
        defaultInput to 3
    ),
    listOf(
        defaultInput to 2
    )
)
