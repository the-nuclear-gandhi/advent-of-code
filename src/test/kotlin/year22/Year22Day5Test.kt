package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import shared.toLineBlocks

class Year22Day5Test {

    val year22Day5 = Year22Day5()
    val input = """
            [D]    
        [N] [C]    
        [Z] [M] [P]
         1   2   3 
        
        move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2
    """.trimIndent().toLineBlocks()

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return CMZ`() {
            assertEquals("CMZ", year22Day5.part1(input))
        }
    }
    @Nested
    inner class TestPart2 {

        @Test
        fun `should return MCD`() {
            assertEquals("MCD", year22Day5.part2(input))
        }
    }
}
