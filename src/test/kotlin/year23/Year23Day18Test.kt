package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year23Day18Test {

    val year23Day18 = Year23Day18()
    val input = listOf(
        "R 6 (#70c710)",
        "D 5 (#0dc571)",
        "L 2 (#5713f0)",
        "D 2 (#d2c081)",
        "R 2 (#59c680)",
        "D 2 (#411b91)",
        "L 5 (#8ceee2)",
        "U 2 (#caa173)",
        "L 1 (#1b58a2)",
        "U 2 (#caa171)",
        "R 2 (#7807d2)",
        "U 3 (#a77fa3)",
        "L 2 (#015232)",
        "U 2 (#7a21e3)"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 62`() {
            assertEquals(62, year23Day18.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 952408144115`() {
            assertEquals(952_408_144_115, year23Day18.part2(input))
        }
    }
}
