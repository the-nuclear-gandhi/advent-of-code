package year23

import core.DayTest

private val defaultInput = """
    1abc2
    pqr3stu8vwx
    a1b2c3d4e5f
    treb7uchet
""".trimIndent()

private val part2Input = """
    two1nine
    eightwothree
    abcone2threexyz
    xtwone3four
    4nineeightseven2
    zoneight234
    7pqrstsixteen
""".trimIndent()

class Year23Day1Test : DayTest<List<String>, Int, Int>(
    Year23Day1::class.java,
    listOf(
        defaultInput to 142
    ),
    listOf(
        part2Input to 281
    )
)
