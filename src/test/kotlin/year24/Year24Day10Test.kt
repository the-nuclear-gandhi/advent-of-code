package year24

import core.DayTest

private val defaultInput = """
    89010123
    78121874
    87430965
    96549874
    45678903
    32019012
    01329801
    10456732
""".trimIndent()

class Year24Day10Test : DayTest<List<String>, Int, Int>(
    Year24Day10::class.java,
    listOf(
        defaultInput to 36
    ),
    listOf(
        defaultInput to 81
     )
)
