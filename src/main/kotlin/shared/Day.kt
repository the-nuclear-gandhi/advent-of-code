package shared

abstract class Day<INPUT> {

  internal abstract fun getInput(): INPUT
  internal abstract fun part1(input: INPUT): Any
  internal abstract fun part2(input: INPUT): Any

  internal fun inputResource(): String {
    val year = javaClass.name.substringAfter("Year").substringBefore("Day")
    val day = javaClass.name.substringAfter("Day")

    val resource = javaClass.classLoader.getResource("year${year}/day${day}.txt")
      ?: throw RuntimeException("Input Resource for ${javaClass.name} not found")

    return resource.readText()
  }

  fun solve() {
    val input = getInput()

    println(part1(input))
    println(part2(input))
  }

}
