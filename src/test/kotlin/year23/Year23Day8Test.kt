package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year23Day8Test {

    val year23Day8 = Year23Day8()

    @Nested
    inner class TestPart1 {

        private val input = listOf(
            "RL",
            "AAA = (BBB, CCC)",
            "BBB = (DDD, EEE)",
            "CCC = (ZZZ, GGG)",
            "DDD = (DDD, DDD)",
            "EEE = (EEE, EEE)",
            "GGG = (GGG, GGG)",
            "ZZZ = (ZZZ, ZZZ)"
        )

        private val secondInput = listOf(
            "LLR",
            "AAA = (BBB, BBB)",
            "BBB = (AAA, ZZZ)",
            "ZZZ = (ZZZ, ZZZ)"
        )

        @Test
        fun `should return 2`() {
            assertEquals(2, year23Day8.part1(input))
        }

        @Test
        fun `should return 6`() {
            assertEquals(6, year23Day8.part1(secondInput))
        }
    }

    @Nested
    inner class TestPart2 {

        private val input = listOf(
            "LR",
            "11A = (11B, XXX)",
            "11B = (XXX, 11Z)",
            "11Z = (11B, XXX)",
            "22A = (22B, XXX)",
            "22B = (22C, 22C)",
            "22C = (22Z, 22Z)",
            "22Z = (22B, 22B)",
            "XXX = (XXX, XXX)"
        )

        @Test
        fun `should return 6`() {
            assertEquals(6, year23Day8.part2(input))
        }
    }
}
