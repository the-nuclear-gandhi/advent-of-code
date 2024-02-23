package year23

import core.DayTest

private val defaultInput = """
    .|...\....
    |.-.\.....
    .....|-...
    ........|.
    ..........
    .........\
    ..../.\\..
    .-.-/..|..
    .|....-|.\
    ..//.|....
""".trimIndent()

class Year23Day16Test : DayTest<List<String>, Int, Int>(
    Year23Day16::class.java,
    listOf(
        defaultInput to 46
    ),
    listOf(
        defaultInput to 51
    )
)
