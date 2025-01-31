package year24

import core.DayTest

private const val defaultInput = "2333133121414131402"

class Year24Day9Test : DayTest<String, Long, Long>(
    Year24Day9::class.java,
    listOf(
        defaultInput to 1928
    ),
    listOf(
        defaultInput to 2858
    )
)
