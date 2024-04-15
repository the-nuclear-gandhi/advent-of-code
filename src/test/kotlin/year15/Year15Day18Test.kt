package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import core.InputConverter

class Year15Day18Test {

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
            assertEquals(4, Year15Day18(4).part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 17`() {
            assertEquals(17, Year15Day18(5).part2(input))
        }
    }
}
