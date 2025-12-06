package year25

import core.DayTest

private val defaultInput = """
    123 328  51 64 
     45 64  387 23 
      6 98  215 314
    *   +   *   +  
""".trimIndent()

class Year25Day6Test : DayTest<List<String>, Long, Long>(
    Year25Day6::class.java,
    listOf(
        defaultInput to 4277556
    ),
    listOf(
        defaultInput to 3263827
    )
)
