package year22

import core.DayTest

private val inputs = listOf(
    "mjqjpqmgbljsphdztnvjfqwrcgsmlb",
    "bvwbjplbgvbhsrlpgdmjqwftvncz",
    "nppdvjthqldpwncqszvftbrmjlhg",
    "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg",
    "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
)

private val part1Answers = listOf(7, 5, 6, 10, 11)
private val part2Answers = listOf(19, 23, 23, 29, 26)

class Year22Day6Test : DayTest<String, Int, Int>(
    Year22Day6::class.java,
    inputs.mapIndexed { index, s -> s to part1Answers[index] },
    inputs.mapIndexed { index, s -> s to part2Answers[index] }
)
