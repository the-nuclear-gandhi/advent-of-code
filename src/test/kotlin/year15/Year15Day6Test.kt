package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year15Day6Test {

  val year15Day6 = Year15Day6()

  @Nested
  inner class TestPart1 {

    @Test
    fun `should return 0`() {
      val input = listOf<String>()
      assertEquals(0, year15Day6.part1(input))
    }

    @Test
    fun `should return 9`() {
      val input = listOf("turn on 0,0 through 2,2")
      assertEquals(9, year15Day6.part1(input))
    }

    @Test
    fun `should return 4`() {
      val input = listOf("toggle 499,499 through 500,500")
      assertEquals(4, year15Day6.part1(input))
    }

    @Test
    fun `should return 13`() {
      val input = listOf("turn on 0,0 through 2,2", "toggle 499,499 through 500,500")
      assertEquals(13, year15Day6.part1(input))
    }

  }

  @Nested
  inner class TestPart2 {

    @Test
    fun `should return 1`() {
      val input = listOf("turn on 0,0 through 0,0")
      assertEquals(1, year15Day6.part2(input))
    }

    @Test
    fun `should return 2000000`() {
      val input = listOf("toggle 0,0 through 999,999")
      assertEquals(2000000, year15Day6.part2(input))
    }

  }

}
