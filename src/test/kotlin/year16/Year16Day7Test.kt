package year16

import core.DayTest

private val defaultInput = """
    abba[mnop]qrst
    abcd[bddb]xyyx
    aaaa[qwer]tyui
    ioxxoj[asdfgh]zxcvbn
""".trimIndent()

private val part2Input = """
    aba[bab]xyz
    xyx[xyx]xyx
    aaa[kek]eke
    zazbz[bzb]cdb
""".trimIndent()

class Year16Day7Test : DayTest<List<String>, Int, Int>(
    Year16Day7::class.java,
    listOf(
        defaultInput to 2
    ),
    listOf(
        part2Input to 3
    )
)
