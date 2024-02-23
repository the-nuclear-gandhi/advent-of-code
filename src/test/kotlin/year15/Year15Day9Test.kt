package year15

import core.DayTest

private val defaultInput = """
    London to Dublin = 464
    London to Belfast = 518
    Dublin to Belfast = 141
""".trimIndent()

class Year15Day9Test : DayTest<List<String>, Int, Int>(
    Year15Day9::class.java,
    listOf(
        defaultInput to 605
    ),
    listOf(
        defaultInput to 982
    )
)
