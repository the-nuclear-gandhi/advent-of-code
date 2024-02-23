package year22

import core.DayTest
import shared.LineBlock

private val defaultInput = """
    [1,1,3,1,1]
    [1,1,5,1,1]

    [[1],[2,3,4]]
    [[1],4]

    [9]
    [[8,7,6]]

    [[4,4],4,4]
    [[4,4],4,4,4]

    [7,7,7,7]
    [7,7,7]

    []
    [3]

    [[[]]]
    [[]]

    [1,[2,[3,[4,[5,6,7]]]],8,9]
    [1,[2,[3,[4,[5,6,0]]]],8,9]
""".trimIndent()

class Year22Day13Test : DayTest<List<LineBlock>, Int, Int>(
    Year22Day13::class.java,
    listOf(
        defaultInput to 13
    ),
    listOf(
        defaultInput to 140
    )
)
