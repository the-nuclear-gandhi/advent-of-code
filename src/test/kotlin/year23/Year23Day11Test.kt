package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year23Day11Test {

    val year23Day11 = Year23Day11()
    val input = listOf(
        "...#......",
        ".......#..",
        "#.........",
        "..........",
        "......#...",
        ".#........",
        ".........#",
        "..........",
        ".......#..",
        "#...#....."
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 374`() {
            assertEquals(374, year23Day11.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 1030`() {
            assertEquals(1030, year23Day11.solve(input, 10))
        }

        @Test
        fun `should return 8410`() {
            assertEquals(8410, year23Day11.solve(input, 100))
        }
    }
}
