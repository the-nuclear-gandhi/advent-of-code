package year21

import core.DayTest

private const val defaultInput = "16,1,2,0,4,2,7,1,2,14"

class Year21Day7Test : DayTest<String, Int, Int>(
    Year21Day7::class.java,
    listOf(
        defaultInput to 37
    ),
    listOf(
        defaultInput to 168
    )
)
