package year16

import core.DayTest

private val part1Input = """
    aaaaa-bbb-z-y-x-123[abxyz]
    a-b-c-d-e-f-g-h-987[abcde]
    not-a-real-room-404[oarel]
    totally-real-room-200[decoy]
""".trimIndent()

private val part2Input = """
    qzmt-zixmtkozy-ivhz-343[zimth]
    ghkmaihex-hucxvm-lmhktzx-267[hmxka]
""".trimIndent()

class Year16Day4Test : DayTest<List<String>, Int, Int>(
    Year16Day4::class.java,
    listOf(
        part1Input to 1514
    ),
    listOf(
        part2Input to 267
    )
)
