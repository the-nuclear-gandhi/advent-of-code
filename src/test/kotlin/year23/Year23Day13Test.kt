package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import shared.toLineBlocks

class Year23Day13Test {

    val year23Day13 = Year23Day13()
    val input = """
        #.##..##.
        ..#.##.#.
        ##......#
        ##......#
        ..#.##.#.
        ..##..##.
        #.#.##.#.

        #...##..#
        #....#..#
        ..##..###
        #####.##.
        #####.##.
        ..##..###
        #....#..#
    """.trimIndent().toLineBlocks()

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 405`() {
            assertEquals(405, year23Day13.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 400`() {
            assertEquals(400, year23Day13.part2(input))
        }
    }
}
