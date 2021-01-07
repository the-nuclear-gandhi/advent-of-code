package shared

abstract class Day<INPUT> {

  fun solve() {
    val input = getInput()

    println(part1(input))
    println(part2(input))
  }

  internal abstract fun getInput(): INPUT
  internal abstract fun part1(input: INPUT): Any
  internal abstract fun part2(input: INPUT): Any

  internal fun inputResource(): InputResource {
    val year = javaClass.name.substringAfter("Year").substringBefore("Day")
    val day = javaClass.name.substringAfter("Day")

    return InputResource.forName("year$year/day$day.txt")
  }

}
