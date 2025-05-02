package year16

import core.DayTest

private val defaultInput = """
    ULL
    RRDDD
    LURDL
    UUUUD
""".trimIndent()

class Year16Day2Test : DayTest<List<String>, String, String>(
    Year16Day2::class.java,
    listOf(
        defaultInput to "1985"
    ),
    listOf(
        defaultInput to "5DB3"
    )
)
