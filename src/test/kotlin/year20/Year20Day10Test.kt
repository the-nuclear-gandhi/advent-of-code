package year20

import core.DayTest

class Year20Day10Test : DayTest<List<Int>, Int, Long>(
    Year20Day10::class.java,
    listOf(
        defaultInput to 35,
        secondInput to 220
    ),
    listOf(
        defaultInput to 8,
        secondInput to 19208
    )
)

private val defaultInput = """
    16
    10
    15
    5
    1
    11
    7
    19
    6
    12
    4
""".trimIndent()

private val secondInput = """
    28
    33
    18
    42
    31
    14
    46
    20
    48
    47
    24
    23
    49
    45
    19
    38
    39
    11
    1
    32
    25
    35
    8
    17
    7
    9
    4
    2
    34
    10
    3
""".trimIndent()
