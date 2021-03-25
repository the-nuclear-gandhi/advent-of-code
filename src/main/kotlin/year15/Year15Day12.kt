package year15

import shared.Day

class Year15Day12 : Day<String>() {
  override fun getInput(): String = inputResource().asString()

  override fun part1(input: String): Int = input.split(Regex("[^0-9\\-]"))
    .mapNotNull { it.toIntOrNull() }
    .sum()

  override fun part2(input: String): Any {
    val pattern = ":\"red\""
    var sanitizedInput = input

    while (sanitizedInput.contains(pattern)) {
      val redPosition = sanitizedInput.indexOf(pattern)

      val enclosingObjectStart =
        findFirstUnbalancedBracketPositionInRange(sanitizedInput, '{', redPosition downTo 0)
      val enclosingObjectEnd =
        findFirstUnbalancedBracketPositionInRange(sanitizedInput, '}', redPosition + pattern.length..input.length)

      sanitizedInput = sanitizedInput.replaceRange(enclosingObjectStart + 1 until enclosingObjectEnd, "")
    }

    return part1(sanitizedInput)
  }

  private fun findFirstUnbalancedBracketPositionInRange(s: String, c: Char, range: IntProgression): Int {
    var bracketCount = 0

    for (i in range) {
      if (s[i] == c && bracketCount == 0) {
        return i
      } else when (s[i]) {
        '{' -> bracketCount++
        '}' -> bracketCount--
      }
    }

    return -1
  }
}
