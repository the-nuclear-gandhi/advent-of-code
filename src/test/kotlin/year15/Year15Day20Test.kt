package year15

import core.DayTest

private const val defaultInput = "1000"

class Year15Day20Test : DayTest<Int, Int, Int>(
    Year15Day20::class.java,
    listOf(
        defaultInput to 48
    ),
    listOf(
        defaultInput to 36
    )
)
