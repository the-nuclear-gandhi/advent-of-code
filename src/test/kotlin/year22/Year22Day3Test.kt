package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year22Day3Test {

    val year22Day3 = Year22Day3()
    val input = listOf(
        "vJrwpWtwJgWrhcsFMMfFFhFp",
        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
        "PmmdzqPrVvPwwTWBwg",
        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
        "ttgJtRGJQctTZtZT",
        "CrZsJsPPZsGzwwsLwLmpwMDw",
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 157`() {
            assertEquals(157, year22Day3.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 70`() {
            assertEquals(70, year22Day3.part2(input))
        }
    }
}
