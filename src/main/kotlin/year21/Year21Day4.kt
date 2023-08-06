package year21

import core.Day
import core.InputConverter.Companion.noOp

class Year21Day4 : Day<String>(::noOp) {

    override fun part1(input: String): Long = parseInput(input).gameStateAtFirstWinner().let {
        calculateResult(it.first, it.second)
    }

    override fun part2(input: String): Long = parseInput(input).gameStateAtLastWinner().let {
        calculateResult(it.first, it.second)
    }

    private fun parseInput(input: String): GameOfBingo {
        val lines = input.lines()
        val numbers = lines[0].split(",")
            .map { it.toInt() }
            .toList()

        val boards = lines.subList(2, lines.size)
            .filterNot { it.isBlank() }
            .map {
                it.split(" ")
                    .filterNot { token -> token.isBlank() }
                    .map { token -> BingoNumber(token.toInt()) }
            }
            .chunked(5)
            .map { BingoBoard(it) }

        return GameOfBingo(numbers, boards)
    }

    private fun calculateResult(board: BingoBoard, lastDrawnNumber: Int): Long =
        lastDrawnNumber.toLong() *
            board.numbers.flatten()
                .filterNot { it.marked }
                .sumOf { it.value }

    private data class BingoNumber(val value: Int, var marked: Boolean = false)

    private data class BingoBoard(val numbers: List<List<BingoNumber>>) {
        fun mark(n: Int) = numbers.flatten()
            .filter { it.value == n }
            .forEach { it.marked = true }

        fun hasWon(): Boolean = hasMarkedRow() || hasMarkedColumn()

        private fun hasMarkedColumn(): Boolean =
            numbers.indices.any { numbers.map { row -> row[it] }.all { number -> number.marked } }

        private fun hasMarkedRow(): Boolean = numbers.any { it.all { number -> number.marked } }
    }

    private data class GameOfBingo(val numbers: List<Int>, val boards: List<BingoBoard>) {

        fun gameStateAtFirstWinner(): Pair<BingoBoard, Int> {
            for (n in numbers) {
                val winningBoard = boards.onEach { it.mark(n) }
                    .firstOrNull { it.hasWon() }

                if (winningBoard != null) {
                    return Pair(winningBoard, n)
                }
            }

            throw RuntimeException("No one has won the game, something wrong with the input data?")
        }

        fun gameStateAtLastWinner(): Pair<BingoBoard, Int> {
            val boardIndicesThatWon = mutableSetOf<Int>()

            for (n in numbers) {
                boards.onEach { it.mark(n) }
                    .filter { it.hasWon() }
                    .forEach { boardIndicesThatWon.add(boards.indexOf(it)) }

                if (boardIndicesThatWon.size == boards.size) {
                    return Pair(boards[boardIndicesThatWon.last()], n)
                }
            }

            throw RuntimeException("No last winning board found, something wrong with the input data?")
        }
    }
}
