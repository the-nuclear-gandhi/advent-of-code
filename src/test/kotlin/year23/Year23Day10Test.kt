package year23

import core.DayTest

private val simpleInput = """
    -L|F7
    7S-7|
    L|7||
    -L-J|
    L|-JF
""".trimIndent()

private val secondInput = """
    7-F7-
    .FJ|7
    SJLL7
    |F--J
    LJ.LJ
""".trimIndent()

private val defaultPart2Input = """
    ...........
    .S-------7.
    .|F-----7|.
    .||.....||.
    .||.....||.
    .|L-7.F-J|.
    .|..|.|..|.
    .L--J.L--J.
    ...........
""".trimIndent()

private val secondPart2Input = """
    .F----7F7F7F7F-7....
    .|F--7||||||||FJ....
    .||.FJ||||||||L7....
    FJL7L7LJLJ||LJ.L-7..
    L--J.L7...LJS7F-7L7.
    ....F-J..F7FJ|L7L7L7
    ....L7.F7||L7|.L7L7|
    .....|FJLJ|FJ|F7|.LJ
    ....FJL-7.||.||||...
    ....L---J.LJ.LJLJ...
""".trimIndent()

private val complexPart2Input = """
    FF7FSF7F7F7F7F7F---7
    L|LJ||||||||||||F--J
    FL-7LJLJ||||||LJL-77
    F--JF--7||LJLJ7F7FJ-
    L---JF-JLJ.||-FJLJJ7
    |F|F-JF---7F7-L7L|7|
    |FFJF7L7F-JF7|JL---7
    7-L-JL7||F7|L7F-7F7|
    L.L7LFJ|||||FJL7||LJ
    L7JLJL-JLJLJL--JLJ.L
""".trimIndent()

class Year23Day10Test : DayTest<List<String>, Int, Int>(
    Year23Day10::class.java,
    listOf(
        simpleInput to 4,
        secondInput to 8
    ),
    listOf(
        defaultPart2Input to 4,
        secondPart2Input to 8,
        complexPart2Input to 10
    )
)
