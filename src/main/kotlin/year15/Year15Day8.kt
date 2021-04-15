package year15

import shared.Day

class Year15Day8 : Day<List<String>>() {

  override fun getInput(): List<String> = inputResource().asLines()

  override fun part1(input: List<String>): Int =
    input.sumOf {
      it.length + 2 -
        it.replace("\\\\", "a")
          .replace("\\\"", "a")
          .replace(Regex("\\\\x[a-z0-9]{2}"), "a")
          .length
    }

  override fun part2(input: List<String>): Int =
    input.sumOf {
      it.replace("\"", "aa")
        .replace("\\", "aa")
        .length - it.length + 2
    }

}
