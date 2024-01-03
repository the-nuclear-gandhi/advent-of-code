package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year23Day16Test {

    val year23Day16 = Year23Day16()
    val input = listOf(
        ".|...\\....",
        "|.-.\\.....",
        ".....|-...",
        "........|.",
        "..........",
        ".........\\",
        "..../.\\\\..",
        ".-.-/..|..",
        ".|....-|.\\",
        "..//.|...."
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 46`() {
            assertEquals(46, year23Day16.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 51`() {
            assertEquals(51, year23Day16.part2(input))
        }
    }
}
