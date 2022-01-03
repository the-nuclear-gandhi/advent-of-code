package shared

abstract class Day<INPUT> {

    fun solve() {
        val input = getInput()

        printResult(part1(input))
        printResult(part2(input))
    }

    internal abstract fun getInput(): INPUT
    internal abstract fun part1(input: INPUT): Any
    internal abstract fun part2(input: INPUT): Any

    internal fun inputResource(): InputResource {
        val year = javaClass.name.substringAfter("Year").substringBefore("Day")
        val day = javaClass.name.substringAfter("Day")

        return InputResource.forName("year$year/day$day.txt")
    }

    private fun printResult(output: Any): Unit = output.let {
        if (it !is Unit) {
            println(it)
        }
    }
}
