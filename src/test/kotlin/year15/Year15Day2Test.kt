package year15

import core.DayTest

private const val defaultInput = "2x3x4"
private const val secondInput = "1x1x10"

class Year15Day2Test : DayTest<List<String>, Long, Long>(
    Year15Day2::class.java,
    listOf(
        defaultInput to 58,
        secondInput to 43
    ),
    listOf(
        defaultInput to 34,
        secondInput to 14
    )
)
