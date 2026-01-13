package year16

import core.DayTest

private val defaultInput = """
    cpy 41 a
    inc a
    inc a
    dec a
    jnz a 2
    dec a
""".trimIndent()

class Year16Day12Test : DayTest<List<String>, Int, Int>(
    Year16Day12::class.java,
    listOf(
        defaultInput to 42
    ),
    listOf()
)
