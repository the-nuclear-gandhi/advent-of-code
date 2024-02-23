package year15

import core.DayTest

private val defaultInput = """
    ""
    "abc"
    "aaa\"aaa"
    "\x27"
""".trimIndent()

class Year15Day8Test : DayTest<List<String>, Int, Int>(
    Year15Day8::class.java,
    listOf(
        defaultInput to 12
    ),
    listOf(
        defaultInput to 19
    )
)
