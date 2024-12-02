package year24

import core.DayTest

private val defaultInput = """
    7 6 4 2 1
    1 2 7 8 9
    9 7 6 2 1
    1 3 2 4 5
    8 6 4 4 1
    1 3 6 7 9
""".trimIndent()

class Year24Day2Test : DayTest<List<String>, Int, Int>(
    Year24Day2::class.java,
    listOf(defaultInput to 2),
    listOf(defaultInput to 4)
)
