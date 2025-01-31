package year24

import core.DayTest

private val defaultInput = """
    MMMSXXMASM
    MSAMXMSMSA
    AMXSXMAAMM
    MSAMASMSMX
    XMASAMXAMM
    XXAMMXXAMA
    SMSMSASXSS
    SAXAMASAAA
    MAMMMXMMMM
    MXMXAXMASX
""".trimIndent()

class Year24Day4Test : DayTest<List<String>, Int, Int>(
    Year24Day4::class.java,
    listOf(
        defaultInput to 18
    ),
    listOf(
        defaultInput to 9
    )
)
