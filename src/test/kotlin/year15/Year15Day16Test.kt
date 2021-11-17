package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year15Day16Test {

    val year15Day16 = Year15Day16()
    val input = listOf(
        "Sue 1: akitas: 8, cats: 10, perfumes: 8",
        "Sue 2: goldfish: 0, vizslas: 0, samoyeds: 2",
        "Sue 3: akitas: 0, perfumes: 2, pomeranians: 10",
        "Sue 4: samoyeds: 9, pomeranians: 7, perfumes: 6",
        "Sue 5: pomeranians: 3, perfumes: 1, vizslas: 0",
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 5`() {
            assertEquals(5, year15Day16.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 2`() {
            assertEquals(2, year15Day16.part2(input))
        }
    }
}
