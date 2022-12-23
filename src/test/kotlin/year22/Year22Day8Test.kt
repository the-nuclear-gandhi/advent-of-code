package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year22Day8Test {

    val year22Day8 = Year22Day8()
    val input = listOf(
        "30373",
        "25512",
        "65332",
        "33549",
        "35390",
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 21`() {
            assertEquals(21, year22Day8.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 8`() {
            assertEquals(8, year22Day8.part2(input))
        }
    }
}
