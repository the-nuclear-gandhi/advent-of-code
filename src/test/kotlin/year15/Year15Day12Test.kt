package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class Year15Day12Test {

  val year15Day12 = Year15Day12()

  @Nested
  inner class TestPart1 {

    @Test
    fun `should return 6`() {
      val input = "{\"a\":2,\"b\":4}"
      assertEquals(6, year15Day12.part1(input))
    }

    @Test
    fun `should return 3`() {
      val input = "{\"a\":{\"b\":4},\"c\":-1}"
      assertEquals(3, year15Day12.part1(input))
    }
  }

  @Nested
  inner class TestPart2 {

    @ParameterizedTest
    @ValueSource(strings = ["[1,2,3]", "[1,\"red\",5]"])
    fun `should return 6`(input: String) {
      assertEquals(6, year15Day12.part2(input))
    }

    @Test
    fun `should return 4`() {
      val input = "[1,{\"c\":\"red\",\"b\":2},3]"
      assertEquals(4, year15Day12.part2(input))
    }

    @Test
    fun `should return 0`() {
      val input = "{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}"
      assertEquals(0, year15Day12.part2(input))
    }
  }
}
