package year21

import core.DayTest

private const val defaultInput = "3,4,3,1,2"

class Year21Day6Test : DayTest<String, Long, Long>(
    Year21Day6::class.java,
    listOf(
        defaultInput to 5934
    ),
    listOf(
        defaultInput to 26_984_457_539
    )
)
