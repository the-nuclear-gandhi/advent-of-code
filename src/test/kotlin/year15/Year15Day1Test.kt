package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class Year15Day1Test {

  val year15Day1 = Year15Day1()

  @Nested
  inner class TestPart1 {

    @ParameterizedTest
    @ValueSource(strings = ["(())", "()()"])
    fun `should return 0`(s: String) {
      assertEquals(0, year15Day1.part1(s))
    }

    @ParameterizedTest
    @ValueSource(strings = ["(((", "(()(()(", "))((((("])
    fun `should return 3`(s: String) {
      assertEquals(3, year15Day1.part1(s))
    }

    @ParameterizedTest
    @ValueSource(strings = ["())", "))("])
    fun `should return -1`(s: String) {
      assertEquals(-1, year15Day1.part1(s))
    }

    @ParameterizedTest
    @ValueSource(strings = [")))", ")())())"])
    fun `should return -3`(s: String) {
      assertEquals(-3, year15Day1.part1(s))
    }

  }

  @Nested
  inner class TestPart2 {

    @ParameterizedTest
    @ValueSource(strings = [")"])
    fun `should return 1`(s: String) {
      assertEquals(1, year15Day1.part2(s))
    }

    @ParameterizedTest
    @ValueSource(strings = ["()())"])
    fun `should return 5`(s: String) {
      assertEquals(5, year15Day1.part2(s))
    }

  }
}
