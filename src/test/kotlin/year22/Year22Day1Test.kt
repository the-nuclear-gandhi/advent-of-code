package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year22Day1Test {

    val year22Day1 = Year22Day1()
    val input = "1000\n2000\n3000\n\n4000\n\n5000\n6000\n\n7000\n8000\n9000\n\n10000"

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 24000`() {
            assertEquals(24000, year22Day1.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 45000`() {
            assertEquals(45000, year22Day1.part2(input))
        }
    }
}
