package year23

import core.DayTest
import shared.LineBlock

private val defaultInput = """
    #.##..##.
    ..#.##.#.
    ##......#
    ##......#
    ..#.##.#.
    ..##..##.
    #.#.##.#.

    #...##..#
    #....#..#
    ..##..###
    #####.##.
    #####.##.
    ..##..###
    #....#..#
""".trimIndent()

class Year23Day13Test : DayTest<List<LineBlock>, Int, Int>(
    Year23Day13::class.java,
    listOf(
        defaultInput to 405
    ),
    listOf(
        defaultInput to 400
    )
)
