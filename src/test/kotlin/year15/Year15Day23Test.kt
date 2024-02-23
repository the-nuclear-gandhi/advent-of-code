package year15

import core.DayTest

private val defaultInput = """
    inc b
    jio b, +2
    tpl b
    inc b
""".trimIndent()

class Year15Day23Test : DayTest<List<String>, Long, Long>(
    Year15Day23::class.java,
    listOf(
        defaultInput to 2
    ),
    listOf(
        "inc b\n$defaultInput" to 7
    )
)
