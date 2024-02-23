package year21

import core.DayTest

private val defaultInput = """
    forward 5
    down 5
    forward 8
    up 3
    down 8
    forward 2
""".trimIndent()

class Year21Day2Test : DayTest<List<String>, Long, Long>(
    Year21Day2::class.java,
    listOf(
        defaultInput to 150
    ),
    listOf(
        defaultInput to 900
    )
)
