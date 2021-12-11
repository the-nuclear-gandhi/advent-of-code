package year21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year21Day6Test {

    val year21Day6 = Year21Day6()
    val input = "3,4,3,1,2"

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 5934`() {
            assertEquals(5934, year21Day6.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 26984457539`() {
            assertEquals(26_984_457_539, year21Day6.part2(input))
        }
    }
}
