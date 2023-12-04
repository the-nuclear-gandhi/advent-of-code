package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year23Day4Test {

    val year23Day4 = Year23Day4()
    val input = listOf(
        "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
        "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
        "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
        "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
        "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
        "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 13`() {
            assertEquals(13, year23Day4.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 30`() {
            assertEquals(30, year23Day4.part2(input))
        }
    }
}
