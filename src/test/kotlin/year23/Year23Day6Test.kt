package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year23Day6Test {

    val year23Day6 = Year23Day6()
    val input = listOf(
        "Time:      7  15   30",
        "Distance:  9  40  200"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 288`() {
            assertEquals(288, year23Day6.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 71503`() {
            assertEquals(71503, year23Day6.part2(input))
        }
    }
}
