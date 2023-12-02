package year23

import core.Day
import core.InputConverter.Companion.toLines

class Year23Day2 : Day<List<String>>(::toLines) {
    override fun part1(input: List<String>): Int = parseInput(input)
        .filter { game -> game.gameSets.all { it.red <= 12 && it.green <= 13 && it.blue <= 14 } }
        .sumOf { it.id }

    override fun part2(input: List<String>): Int = parseInput(input)
        .map { it.gameSets }
        .sumOf { gameSet -> gameSet.maxOf { it.red } * gameSet.maxOf { it.green } * gameSet.maxOf { it.blue } }

    private fun parseInput(input: List<String>): List<Game> = input.map { line ->
        val id = line.substringBefore(":").split(" ")[1].toInt()
        val gameSets = line.substringAfter(":").split(";")
            .map { it.split(",") }
            .map { tokens -> tokens.map { it.trim().split(" ") }.associate { it[1] to it[0].toInt() } }
            .map { GameSet(it["red"] ?: 0, it["green"] ?: 0, it["blue"] ?: 0) }

        Game(id, gameSets)
    }

    private data class GameSet(val red: Int = 0, val green: Int = 0, val blue: Int = 0)
    private data class Game(val id: Int, val gameSets: List<GameSet>)
}
