package year23

import core.Day
import core.InputConverter.Companion.toLines

class Year23Day14 : Day<List<String>>(::toLines) {
    override fun part1(input: List<String>): Int =
        loadOnNorthBeams(tilt(input, onNorthAxis = true, reversedDirection = false))

    override fun part2(input: List<String>): Int {
        val cycleResult = mutableListOf<List<String>>()
        var cycleCount = 0
        var map = input
        do {
            cycleResult += map
            map = tilt(map, onNorthAxis = true, reversedDirection = false)
            map = tilt(map, onNorthAxis = false, reversedDirection = false)
            map = tilt(map, onNorthAxis = true, reversedDirection = true)
            map = tilt(map, onNorthAxis = false, reversedDirection = true)

            cycleCount++
        } while (map !in cycleResult)

        val cycleStart = cycleResult.indexOf(map)
        val stateAtEnd = (1_000_000_000 - cycleStart) % (cycleCount - cycleStart)

        return loadOnNorthBeams(cycleResult[cycleStart + stateAtEnd])
    }

    private fun loadOnNorthBeams(input: List<String>): Int = input
        .mapIndexed { index, s -> s.count { it == 'O' } * (input.size - index) }
        .sum()

    private fun tilt(input: List<String>, onNorthAxis: Boolean, reversedDirection: Boolean): List<String> = input.run {
        this.columns().takeIf { onNorthAxis } ?: this
    }
        .map { it.reversed().takeIf { reversedDirection } ?: it }
        .map { moveStones(it.toMutableList()) }
        .let {
            when {
                !onNorthAxis && !reversedDirection -> it
                !onNorthAxis && reversedDirection -> it.map { list -> list.reversed() }
                onNorthAxis && !reversedDirection -> it.indices.map { index -> it.map { s -> s[index] } }
                else -> it.indices.map { index -> it.map { s -> s[index] } }.reversed()
            }
                .map { chars -> String(chars.toCharArray()) }
        }

    private fun moveStones(input: MutableList<Char>): List<Char> = input.apply {
        this.mapIndexedNotNull { index, c -> index.takeIf { c == 'O' } }
            .forEach { index ->
                this.subList(0, index).reversed()
                    .takeWhile { it == '.' }
                    .size
                    .takeIf { it > 0 }
                    ?.let {
                        this[index - it] = 'O'
                        this[index] = '.'
                    }
            }
    }


    private fun List<String>.columns() =
        this[0].indices.map { index -> this.map { it[index] } }.map { String(it.toCharArray()) }
}
