package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year22Day4Test {

    val year22Day4 = Year22Day4()
    val input = listOf(
        "2-4,6-8",
        "2-3,4-5",
        "5-7,7-9",
        "2-8,3-7",
        "6-6,4-6",
        "2-6,4-8",
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 2`() {
            assertEquals(2, year22Day4.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 4`() {
            assertEquals(4, year22Day4.part2(input))
        }
    }
}
