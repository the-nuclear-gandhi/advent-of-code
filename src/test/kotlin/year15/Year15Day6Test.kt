package year15

import core.DayTest

class Year15Day6Test : DayTest<List<String>, Int, Long>(
    Year15Day6::class.java,
    listOf(
        "" to 0,
        "turn on 0,0 through 2,2" to 9,
        "toggle 499,499 through 500,500" to 4,
        """
            turn on 0,0 through 2,2
            toggle 499,499 through 500,500
        """.trimIndent() to 13
    ),
    listOf(
        "turn on 0,0 through 0,0" to 1,
        "toggle 0,0 through 999,999" to 2000000
    )
)
