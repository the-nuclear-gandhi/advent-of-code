package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Year22Day6Test {

    val year22Day6 = Year22Day6()

    @Nested
    inner class TestPart1 {

        @ParameterizedTest
        @MethodSource("year22.Year22Day6Test#part1TestData")
        fun checkPart1(input: String, expectedResult: Int) {
            assertEquals(expectedResult, year22Day6.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @ParameterizedTest
        @MethodSource("year22.Year22Day6Test#part2TestData")
        fun checkPart2(input: String, expectedResult: Int) {
            assertEquals(expectedResult, year22Day6.part2(input))
        }
    }

    companion object {
        @JvmStatic
        private fun part1TestData(): List<Arguments> = listOf(
            Arguments.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 7),
            Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz", 5),
            Arguments.of("nppdvjthqldpwncqszvftbrmjlhg", 6),
            Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 10),
            Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 11)
        )

        @JvmStatic
        private fun part2TestData(): List<Arguments> = listOf(
            Arguments.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 19),
            Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz", 23),
            Arguments.of("nppdvjthqldpwncqszvftbrmjlhg", 23),
            Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 29),
            Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 26)
        )
    }
}
