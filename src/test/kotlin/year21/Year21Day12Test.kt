package year21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year21Day12Test {

    val year21Day12 = Year21Day12()
    val input = listOf(
        "start-A",
        "start-b",
        "A-c",
        "A-b",
        "b-d",
        "A-end",
        "b-end"
    )

    val largerInput = listOf(
        "dc-end",
        "HN-start",
        "start-kj",
        "dc-start",
        "dc-HN",
        "LN-dc",
        "HN-end",
        "kj-sa",
        "kj-HN",
        "kj-dc"
    )

    val largestInput = listOf(
        "fs-end",
        "he-DX",
        "fs-he",
        "start-DX",
        "pj-DX",
        "end-zg",
        "zg-sl",
        "zg-pj",
        "pj-he",
        "RW-he",
        "fs-DX",
        "pj-RW",
        "zg-RW",
        "start-pj",
        "he-WI",
        "zg-he",
        "pj-fs",
        "start-RW"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 10`() {
            assertEquals(10, year21Day12.part1(input))
        }

        @Test
        fun `should return 19`() {
            assertEquals(19, year21Day12.part1(largerInput))
        }

        @Test
        fun `should return 226`() {
            assertEquals(226, year21Day12.part1(largestInput))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 36`() {
            assertEquals(36, year21Day12.part2(input))
        }

        @Test
        fun `should return 103`() {
            assertEquals(103, year21Day12.part2(largerInput))
        }

        @Test
        fun `should return 3509`() {
            assertEquals(3509, year21Day12.part2(largestInput))
        }
    }
}
