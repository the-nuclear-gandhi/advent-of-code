package year20

import core.DayTest

private val defaultInput = """
    FBFBBFFRLR
    BFFFBBFRRR
    FFFBBBFRRR
    BBFFBBFRLL
""".trimIndent()

class Year20Day5Test : DayTest<List<String>, Int, Int>(
    Year20Day5::class.java,
    listOf(
        defaultInput to 820
    ),
    listOf()
)
