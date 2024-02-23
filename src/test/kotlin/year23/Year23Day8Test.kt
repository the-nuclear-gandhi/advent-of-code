package year23

import core.DayTest

private val part1Input1 = """
    RL

    AAA = (BBB, CCC)
    BBB = (DDD, EEE)
    CCC = (ZZZ, GGG)
    DDD = (DDD, DDD)
    EEE = (EEE, EEE)
    GGG = (GGG, GGG)
    ZZZ = (ZZZ, ZZZ)
""".trimIndent()

private val part1Input2 = """
    LLR

    AAA = (BBB, BBB)
    BBB = (AAA, ZZZ)
    ZZZ = (ZZZ, ZZZ)
""".trimIndent()

private val part2Input = """
    LR

    11A = (11B, XXX)
    11B = (XXX, 11Z)
    11Z = (11B, XXX)
    22A = (22B, XXX)
    22B = (22C, 22C)
    22C = (22Z, 22Z)
    22Z = (22B, 22B)
    XXX = (XXX, XXX)
""".trimIndent()

class Year23Day8Test : DayTest<List<String>, Int, Long>(
    Year23Day8::class.java,
    listOf(
        part1Input1 to 2,
        part1Input2 to 6
    ),
    listOf(
        part2Input to 6
    )
)
