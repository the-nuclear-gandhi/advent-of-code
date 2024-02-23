package year15

import core.DayTest

private val defaultInput = """
    Sue 1: akitas: 8, cats: 10, perfumes: 8
    Sue 2: goldfish: 0, vizslas: 0, samoyeds: 2
    Sue 3: akitas: 0, perfumes: 2, pomeranians: 10
    Sue 4: samoyeds: 9, pomeranians: 7, perfumes: 6
    Sue 5: pomeranians: 3, perfumes: 1, vizslas: 0
""".trimIndent()

class Year15Day16Test : DayTest<List<String>, Int, Int>(
    Year15Day16::class.java,
    listOf(
        defaultInput to 5
    ),
    listOf(
        defaultInput to 2
    )
)
