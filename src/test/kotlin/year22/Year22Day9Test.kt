package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year22Day9Test {

    val year22Day9 = Year22Day9()
    val input = listOf(
        "R 4",
        "U 4",
        "L 3",
        "D 1",
        "R 4",
        "D 1",
        "L 5",
        "R 2",
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 13`() {
            assertEquals(13, year22Day9.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        private val largerInput = listOf(
            "R 5",
            "U 8",
            "L 8",
            "D 3",
            "R 17",
            "D 10",
            "L 25",
            "U 20",
        )

        @Test
        fun `should return 1`() {
            assertEquals(1, year22Day9.part2(input))
        }

        @Test
        fun `should return 36`() {
            assertEquals(36, year22Day9.part2(largerInput))
        }
    }
}
