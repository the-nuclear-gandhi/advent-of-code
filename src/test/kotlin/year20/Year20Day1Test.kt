package year20

import core.DayTest

private val defaultInput = """
    1721
    979
    366
    299
    675
    1456
""".trimIndent()

private val noSolutionInput = """
    1234
    5678
    9101
""".trimIndent()

class Year20Day1Test : DayTest<List<Int>, Int, Int>(
    Year20Day1::class.java,
    listOf(
        defaultInput to 514579,
        noSolutionInput to 0
    ),
    listOf(
        defaultInput to 241861950,
        noSolutionInput to 0
    )
)
