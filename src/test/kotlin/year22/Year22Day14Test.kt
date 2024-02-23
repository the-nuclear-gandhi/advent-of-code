package year22

import core.DayTest

private val defaultInput = """
    498,4 -> 498,6 -> 496,6
    503,4 -> 502,4 -> 502,9 -> 494,9
""".trimIndent()

class Year22Day14Test : DayTest<List<String>, Int, Int>(
    Year22Day14::class.java,
    listOf(
        defaultInput to 24
    ),
    listOf(
        defaultInput to 93
    )
)
