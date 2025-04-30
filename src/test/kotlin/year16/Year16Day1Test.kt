package year16

import core.DayTest

class Year16Day1Test : DayTest<String, Int, Int>(
    Year16Day1::class.java,
    listOf(
        "R2, L3" to 5,
        "R2, R2, R2" to 2,
        "R5, L5, R5, R3" to 12
    ),
    listOf(
        "R8, R4, R4, R8" to 4
    )
)
