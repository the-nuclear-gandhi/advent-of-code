package year24

import core.DayTest
import shared.LineBlock

class Year24Day5Test : DayTest<List<LineBlock>, Int, Int>(
    Year24Day5::class.java,
    listOf(
        defaultInput to 143
    ),
    listOf(
        defaultInput to 123
    )
)

private val defaultInput = """
    47|53
    97|13
    97|61
    97|47
    75|29
    61|13
    75|53
    29|13
    97|29
    53|29
    61|53
    97|53
    61|29
    47|13
    75|47
    97|75
    47|61
    75|61
    47|29
    75|13
    53|13

    75,47,61,53,29
    97,61,53,29,13
    75,29,13
    75,97,47,61,53
    61,13,29
    97,13,75,29,47
""".trimIndent()
