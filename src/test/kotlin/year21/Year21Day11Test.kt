package year21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year21Day11Test {

    val year21Day11 = Year21Day11()
    val input = listOf(
        "5483143223",
        "2745854711",
        "5264556173",
        "6141336146",
        "6357385478",
        "4167524645",
        "2176841721",
        "6882881134",
        "4846848554",
        "5283751526"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 1656`() {
            assertEquals(1656, year21Day11.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 195`() {
            assertEquals(195, year21Day11.part2(input))
        }
    }
}
