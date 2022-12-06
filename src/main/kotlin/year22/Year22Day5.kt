package year22

import shared.Day

class Year22Day5 : Day<String>() {
    override fun getInput(): String = inputResource().asString()

    override fun part1(input: String): String = input.split("\n\n")
        .map { it.lines() }
        .let { (initialState, instructions) ->
            simulate(parseInitialState(initialState), instructions) { it.reversed() }
        }

    override fun part2(input: String): String = input.split("\n\n")
        .map { it.lines() }
        .let { (initialState, instructions) ->
            simulate(parseInitialState(initialState), instructions) { it }
        }

    private fun parseInitialState(containerInput: List<String>): MutableList<MutableList<Char>> {
        val size = containerInput.last()
            .toCharArray()
            .filter { it.isDigit() }
            .maxOf { Integer.parseInt(it.toString()) }
        val state = MutableList(size) { mutableListOf<Char>() }

        containerInput.dropLast(1)
            .reversed()
            .flatMap {
                it.chunked(4)
                    .mapIndexed { index, s ->
                        index to s.firstOrNull { char -> char.isLetter() }
                    }
            }
            .filter { it.second != null }
            .forEach { state[it.first] += it.second!! }

        return state
    }

    private fun simulate(
        state: MutableList<MutableList<Char>>,
        instructions: List<String>,
        containerOrderingRule: (List<Char>) -> List<Char>
    ): String =
        instructions.flatMap { it.split(" ") }
            .mapNotNull { it.toIntOrNull() }
            .chunked(3)
            .map { (count, from, to) ->
                run {
                    state[to - 1] += containerOrderingRule(state[from - 1].takeLast(count))
                    state[from - 1] = state[from - 1].dropLast(count).toMutableList()
                }
            }
            .run {
                state.mapNotNull { it.lastOrNull() }
            }
            .joinToString("")

}
