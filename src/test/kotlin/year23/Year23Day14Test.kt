package year23

import core.DayTest

private val defaultInput = """
    O....#....
    O.OO#....#
    .....##...
    OO.#O....O
    .O.....O#.
    O.#..O.#.#
    ..O..#O..O
    .......O..
    #....###..
    #OO..#....
""".trimIndent()

class Year23Day14Test : DayTest<List<String>, Int, Int>(
    Year23Day14::class.java,
    listOf(
        defaultInput to 136
    ),
    listOf(
        defaultInput to 64
    )
)
