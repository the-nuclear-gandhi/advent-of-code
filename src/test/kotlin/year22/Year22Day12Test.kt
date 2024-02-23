package year22

import core.DayTest

private val defaultInput = """
    Sabqponm
    abcryxxl
    accszExk
    acctuvwj
    abdefghi
""".trimIndent()

class Year22Day12Test : DayTest<List<String>, Int, Int>(
    Year22Day12::class.java,
    listOf(
        defaultInput to 31
    ),
    listOf(
        defaultInput to 29
    )
)
