package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year15Day2Test {

    val year15Day2 = Year15Day2()

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 58`() {
            assertEquals(58, year15Day2.part1(listOf("2x3x4")))
        }

        @Test
        fun `should return 43`() {
            assertEquals(43, year15Day2.part1(listOf("1x1x10")))
        }

    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 34`() {
            assertEquals(34, year15Day2.part2(listOf("2x3x4")))
        }

        @Test
        fun `should return 14`() {
            assertEquals(14, year15Day2.part2(listOf("1x1x10")))
        }

    }
}
