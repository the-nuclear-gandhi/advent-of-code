package year16

import core.DayTest

private val defaultInput = """
    eedadn
    drvtee
    eandsr
    raavrd
    atevrs
    tsrnev
    sdttsa
    rasrtv
    nssdts
    ntnada
    svetve
    tesnvt
    vntsnd
    vrdear
    dvrsen
    enarar
""".trimIndent()

class Year16Day6Test : DayTest<List<String>, String, String>(
    Year16Day6::class.java,
    listOf(
        defaultInput to "easter"
    ),
    listOf(
        defaultInput to "advent"
    )
)
