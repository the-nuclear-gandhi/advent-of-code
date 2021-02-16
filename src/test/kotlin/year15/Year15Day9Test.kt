package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year15Day9Test {

  val year15Day9 = Year15Day9()
  val input = listOf("London to Dublin = 464", "London to Belfast = 518", "Dublin to Belfast = 141")

  @Nested
  inner class TestPart1 {

    @Test
    fun `should return 605`() {
      assertEquals(605, year15Day9.part1(input))
    }
  }

  @Nested
  inner class TestPart2 {
    @Test
    fun `should return 982`() {
      assertEquals(982, year15Day9.part2(input))
    }
  }

}
