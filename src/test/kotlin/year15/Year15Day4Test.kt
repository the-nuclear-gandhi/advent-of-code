package year15

import core.DayTest

class Year15Day4Test : DayTest<String, Long, Long>(
    Year15Day4::class.java,
    listOf(
        "abcdef" to 609043,
        "pqrstuv" to 1048970
    ),
    listOf()
)
