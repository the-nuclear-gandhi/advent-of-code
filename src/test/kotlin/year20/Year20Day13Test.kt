package year20

import core.DayTest

private val defaultInput = """
    939
    7,13,x,x,59,x,31,19
""".trimIndent()

class Year20Day13Test : DayTest<List<String>, Int, Long>(
    Year20Day13::class.java,
    listOf(
        defaultInput to 295
    ),
    listOf(
        defaultInput to 1068781
    )
)
