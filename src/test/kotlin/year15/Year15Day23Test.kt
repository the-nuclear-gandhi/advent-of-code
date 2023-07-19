package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year15Day23Test {

    val year15Day23 = Year15Day23()
    val input = listOf(
        "inc b",
        "jio b, +2",
        "tpl b",
        "inc b",
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 2`() {
            assertEquals(2, year15Day23.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 7`() {
            val modifiedInput = mutableListOf("inc b") + input
            assertEquals(7, year15Day23.part2(modifiedInput))
        }
    }
}
