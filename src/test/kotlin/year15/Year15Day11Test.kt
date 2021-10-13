package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year15Day11Test {

    val year15Day11 = Year15Day11()

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return abcdffaa`() {
            val input = "abcdefgh"
            assertEquals("abcdffaa", year15Day11.part1(input))
        }

        @Test
        fun `should return ghjaabcc`() {
            val input = "ghijklmn"
            assertEquals("ghjaabcc", year15Day11.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {
        @Test
        fun `should return abcdffbb`() {
            val input = "abcdefgh"
            assertEquals("abcdffbb", year15Day11.part2(input))
        }
    }
}
