package year21

import core.DayTest

private val defaultInput = """
    6,10
    0,14
    9,10
    0,3
    10,4
    4,11
    6,0
    6,12
    4,1
    0,13
    10,12
    3,4
    3,0
    8,4
    1,10
    2,14
    8,10
    9,0

    fold along y=7
    fold along x=5
""".trimIndent()

class Year21Day13Test : DayTest<List<String>, Int, Unit>(
    Year21Day13::class.java,
    listOf(
        defaultInput to 17
    ),
    listOf()
)
