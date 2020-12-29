package year15

import shared.Day

class Year15Day2 : Day {

  internal fun part1(lines: List<String>): Long =
    lines.map { it.split("x").map { token -> token.toLong() } }
      .map { it.plus(it[0]).zipWithNext { a, b -> a*b } }
      .map { it.map { item -> 2*item }.sum() + it.minOrNull()!! }
      .sum()

  internal fun part2(lines: List<String>): Long =
    lines.map {
      val dimensions = it.split("x").map { token -> token.toLong() }
      val perimeters = dimensions.plus(dimensions[0]).zipWithNext { a, b -> 2*a + 2*b }
      dimensions.reduce { acc, dimension -> acc*dimension } + perimeters.minOrNull()!!
    }
      .sum()

  override fun solve() {
    val input = javaClass.classLoader.getResource("year15/day2.txt")!!.readText()
      .lines()
      .filterNot { it.isEmpty() }

    println(part1(input))
    println(part2(input))
  }

}
