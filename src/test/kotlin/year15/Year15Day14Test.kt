package year15

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year15Day14Test {

  val year15Day14 = Year15Day14()
  val input = listOf(
    "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.",
    "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.",
  )

  @Nested
  inner class TestPart1 {

    @Test
    fun `should return 1120`() {
      Assertions.assertEquals(1120, year15Day14.solvePart1(input, 1000))
    }
  }

  @Nested
  inner class TestPart2 {

    @Test
    fun `should return 689`() {
      Assertions.assertEquals(689, year15Day14.solvePart2(input, 1000))
    }
  }
}
