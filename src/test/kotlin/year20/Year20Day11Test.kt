package year20

import core.DayTest

private val defaultInput = """
    L.LL.LL.LL
    LLLLLLL.LL
    L.L.L..L..
    LLLL.LL.LL
    L.LL.LL.LL
    L.LLLLL.LL
    ..L.L.....
    LLLLLLLLLL
    L.LLLLLL.L
    L.LLLLL.LL
""".trimIndent()

class Year20Day11Test : DayTest<List<String>, Int, Int>(
    Year20Day11::class.java,
    listOf(
        defaultInput to 37
    ),
    listOf(
        defaultInput to 26
    )
)
