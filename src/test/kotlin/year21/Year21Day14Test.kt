package year21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year21Day14Test {

    val year21Day14 = Year21Day14()
    val input = listOf(
        "NNCB",
        "CH -> B",
        "HH -> N",
        "CB -> H",
        "NH -> C",
        "HB -> C",
        "HC -> B",
        "HN -> C",
        "NN -> C",
        "BH -> H",
        "NC -> B",
        "NB -> B",
        "BN -> B",
        "BB -> N",
        "BC -> B",
        "CC -> N",
        "CN -> C"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 1588`() {
            assertEquals(1588, year21Day14.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 2_188_189_693_529`() {
            assertEquals(2_188_189_693_529, year21Day14.part2(input))
        }
    }
}
