package shared

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ExtensionTest {

    @Nested
    inner class TestStringToLineBlocks {

        @Test
        fun `should return 2 line blocks`() {
            val string = """
                1
                2
                
                3
            """.trimIndent()

            val blocks = string.toLineBlocks()
            assertTrue(blocks.size == 2)
            assertTrue(blocks[0].size == 2)
            assertTrue(blocks[1].size == 1)
        }

        @Test
        fun `should ignore empty line blocks`() {
            val string = """
                1
                2
                
                
                
                3
                
                
            """.trimIndent()

            val blocks = string.toLineBlocks()
            assertTrue(blocks.size == 2)
            assertTrue(blocks[0].size == 2)
            assertTrue(blocks[1].size == 1)
        }

        @Test
        fun `should return empty list on empty string`() {
            val string = "\n\n"
            assertTrue(string.toLineBlocks().isEmpty())
        }
    }
}
