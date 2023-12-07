package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year23Day7Test {

    val year23Day7 = Year23Day7()
    val input = listOf(
        "32T3K 765",
        "T55J5 684",
        "KK677 28",
        "KTJJT 220",
        "QQQJA 483"

    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 6440`() {
            assertEquals(6440, year23Day7.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 5905`() {
            assertEquals(5905, year23Day7.part2(input))
        }
    }
}
