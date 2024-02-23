package year15

import core.DayTest

private const val defaultInput = "abcdefgh"

class Year15Day11Test : DayTest<String, String, String>(
    Year15Day11::class.java,
    listOf(
        defaultInput to "abcdffaa",
        "ghijklmn" to "ghjaabcc"
    ),
    listOf(
        defaultInput to "abcdffbb"
    )
)
