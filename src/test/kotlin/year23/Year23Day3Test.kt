package year23

import core.DayTest

private val defaultInput = """
    467..114..
    ...*......
    ..35..633.
    ......#...
    617*......
    .....+.58.
    ..592.....
    ......755.
    ...${'$'}.*....
    .664.598..

""".trimIndent()

class Year23Day3Test : DayTest<List<String>, Int, Int>(
    Year23Day3::class.java,
    listOf(
        defaultInput to 4361
    ),
    listOf(
        defaultInput to 467835
    )
)
