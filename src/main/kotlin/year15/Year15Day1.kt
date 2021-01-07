package year15

import shared.Day

class Year15Day1 : Day<String>() {

  override fun getInput(): String = inputResource().asString()

  override fun part1(input: String): Int =
    input.count { it == '(' } - input.count { it == ')' }

  override fun part2(input: String): Int {
    var count = 0
    for (i in input.indices) {
      when (input[i]) {
        '(' -> count++
        ')' -> count--
      }

      if (count < 0) {
        return i + 1
      }
    }
    return -1
  }

}
