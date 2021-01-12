package year15

import shared.Day

class Year15Day2 : Day<List<String>>() {

  override fun getInput(): List<String> = inputResource().asLines()

  override fun part1(input: List<String>): Long =
    input.map { it.split("x").map { token -> token.toLong() } }
      .map { it.plus(it[0]).zipWithNext { a, b -> a*b } }
      .map { it.map { item -> 2*item }.sum() + it.minOrNull()!! }
      .sum()

  override fun part2(input: List<String>): Long =
    input.map {
      val dimensions = it.split("x").map { token -> token.toLong() }
      val perimeters = dimensions.plus(dimensions[0]).zipWithNext { a, b -> 2*a + 2*b }
      dimensions.reduce { acc, dimension -> acc*dimension } + perimeters.minOrNull()!!
    }
      .sum()
}
