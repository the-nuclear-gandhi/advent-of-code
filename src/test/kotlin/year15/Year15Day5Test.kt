package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class Year15Day5Test {

  val year15Day5 = Year15Day5()

  @Nested
  inner class TestPart1 {

    @Test
    fun `should return 0`() {
      val input = listOf("aei", "xazegov", "aeiouaeiouaeiou")
      assertEquals(0, year15Day5.part1(input))
    }

    @Test
    fun `should return 2`() {
      val input = listOf("ugknbfddgicrmopn", "aaa", "jchzalrnumimnmhp", "haegwjzuvuyypxyu", "dvszwmarrgswjxmb")
      assertEquals(2, year15Day5.part1(input))
    }

  }

  @Nested
  inner class TestPart2 {

    @Test
    fun `should return 2`() {
      val input = listOf("qjhvhtzxzqqjkmpb", "xxyxx")
      assertEquals(2, year15Day5.part2(input))
    }

    @Test
    fun `should return 0`() {
      val input = listOf("uurcxstgmygtbstg", "ieodomkazucvgmuy", "aaa")
      assertEquals(0, year15Day5.part2(input))
    }

  }

}
