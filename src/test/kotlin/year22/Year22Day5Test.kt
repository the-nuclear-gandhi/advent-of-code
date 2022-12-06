package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year22Day5Test {

    val year22Day5 = Year22Day5()
    val input =
        "    [D]    \n" +
        "[N] [C]    \n" +
        "[Z] [M] [P]\n" +
        " 1   2   3 \n" +
        "\n" +
        "move 1 from 2 to 1\n" +
        "move 3 from 1 to 3\n" +
        "move 2 from 2 to 1\n" +
        "move 1 from 1 to 2"

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return CMZ`() {
            assertEquals("CMZ", year22Day5.part1(input))
        }
    }
    @Nested
    inner class TestPart2 {

        @Test
        fun `should return MCD`() {
            assertEquals("MCD", year22Day5.part2(input))
        }
    }
}
