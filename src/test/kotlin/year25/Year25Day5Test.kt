package year25

import core.DayTest
import shared.LineBlock

private val defaultInput = """
    3-5
    10-14
    16-20
    12-18
    
    1
    5
    8
    11
    17
    32
""".trimIndent()

class Year25Day5Test : DayTest<List<LineBlock>, Int, Long>(
    Year25Day5::class.java,
    listOf(
        defaultInput to 3
    ),
    listOf(
        defaultInput to 14
    )
)
