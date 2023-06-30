package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year22Day12Test {

    val year22Day12 = Year22Day12()
    val input = listOf(
        "Sabqponm",
        "abcryxxl",
        "accszExk",
        "acctuvwj",
        "abdefghi"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 31`() {
            assertEquals(31, year22Day12.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 29`() {
            assertEquals(29, year22Day12.part2(input))
        }
    }
}
