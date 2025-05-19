package year16

import core.DayTest

class Year16Day5Test : DayTest<String, String, String>(
    Year16Day5(parallelThreads = 2, max = 15_000_000),
    listOf(
        "abc" to "18f47a30"
    ),
    listOf(
        "abc" to "05ace8e3"
    )
)
