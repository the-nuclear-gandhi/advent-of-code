package year16

import core.DayTest

private val defaultInput = """
    rect 3x2
    rotate column x=1 by 1
    rotate row y=0 by 4
    rotate column x=1 by 1
""".trimIndent()

class Year16Day8Test : DayTest<List<String>, Int, Unit>(
    Year16Day8::class.java,
    listOf(
        defaultInput to 6
    ),
    listOf()
)
