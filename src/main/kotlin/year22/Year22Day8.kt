package year22

import shared.Day

class Year22Day8 : Day<List<String>>() {
    override fun getInput(): List<String> = inputResource().asLines()

    override fun part1(input: List<String>): Int = input.toIntGrid()
        .let { rows ->
            rows.mapIndexed { rowIndex, row ->
                when (rowIndex) {
                    0, rows.size - 1 -> row.size
                    else -> row.mapIndexed { columnIndex, i ->
                        val column = rows.map { items -> items[columnIndex] }
                        when (columnIndex) {
                            0, row.size - 1 -> 1
                            else -> when {
                                row.splitAtIndex(columnIndex).any { list -> list.all { it < i } } -> 1
                                column.splitAtIndex(rowIndex).any { list -> list.all { it < i } } -> 1
                                else -> 0
                            }
                        }
                    }.sum()
                }
            }.sum()
        }

    override fun part2(input: List<String>): Int = input.toIntGrid()
        .let { rows ->
            rows.mapIndexed { rowIndex, row ->
                when (rowIndex) {
                    0, rows.size - 1 -> 0
                    else -> row.mapIndexed { columnIndex, i ->
                        val column = rows.map { items -> items[columnIndex] }
                        when (columnIndex) {
                            0, row.size - 1 -> 0
                            else ->
                                listOf(row.splitAtIndex(columnIndex), column.splitAtIndex(rowIndex))
                                    .flatMap { listOf(it[0].reversed(), it[1]) }
                                    .map {
                                        it.takeWhile { item -> item < i } + it.dropWhile { item -> item < i }.take(1)
                                    }
                                    .map { it.size }
                                    .reduce { acc, it -> acc * it }
                        }
                    }.max()
                }

            }.max()
        }

    private fun List<String>.toIntGrid(): List<List<Int>> = this.map { s -> s.map { it.toString().toInt() } }

    private fun List<Int>.splitAtIndex(index: Int): List<List<Int>> =
        listOf(this.subList(0, index), this.subList(index + 1, this.size))
}
