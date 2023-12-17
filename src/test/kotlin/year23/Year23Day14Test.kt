package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year23Day14Test {

    val year23Day14 = Year23Day14()
    val input = listOf(
        "O....#....",
        "O.OO#....#",
        ".....##...",
        "OO.#O....O",
        ".O.....O#.",
        "O.#..O.#.#",
        "..O..#O..O",
        ".......O..",
        "#....###..",
        "#OO..#...."
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 136`() {
            assertEquals(136, year23Day14.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 64`() {
            assertEquals(64, year23Day14.part2(input))
        }
    }
}
