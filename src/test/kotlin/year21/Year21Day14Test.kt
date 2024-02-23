package year21

import core.DayTest

private val defaultInput = """
    NNCB

    CH -> B
    HH -> N
    CB -> H
    NH -> C
    HB -> C
    HC -> B
    HN -> C
    NN -> C
    BH -> H
    NC -> B
    NB -> B
    BN -> B
    BB -> N
    BC -> B
    CC -> N
    CN -> C
""".trimIndent()

class Year21Day14Test : DayTest<List<String>, Long, Long>(
    Year21Day14::class.java,
    listOf(
        defaultInput to 1588
    ),
    listOf(
        defaultInput to 2_188_189_693_529
    )
)
