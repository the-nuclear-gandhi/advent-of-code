package year15

import core.DayTest

class Year15Day12Test : DayTest<String, Int, Int>(
    Year15Day12::class.java,
    listOf(
        """{"a":2,"b":4}""" to 6,
        """{"a":{"b":4},"c":-1}""" to 3
    ),
    listOf(
        "[1,2,3]" to 6,
        "[1,\"red\",5]" to 6,
        """[1,{"c":"red","b":2},3]""" to 4,
        """{"d":"red","e":[1,2,3,4],"f":5}""" to 0
    )
)
