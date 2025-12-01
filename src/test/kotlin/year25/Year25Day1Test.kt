package year25

import core.DayTest

private val defaultInput = """
    L68
    L30
    R48
    L5
    R60
    L55
    L1
    L99
    R14
    L82
""".trimIndent()

class Year25Day1Test : DayTest<List<String>, Int, Int>(
    Year25Day1::class.java,
    listOf(
        defaultInput to 3
    ),
    listOf(
        defaultInput to 6
    )
)
