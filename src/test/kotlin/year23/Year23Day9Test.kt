package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year23Day9Test {

    val year23Day9 = Year23Day9()
    val input = listOf(
        "0 3 6 9 12 15",
        "1 3 6 10 15 21",
        "10 13 16 21 30 45"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 114`() {
            assertEquals(114, year23Day9.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 2`() {
            assertEquals(2, year23Day9.part2(input))
        }
    }
}
