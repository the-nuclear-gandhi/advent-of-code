package year20

import core.DayTest

private val defaultInput = """
    ..##.......
    #...#...#..
    .#....#..#.
    ..#.#...#.#
    .#...##..#.
    ..#.##.....
    .#.#.#....#
    .#........#
    #.##...#...
    #...##....#
    .#..#...#.#
""".trimIndent()

class Year20Day3Test : DayTest<List<String>, Int, Long>(
    Year20Day3::class.java,
    listOf(defaultInput to 7),
    listOf(defaultInput to 336)
)
