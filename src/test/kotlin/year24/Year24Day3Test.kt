package year24

import core.DayTest

private const val defaultInput = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
private const val secondInput = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

class Year24Day3Test : DayTest<String, Int, Int>(
    Year24Day3::class.java,
    listOf(
        defaultInput to 161
    ),
    listOf(
        secondInput to 48
    ),
)
