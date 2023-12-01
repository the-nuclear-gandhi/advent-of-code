package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year23Day1Test {

    val year23Day1 = Year23Day1()

    @Nested
    inner class TestPart1 {

        val input = listOf(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet",
        )

        @Test
        fun `should return 142`() {
            assertEquals(142, year23Day1.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        val input = listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen",
        )

        @Test
        fun `should return 281`() {
            assertEquals(281, year23Day1.part2(input))
        }
    }
}
