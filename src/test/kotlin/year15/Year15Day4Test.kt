package year15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year15Day4Test {

  val year15Day4 = Year15Day4()

  @Nested
  inner class TestPart1 {

    @Test
    fun `should return 609043`() {
      assertEquals(609043, year15Day4.part1("abcdef"))
    }

    @Test
    fun `should return 1048970`() {
      assertEquals(1048970, year15Day4.part1("pqrstuv"))
    }
  }

}
