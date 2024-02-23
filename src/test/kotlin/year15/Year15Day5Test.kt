package year15

import core.DayTest

class Year15Day5Test : DayTest<List<String>, Int, Int>(
    Year15Day5::class.java,
    listOf(
        """
            aei
            xazegov
            aeiouaeiouaeiou
        """.trimIndent() to 0,
        """
            ugknbfddgicrmopn
            aaa
            jchzalrnumimnmhp
            haegwjzuvuyypxyu
            dvszwmarrgswjxmb
        """.trimIndent() to 2
    ),
    listOf(
        """
            qjhvhtzxzqqjkmpb
            xxyxx
        """.trimIndent() to 2,
        """
            uurcxstgmygtbstg
            ieodomkazucvgmuy
            aaa
        """.trimIndent() to 0
    )
)
