package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import shared.toLineBlocks

class Year22Day13Test {

    val year22Day13 = Year22Day13()
    val input = """
        [1,1,3,1,1]
        [1,1,5,1,1]

        [[1],[2,3,4]]
        [[1],4]

        [9]
        [[8,7,6]]

        [[4,4],4,4]
        [[4,4],4,4,4]

        [7,7,7,7]
        [7,7,7]

        []
        [3]

        [[[]]]
        [[]]

        [1,[2,[3,[4,[5,6,7]]]],8,9]
        [1,[2,[3,[4,[5,6,0]]]],8,9]
    """.trimIndent().toLineBlocks()

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 13`() {
            assertEquals(13, year22Day13.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 140`() {
            assertEquals(140, year22Day13.part2(input))
        }
    }
}
