package year15

import core.DayTest

private val defaultInput = """
    H => HO
    H => OH
    O => HH
    HOH
""".trimIndent()

private val secondInput = """
    H => HO
    H => OH
    O => HH
    HOHOHO
""".trimIndent()

private val defaultPart2Input = """
    e => H
    e => O
    H => HO
    H => OH
    O => HH
    HOH
""".trimIndent()

private val secondPart2Input = """
    e => H
    e => O
    H => HO
    H => OH
    O => HH
    HOHOHO
""".trimIndent()

class Year15Day19Test : DayTest<List<String>, Int, Int>(
    Year15Day19::class.java,
    listOf(
        defaultInput to 4,
        secondInput to 7
    ),
    listOf(
        defaultPart2Input to 3,
        secondPart2Input to 6
    )
)
