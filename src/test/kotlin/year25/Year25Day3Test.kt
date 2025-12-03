package year25

import core.DayTest

private val defaultInput = """
    987654321111111
    811111111111119
    234234234234278
    818181911112111
""".trimIndent()

class Year25Day3Test : DayTest<List<String>, Int, Long>(
    Year25Day3::class.java,
    listOf(
        defaultInput to 357
    ),
    listOf(
        defaultInput to 3_121_910_778_619
    )
)
