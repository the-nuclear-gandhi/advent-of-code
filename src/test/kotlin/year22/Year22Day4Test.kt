package year22

import core.DayTest

private val defaultInput = """
    2-4,6-8
    2-3,4-5
    5-7,7-9
    2-8,3-7
    6-6,4-6
    2-6,4-8
""".trimIndent()

class Year22Day4Test : DayTest<List<String>, Int, Int>(
    Year22Day4::class.java,
    listOf(
        defaultInput to 2
    ),
    listOf(
        defaultInput to 4
    )
)
