package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import shared.toLineBlocks

class Year22Day1Test {

    val year22Day1 = Year22Day1()
    val input = """
        1000
        2000
        3000
        
        4000
        
        5000
        6000
        
        7000
        8000
        9000
        
        10000
    """.trimIndent().toLineBlocks()

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 24000`() {
            assertEquals(24000, year22Day1.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 45000`() {
            assertEquals(45000, year22Day1.part2(input))
        }
    }
}
