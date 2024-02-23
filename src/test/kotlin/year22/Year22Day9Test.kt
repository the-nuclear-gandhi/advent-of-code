package year22

import core.DayTest

private val defaultInput = """
    R 4
    U 4
    L 3
    D 1
    R 4
    D 1
    L 5
    R 2
""".trimIndent()

private val largerInput = """
    R 5
    U 8
    L 8
    D 3
    R 17
    D 10
    L 25
    U 20
""".trimIndent()

class Year22Day9Test : DayTest<List<String>, Int, Int>(
    Year22Day9::class.java,
    listOf(
        defaultInput to 13
    ),
    listOf(
        defaultInput to 1,
        largerInput to 36
    )
)
