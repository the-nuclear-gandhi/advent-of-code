package year15

import core.DayTest

class Year15Day4Test : DayTest<String, Int, Int>(
    Year15Day4(parallelThreads = 2, max = 7_000_000),
    listOf(
        "abcdef" to 609043,
        "pqrstuv" to 1048970
    ),
    listOf()
)
