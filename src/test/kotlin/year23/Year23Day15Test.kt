package year23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year23Day15Test {

    val year23Day15 = Year23Day15()
    val input = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7"

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 1320`() {
            assertEquals(1320, year23Day15.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 145`() {
            assertEquals(145, year23Day15.part2(input))
        }
    }
}
