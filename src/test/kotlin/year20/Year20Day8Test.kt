package year20

import core.DayTest

private val defaultInput = """
    nop +0
    acc +1
    jmp +4
    acc +3
    jmp -3
    acc -99
    acc +1
    jmp -4
    acc +6
""".trimIndent()

class Year20Day8Test : DayTest<List<String>, Int, Int>(
    Year20Day8::class.java,
    listOf(
        defaultInput to 5
    ),
    listOf(
        defaultInput to 8
    )
)
