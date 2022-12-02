package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year22Day2Test {

    val year22Day2 = Year22Day2()
    val input = listOf(
        "A Y",
        "B X",
        "C Z",
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 15`() {
            assertEquals(15, year22Day2.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 12`() {
            assertEquals(12, year22Day2.part2(input))
        }
    }
}
