package year21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year21Day7Test {

    val year21Day7 = Year21Day7()
    val input = "16,1,2,0,4,2,7,1,2,14"

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 37`() {
            assertEquals(37, year21Day7.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 168`() {
            assertEquals(168, year21Day7.part2(input))
        }
    }
}
