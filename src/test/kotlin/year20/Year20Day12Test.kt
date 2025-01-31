package year20

import core.DayTest

private val defaultInput = """
    F10
    N3
    F7
    R90
    F11
""".trimIndent()

class Year20Day12Test : DayTest<List<String>, Int, Int>(
    Year20Day12::class.java,
    listOf(
        defaultInput to 25
    ),
    listOf(
        defaultInput to 286
    )
)
