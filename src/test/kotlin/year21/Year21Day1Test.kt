package year21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year21Day1Test {

    val year21Day1 = Year21Day1()
    val input = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 7`() {
            assertEquals(7, year21Day1.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 5`() {
            assertEquals(5, year21Day1.part2(input))
        }
    }
}
