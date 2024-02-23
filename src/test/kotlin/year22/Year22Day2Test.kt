package year22

import core.DayTest

private val defaultInput = """
    A Y
    B X
    C Z
""".trimIndent()

class Year22Day2Test : DayTest<List<String>, Int, Int>(
    Year22Day2::class.java,
    listOf(
        defaultInput to 15
    ),
    listOf(
        defaultInput to 12
    )
)
