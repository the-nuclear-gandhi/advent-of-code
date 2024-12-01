package year24

import core.DayTest

private val defaultInput = """
    3   4
    4   3
    2   5
    1   3
    3   9
    3   3
""".trimIndent()

class Year24Day1Test : DayTest<List<String>, Int, Int>(
    Year24Day1::class.java,
    listOf(defaultInput to 11),
    listOf(defaultInput to 31)
)
