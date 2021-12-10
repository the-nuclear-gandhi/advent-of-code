package year21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year21Day10Test {

    val year21Day10 = Year21Day10()
    val input = listOf(
        "[({(<(())[]>[[{[]{<()<>>",
        "[(()[<>])]({[<{<<[]>>(",
        "{([(<{}[<>[]}>{[]{[(<()>",
        "(((({<>}<{<{<>}{[]{[]{}",
        "[[<[([]))<([[{}[[()]]]",
        "[{[{({}]{}}([{[{{{}}([]",
        "{<[[]]>}<{[{[{[]{()[[[]",
        "[<(<(<(<{}))><([]([]()",
        "<{([([[(<>()){}]>(<<{{",
        "<{([{{}}[<[[[<>{}]]]>[]]",
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 26397`() {
            assertEquals(26397, year21Day10.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 288957`() {
            assertEquals(288957, year21Day10.part2(input))
        }
    }
}
