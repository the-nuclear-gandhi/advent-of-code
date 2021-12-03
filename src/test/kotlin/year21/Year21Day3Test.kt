package year21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year21Day3Test {

    val year21Day3 = Year21Day3()
    val input = listOf(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 198`() {
            assertEquals(198, year21Day3.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 230`() {
            assertEquals(230, year21Day3.part2(input))
        }
    }
}
