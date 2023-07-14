package shared

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputConverterTest {

    @Nested
    inner class TestNoOp {

        @ParameterizedTest
        @ValueSource(strings = ["", "input"])
        fun `should return the same string`(s: String) = assertEquals(s, InputConverter.noOp(s))
    }

    @Nested
    inner class TestToInts {

        @Test
        fun `should return list of ints`() {
            val input = """
                1
                2
                4
            """.trimIndent()
            val list = InputConverter.toInts(input)
            assertFalse(list.isEmpty())
            assertEquals(3, list.size)
            assertEquals(listOf(1, 2, 4), list)
        }

        @Test
        fun `should fail if input contains strings`() {
            val input = """
                1
                2
                abc
            """.trimIndent()
            assertThrows(NumberFormatException::class.java) { InputConverter.toInts(input) }
        }
    }

    @Nested
    inner class TestToLines {

        @Test
        fun `should return list of strings`() {
            val input = """
                foo
                bar
                baz
            """.trimIndent()
            val list = InputConverter.toLines(input)
            assertFalse(list.isEmpty())
            assertEquals(3, list.size)
            assertEquals(listOf("foo", "bar", "baz"), list)
        }
    }

    @Nested
    inner class TestToLineBlocks {

        @Test
        fun `should return line blocks`() {
            val input = """
                foo
                bar
                
                baz
            """.trimIndent()
            val list = InputConverter.toLineBlocks(input)

            assertFalse(list.isEmpty())
            assertEquals(2, list.size)
            assertEquals(listOf("foo", "bar"), list.first())
            assertEquals(listOf("baz"), list.last())
        }
    }

    @Nested
    inner class TestTrimming {

        @Test
        fun `should trim leading & trailing whitespace`() {
            val input = " value  "
            assertEquals("value", InputConverter.trimming(input))
        }
    }
}
