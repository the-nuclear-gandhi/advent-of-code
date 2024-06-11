package year20

import core.DayTest

private val defaultInput = """
    1-3 a: abcde
    1-3 b: cdefg
    2-9 c: ccccccccc
""".trimIndent()

class Year20Day2Test : DayTest<List<String>, Int, Int>(
    Year20Day2::class.java,
    listOf(
        defaultInput to 2
    ),
    listOf(
        defaultInput to 1
    )
)
