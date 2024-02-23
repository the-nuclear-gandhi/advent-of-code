package year22

import core.DayTest

private val defaultInput = """
    30373
    25512
    65332
    33549
    35390
""".trimIndent()

class Year22Day8Test : DayTest<List<String>, Int, Int>(
    Year22Day8::class.java,
    listOf(
        defaultInput to 21
    ),
    listOf(
        defaultInput to 8
    )
)
