package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year23Day2Test {

    val year23Day2 = Year23Day2()
    val input = listOf(
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 8`() {
            assertEquals(8, year23Day2.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 2286`() {
            assertEquals(2286, year23Day2.part2(input))
        }
    }
}
