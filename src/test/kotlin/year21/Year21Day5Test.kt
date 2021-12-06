package year21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year21Day5Test {

    val year21Day5 = Year21Day5()
    val input = listOf(
        "0,9 -> 5,9",
        "8,0 -> 0,8",
        "9,4 -> 3,4",
        "2,2 -> 2,1",
        "7,0 -> 7,4",
        "6,4 -> 2,0",
        "0,9 -> 2,9",
        "3,4 -> 1,4",
        "0,0 -> 8,8",
        "5,5 -> 8,2"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 5`() {
            assertEquals(5, year21Day5.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 12`() {
            assertEquals(12, year21Day5.part2(input))
        }
    }
}
