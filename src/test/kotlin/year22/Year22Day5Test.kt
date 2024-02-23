package year22

import core.DayTest
import shared.LineBlock

private val defaultInput = """
        [D]    
    [N] [C]    
    [Z] [M] [P]
     1   2   3 
    
    move 1 from 2 to 1
    move 3 from 1 to 3
    move 2 from 2 to 1
    move 1 from 1 to 2
""".trimIndent()

class Year22Day5Test : DayTest<List<LineBlock>, String, String>(
    Year22Day5::class.java,
    listOf(
        defaultInput to "CMZ"
    ),
    listOf(
        defaultInput to "MCD"
    )
)
