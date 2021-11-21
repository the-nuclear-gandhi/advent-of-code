package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year15Day17Test {

    val year15Day17 = Year15Day17()
    val input = listOf(20, 15, 10, 5, 5)

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 4`() {
            assertEquals(4, year15Day17.solvePart1(input, 25))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 3`() {
            assertEquals(3, year15Day17.solvePart2(input, 25))
        }
    }
}
