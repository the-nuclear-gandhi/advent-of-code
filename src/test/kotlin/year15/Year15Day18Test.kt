package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import core.InputConverter

class Year15Day18Test {

    val year15Day18 = Year15Day18()
    val input = InputConverter.toLines(
        """
            .#.#.#
            ...##.
            #....#
            ..#...
            #.#..#
            ####..
        """.trimIndent()
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 4`() {
            assertEquals(4, year15Day18.solvePart1(input, 4))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 17`() {
            assertEquals(17, year15Day18.solvePart2(input, 5))
        }
    }
}
