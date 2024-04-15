package year15

import core.DayTest

private val defaultInput = """
    Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.
    Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.
""".trimIndent()

class Year15Day14Test : DayTest<List<String>, Int, Int>(
    Year15Day14::class.java,
    listOf(
        defaultInput to 1120
    ),
    listOf(
        defaultInput to 689
    ),
    1000
)
