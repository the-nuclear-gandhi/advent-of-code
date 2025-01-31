package year20

import core.DayTest
import shared.LineBlock

private val defaultInput = """
    abc

    a
    b
    c

    ab
    ac

    a
    a
    a
    a

    b
    
""".trimIndent()

class Year20Day6Test : DayTest<List<LineBlock>, Int, Int>(
    Year20Day6::class.java,
    listOf(
        defaultInput to 11
    ),
    listOf(
        defaultInput to 6
    )
)
