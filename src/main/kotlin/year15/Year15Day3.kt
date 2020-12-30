package year15

import shared.Day
import shared.Point

class Year15Day3 : Day {

  private fun nextPoint(point: Point, direction: Char) = when (direction) {
    '>' -> Point(point.x + 1, point.y)
    'v' -> Point(point.x, point.y - 1)
    '<' -> Point(point.x - 1, point.y)
    '^' -> Point(point.x, point.y + 1)
    else -> point
  }

  internal fun part1(s: String): Int {
    var santaLocation = Point(0, 0)
    val visitedPoints = mutableSetOf(santaLocation)

    s.forEach {
      santaLocation = nextPoint(santaLocation, it)
      visitedPoints += santaLocation
    }

    return visitedPoints.size
  }

  internal fun part2(s: String): Int {
    var santaLocation = Point(0, 0)
    val visitedPoints = mutableSetOf(santaLocation)
    var robotSantaLocation = santaLocation

    s.forEachIndexed { index, c ->
      if (index % 2 == 0) {
        santaLocation = nextPoint(santaLocation, c)
        visitedPoints += santaLocation
      } else {
        robotSantaLocation = nextPoint(robotSantaLocation, c)
        visitedPoints += robotSantaLocation
      }
    }

    return visitedPoints.size
  }

  override fun solve() {
    val input = javaClass.classLoader.getResource("year15/day3.txt")!!.readText()

    println(part1(input))
    println(part2(input))
  }
}
