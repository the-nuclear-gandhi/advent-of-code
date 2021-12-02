package year21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year21Day2Test {

    val year21Day2 = Year21Day2()
    val input = listOf(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 150`() {
            assertEquals(150, year21Day2.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 900`() {
            assertEquals(900, year21Day2.part2(input))
        }
    }

}
