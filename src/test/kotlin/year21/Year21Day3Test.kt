package year21

import core.DayTest

private val defaultInput = """
    00100
    11110
    10110
    10111
    10101
    01111
    00111
    11100
    10000
    11001
    00010
    01010
""".trimIndent()

class Year21Day3Test : DayTest<List<String>, Long, Long>(
    Year21Day3::class.java,
    listOf(
        defaultInput to 198
    ),
    listOf(
        defaultInput to 230
    )
)
