package year15

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class Year15Day21Test {

    private val year15Day21 = Year15Day21()
    private val input = """
        Hit Points: 50
        Damage: 7
        Armor: 2 
    """.trimIndent()

    @Test
    fun `runs without errors`() = assertDoesNotThrow {
        year15Day21.solve(input)
    }
}
