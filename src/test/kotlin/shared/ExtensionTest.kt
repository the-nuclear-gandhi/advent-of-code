package shared

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @Nested
    inner class TestStringToIntList {

        @ParameterizedTest
        @ValueSource(strings = ["1 2 3 4 5", " 1  2 3 4   5   ", "1 2 3 a 4 5"])
        fun `should return a list of 5 numbers`(s: String) {
            val list = s.toIntList()
            assertEquals(5, list.size)
            (1..5).map { assertTrue(it in list) }
        }

        @ParameterizedTest
        @ValueSource(strings = ["1,2,3", "a,b,1,2,3", "1,2,a,3"])
        fun `should return a list of 3 numbers parsed with a different separator`(s: String) {
            val list = s.toIntList(",")
            assertEquals(3, list.size)
            (1..3).map { assertTrue(it in list) }
        }

        @Test
        fun `should return empty list on empty string`() {
            assertTrue("".toIntList().isEmpty())
        }
    }

    @Nested
    inner class TestStringToLongList {
        @ParameterizedTest
        @ValueSource(strings = ["1 2 3 4 5", " 1  2 3 4   5   ", "1 2 3 a 4 5"])
        fun `should return a list of 5 numbers`(s: String) {
            val list = s.toLongList()
            assertEquals(5, list.size)
            (1L..5L).map { assertTrue(it in list) }
        }

        @ParameterizedTest
        @ValueSource(strings = ["1,2,3", "a,b,1,2,3", "1,2,a,3"])
        fun `should return a list of 3 numbers parsed with a different separator`(s: String) {
            val list = s.toLongList(",")
            assertEquals(3, list.size)
            (1L..3L).map { assertTrue(it in list) }
        }

        @Test
        fun `should return empty list on empty string`() {
            assertTrue("".toLongList().isEmpty())
        }
    }

    @Nested
    inner class TestMD5 {

        @Test
        fun `should produce a non-empty byte array`() {
            val s = "abcabcxyzxyz"
            assertTrue(s.md5().isNotEmpty())
        }
    }
}
