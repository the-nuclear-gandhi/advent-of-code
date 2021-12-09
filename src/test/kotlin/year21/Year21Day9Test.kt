package year21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year21Day9Test {

    val year21Day9 = Year21Day9()
    val input = listOf(
        "2199943210",
        "3987894921",
        "9856789892",
        "8767896789",
        "9899965678"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 15`() {
            assertEquals(15, year21Day9.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 1134`() {
            assertEquals(1134, year21Day9.part2(input))
        }
    }
}
