package year21

import core.DayTest

private val defaultInput = """
    [({(<(())[]>[[{[]{<()<>>
    [(()[<>])]({[<{<<[]>>(
    {([(<{}[<>[]}>{[]{[(<()>
    (((({<>}<{<{<>}{[]{[]{}
    [[<[([]))<([[{}[[()]]]
    [{[{({}]{}}([{[{{{}}([]
    {<[[]]>}<{[{[{[]{()[[[]
    [<(<(<(<{}))><([]([]()
    <{([([[(<>()){}]>(<<{{
    <{([{{}}[<[[[<>{}]]]>[]]
""".trimIndent()

class Year21Day10Test : DayTest<List<String>, Int, Long>(
    Year21Day10::class.java,
    listOf(
        defaultInput to 26397
    ),
    listOf(
        defaultInput to 288957
    )
)
