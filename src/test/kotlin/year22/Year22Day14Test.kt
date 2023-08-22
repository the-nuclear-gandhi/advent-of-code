package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year22Day14Test {

    val year22Day14 = Year22Day14()
    val input = listOf(
        "498,4 -> 498,6 -> 496,6",
        "503,4 -> 502,4 -> 502,9 -> 494,9"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 24`() {
            assertEquals(24, year22Day14.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 93`() {
            assertEquals(93, year22Day14.part2(input))
        }
    }
}
