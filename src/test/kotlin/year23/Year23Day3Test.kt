package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year23Day3Test {

    val year23Day3 = Year23Day3()
    val input = listOf(
        "467..114..",
        "...*......",
        "..35..633.",
        "......#...",
        "617*......",
        ".....+.58.",
        "..592.....",
        "......755.",
        "...\$.*....",
        ".664.598.."
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 4361`() {
            assertEquals(4361, year23Day3.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 467835`() {
            assertEquals(467835, year23Day3.part2(input))
        }
    }
}
