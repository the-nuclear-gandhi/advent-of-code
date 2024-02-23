package year15

import core.DayTest

class Year15Day3Test : DayTest<String, Int, Int>(
    Year15Day3::class.java,
    listOf(
        ">" to 2,
        "^v^v^v^v^v" to 2,
        "^>v<" to 4
    ),
    listOf(
        "^v" to 3,
        "^>v<" to 3,
        "^v^v^v^v^v" to 11
    )
)
