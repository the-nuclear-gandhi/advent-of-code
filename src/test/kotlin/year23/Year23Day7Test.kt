package year23

import core.DayTest

private val defaultInput = """
    32T3K 765
    T55J5 684
    KK677 28
    KTJJT 220
    QQQJA 483
""".trimIndent()

class Year23Day7Test : DayTest<List<String>, Int, Int>(
    Year23Day7::class.java,
    listOf(
        defaultInput to 6440
    ),
    listOf(
        defaultInput to 5905
    )
)
