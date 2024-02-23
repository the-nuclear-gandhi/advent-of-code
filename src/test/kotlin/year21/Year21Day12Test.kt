package year21

import core.DayTest

class Year21Day12Test : DayTest<List<String>, Int, Int>(
    Year21Day12::class.java,
    listOf(
        defaultInput to 10,
        largerInput to 19,
        largestInput to 226
    ),
    listOf(
        defaultInput to 36,
        largerInput to 103,
        largestInput to 3509
    )
)

private val defaultInput = """
    start-A
    start-b
    A-c
    A-b
    b-d
    A-end
    b-end
""".trimIndent()

private val largerInput = """
    dc-end
    HN-start
    start-kj
    dc-start
    dc-HN
    LN-dc
    HN-end
    kj-sa
    kj-HN
    kj-dc
""".trimIndent()

private val largestInput = """
    fs-end
    he-DX
    fs-he
    start-DX
    pj-DX
    end-zg
    zg-sl
    zg-pj
    pj-he
    RW-he
    fs-DX
    pj-RW
    zg-RW
    start-pj
    he-WI
    zg-he
    pj-fs
    start-RW
""".trimIndent()
