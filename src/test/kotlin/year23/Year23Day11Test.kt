package year23

import core.DayTest
import core.InputConverter.Companion.toLines
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

private val defaultInput = """
    ...#......
    .......#..
    #.........
    ..........
    ......#...
    .#........
    .........#
    ..........
    .......#..
    #...#.....
""".trimIndent()

class Year23Day11Test : DayTest<List<String>, Long, Long>(
    Year23Day11::class.java,
    listOf(
        defaultInput to 374
    ),
    listOf()
) {

    @Nested
    @DisplayName("part2")
    inner class TestPart2 {
        private val year23Day11 = Year23Day11()

        @Test
        fun `should return 1030`() {
            assertEquals(1030, year23Day11.solve(toLines(defaultInput), 10))
        }

        @Test
        fun `should return 8410`() {
            assertEquals(8410, year23Day11.solve(toLines(defaultInput), 100))
        }
    }
}
