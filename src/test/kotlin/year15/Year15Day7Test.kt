package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year15Day7Test {

  val baseInput = listOf("123 -> x", "456 -> y")
  val year15Day7 = Year15Day7()

  @Nested
  inner class TestPart1 {

    @Test
    fun `should return 123`() {
      val input = baseInput + "x -> a"
      assertEquals(123, year15Day7.part1(input))
    }

    @Test
    fun `should return 72`() {
      val input = baseInput + "x AND y -> a"
      assertEquals(72, year15Day7.part1(input))
    }

    @Test
    fun `should return 492`() {
      val input = baseInput + "x LSHIFT 2 -> a"
      assertEquals(492, year15Day7.part1(input))
    }

    @Test
    fun `should return 114`() {
      val input = baseInput + "y RSHIFT 2 -> a"
      assertEquals(114, year15Day7.part1(input))
    }

    @Test
    fun `should return 65412`() {
      val input = baseInput + "NOT x -> a"
      assertEquals(65412, year15Day7.part1(input))
    }

  }

  @Nested
  inner class TestPart2 {

    @Test
    fun `should return 72`() {
      val input = listOf("123 -> x", "456 -> b", "b -> y", "x AND y -> a")
      assertEquals(72, year15Day7.part2(input))
    }
  }

}
