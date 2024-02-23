package year22

import core.DayTest

private val defaultInput = """
    ${'$'} cd /
    ${'$'} ls
    dir a
    14848514 b.txt
    8504156 c.dat
    dir d
    ${'$'} cd a
    ${'$'} ls
    dir e
    29116 f
    2557 g
    62596 h.lst
    ${'$'} cd e
    ${'$'} ls
    584 i
    ${'$'} cd ..
    ${'$'} cd ..
    ${'$'} cd d
    ${'$'} ls
    4060174 j
    8033020 d.log
    5626152 d.ext
    7214296 k
""".trimIndent()

class Year22Day7Test : DayTest<List<String>, Int, Int>(
    Year22Day7::class.java,
    listOf(
        defaultInput to 95437
    ),
    listOf(
        defaultInput to 24933642
    )
)
