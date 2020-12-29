package year15

import shared.Day

class Year15Day1 : Day {

  internal fun part1(s: String): Int =
    s.count { it == '(' } - s.count { it == ')' }

  internal fun part2(s: String): Int {
    var count = 0
    for (i in s.indices) {
      when (s[i]) {
        '(' -> count++
        ')' -> count--
      }

      if (count < 0) {
        return i+1
      }
    }
    return -1
  }

  override fun solve() {
    val input = javaClass.classLoader.getResource("year15/day1.txt")!!.readText()

    println(part1(input))
    println(part2(input))
  }
}
