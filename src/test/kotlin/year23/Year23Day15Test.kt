package year23

import core.DayTest

private const val defaultInput = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7"

class Year23Day15Test : DayTest<String, Int, Int>(
    Year23Day15::class.java,
    listOf(
        defaultInput to 1320
    ),
    listOf(
        defaultInput to 145
    )
)
