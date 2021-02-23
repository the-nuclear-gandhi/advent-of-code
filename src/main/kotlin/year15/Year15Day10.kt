package year15

import shared.Day

class Year15Day10: Day<String>() {
  override fun getInput(): String = inputResource().asString().trim()

  override fun part1(input: String): Int = lookAndSay(input, 40)

  override fun part2(input: String): Any = lookAndSay(input, 50)

  internal fun lookAndSay(startingString: String, times: Int) : Int {
    var digits = startingString.map { it.toString().toInt() }.toList()

    repeat(times) {
      var previousDigit = digits[0]
      var count = 1
      val buffer = mutableListOf<Int>()

      for (i in 1 until digits.size) {
        if (digits[i] == previousDigit) {
          count++
        } else {
          buffer += count
          buffer += previousDigit
          previousDigit = digits[i]
          count = 1
        }
      }

      buffer += count
      buffer += previousDigit
      digits = buffer
    }

    return digits.size
  }
}
