package year22

import core.DayTest

private val defaultInput = """
    vJrwpWtwJgWrhcsFMMfFFhFp
    jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
    PmmdzqPrVvPwwTWBwg
    wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
    ttgJtRGJQctTZtZT
    CrZsJsPPZsGzwwsLwLmpwMDw
""".trimIndent()

class Year22Day3Test : DayTest<List<String>, Int, Int>(
    Year22Day3::class.java,
    listOf(
        defaultInput to 157
    ),
    listOf(
        defaultInput to 70
    )
)
