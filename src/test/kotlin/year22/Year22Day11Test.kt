package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import shared.toLineBlocks

class Year22Day11Test {

    val year22Day11 = Year22Day11()
    val input = """
        Monkey 0:
          Starting items: 79, 98
          Operation: new = old * 19
          Test: divisible by 23
            If true: throw to monkey 2
            If false: throw to monkey 3

        Monkey 1:
          Starting items: 54, 65, 75, 74
          Operation: new = old + 6
          Test: divisible by 19
            If true: throw to monkey 2
            If false: throw to monkey 0

        Monkey 2:
          Starting items: 79, 60, 97
          Operation: new = old * old
          Test: divisible by 13
            If true: throw to monkey 1
            If false: throw to monkey 3

        Monkey 3:
          Starting items: 74
          Operation: new = old + 3
          Test: divisible by 17
            If true: throw to monkey 0
            If false: throw to monkey 1
    """.trimIndent().toLineBlocks()

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 10605`() {
            assertEquals(10605, year22Day11.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 2713310158`() {
            assertEquals(2_713_310_158, year22Day11.part2(input))
        }
    }
}
