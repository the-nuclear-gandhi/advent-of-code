package year15

import core.DayTest

class Year15Day1Test : DayTest<String, Int, Int>(
    Year15Day1::class.java,
    listOf(
        "(())" to 0,
        "()()" to 0,
        "(((" to 3,
        "))(((((" to 3,
        "())" to -1,
        "))(" to -1,
        ")))" to -3,
        ")())())" to -3
    ),
    listOf(
        ")" to 1,
        "()())" to 5
    )
)
