package year20

import core.DayTest

private val defaultInput = """
    35
    20
    15
    25
    47
    40
    62
    55
    65
    95
    102
    117
    150
    182
    127
    219
    299
    277
    309
    576
""".trimIndent()

class Year20Day9Test : DayTest<List<Long>, Long, Long>(
    Year20Day9(5),
    listOf(defaultInput to 127),
    listOf(defaultInput to 62)
)
