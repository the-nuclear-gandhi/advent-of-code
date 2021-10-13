package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class Year15Day3Test {

    val year15Day3 = Year15Day3()

    @Nested
    inner class TestPart1 {

        @ParameterizedTest
        @ValueSource(strings = [">", "^v^v^v^v^v"])
        fun `should return 2`(s: String) {
            assertEquals(2, year15Day3.part1(s))
        }

        @ParameterizedTest
        @ValueSource(strings = ["^>v<"])
        fun `should return 4`(s: String) {
            assertEquals(4, year15Day3.part1(s))
        }

    }

    @Nested
    inner class TestPart2 {

        @ParameterizedTest
        @ValueSource(strings = ["^v", "^>v<"])
        fun `should return 3`(s: String) {
            assertEquals(3, year15Day3.part2(s))
        }

        @ParameterizedTest
        @ValueSource(strings = ["^v^v^v^v^v"])
        fun `should return 11`(s: String) {
            assertEquals(11, year15Day3.part2(s))
        }

    }
}
