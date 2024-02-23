package year15

import core.DayTest

private val baseInput = """
    123 -> x
    456 -> y
""".trimIndent()

class Year15Day7Test : DayTest<List<String>, Int, Int>(
    Year15Day7::class.java,
    listOf(
        "$baseInput\nx -> a" to 123,
        "$baseInput\nx AND y -> a" to 72,
        "$baseInput\nx LSHIFT 2 -> a" to 492,
        "$baseInput\ny RSHIFT 2 -> a" to 114,
        "$baseInput\nNOT x -> a" to 65412
    ),
    listOf(
        """
            123 -> x
            456 -> b
            b -> y
            x AND y -> a
        """.trimIndent() to 72
    )
)
