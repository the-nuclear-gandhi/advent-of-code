package year25

import core.DayTest

private val defaultInput = """
    ..@@.@@@@.
    @@@.@.@.@@
    @@@@@.@.@@
    @.@@@@..@.
    @@.@@@@.@@
    .@@@@@@@.@
    .@.@.@.@@@
    @.@@@.@@@@
    .@@@@@@@@.
    @.@.@@@.@.
""".trimIndent()

class Year25Day4Test : DayTest<List<String>, Int, Int>(
    Year25Day4::class.java,
    listOf(
        defaultInput to 13
    ),
    listOf(
        defaultInput to 43
    )
)
