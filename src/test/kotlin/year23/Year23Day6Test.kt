package year23

import core.DayTest

private val defaultInput = """
    Time:      7  15   30
    Distance:  9  40  200
""".trimIndent()

class Year23Day6Test : DayTest<List<String>, Long, Long>(
    Year23Day6::class.java,
    listOf(
        defaultInput to 288
    ),
    listOf(
        defaultInput to 71503
    )
)
