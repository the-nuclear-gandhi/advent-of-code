package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year15Day8Test {

    val year15Day8 = Year15Day8()
    val input = listOf("\"\"", "\"abc\"", "\"aaa\\\"aaa\"", "\"\\x27\"")

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 12`() {
            assertEquals(12, year15Day8.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 19`() {
            assertEquals(19, year15Day8.part2(input))
        }
    }

}
