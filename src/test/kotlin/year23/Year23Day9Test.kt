package year23

import core.DayTest

private val defaultInput = """
    0 3 6 9 12 15
    1 3 6 10 15 21
    10 13 16 21 30 45
""".trimIndent()

class Year23Day9Test : DayTest<List<String>, Int, Int>(
    Year23Day9::class.java,
    listOf(
        defaultInput to 114
    ),
    listOf(
        defaultInput to 2
    )
)
