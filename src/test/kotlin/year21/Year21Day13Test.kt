package year21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year21Day13Test {

    val year21Day13 = Year21Day13()
    val input = listOf(
        "6,10",
        "0,14",
        "9,10",
        "0,3",
        "10,4",
        "4,11",
        "6,0",
        "6,12",
        "4,1",
        "0,13",
        "10,12",
        "3,4",
        "3,0",
        "8,4",
        "1,10",
        "2,14",
        "8,10",
        "9,0",
        "fold along y=7",
        "fold along x=5"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 17`() {
            assertEquals(17, year21Day13.part1(input))
        }
    }
}
