package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year15Day13Test {

    val year15Day13 = Year15Day13()
    val input = listOf(
        "Alice would gain 54 happiness units by sitting next to Bob.",
        "Alice would lose 79 happiness units by sitting next to Carol.",
        "Alice would lose 2 happiness units by sitting next to David.",
        "Bob would gain 83 happiness units by sitting next to Alice.",
        "Bob would lose 7 happiness units by sitting next to Carol.",
        "Bob would lose 63 happiness units by sitting next to David.",
        "Carol would lose 62 happiness units by sitting next to Alice.",
        "Carol would gain 60 happiness units by sitting next to Bob.",
        "Carol would gain 55 happiness units by sitting next to David.",
        "David would gain 46 happiness units by sitting next to Alice.",
        "David would lose 7 happiness units by sitting next to Bob.",
        "David would gain 41 happiness units by sitting next to Carol.",
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 330`() {
            assertEquals(330, year15Day13.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {
        @Test
        fun `should return 982`() {
            assertEquals(286, year15Day13.part2(input))
        }
    }
}
