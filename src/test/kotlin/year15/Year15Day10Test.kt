package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class Year15Day10Test {

  val year15Day10 = Year15Day10()

  @Nested
  inner class TestLookAndSay {

    @ParameterizedTest
    @ValueSource(strings = ["1", "11"])
    fun `should return 2`(input: String) {
      assertEquals(2, year15Day10.lookAndSay(input, 1))
    }

    @Test
    fun `should return 4`() {
      assertEquals(4, year15Day10.lookAndSay("21", 1))
    }

    @Test
    fun `should return 6`() {
      assertEquals(6, year15Day10.lookAndSay("1", 5))
    }
  }
}
