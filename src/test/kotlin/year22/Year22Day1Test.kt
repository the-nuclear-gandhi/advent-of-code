package year22

import core.DayTest
import shared.LineBlock

private val defaultInput = """
    1000
    2000
    3000
    
    4000
    
    5000
    6000
    
    7000
    8000
    9000
    
    10000
""".trimIndent()

class Year22Day1Test : DayTest<List<LineBlock>, Int, Int>(
    Year22Day1::class.java,
    listOf(
        defaultInput to 24000
    ),
    listOf(
        defaultInput to 45000
    )
)
