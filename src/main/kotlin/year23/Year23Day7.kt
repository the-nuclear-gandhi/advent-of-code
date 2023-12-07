package year23

import core.Day
import core.InputConverter.Companion.toLines

class Year23Day7 : Day<List<String>>(::toLines) {
    override fun part1(input: List<String>): Int = solve(input, PlainGame())

    override fun part2(input: List<String>): Int = solve(input, JokerGame())

    private fun solve(input: List<String>, gameRules: Game): Int = input.asSequence()
        .map { it.split(" ") }
        .map { Hand(it[0], it[1].toInt()) }
        .sortedWith(gameRules)
        .mapIndexed { index, hand -> hand.bet * (index + 1) }
        .sum()

    private sealed interface Game : Comparator<Hand> {
        fun cards(hand: Hand): List<Int>
        fun strength(hand: Hand): Int
        override fun compare(h1: Hand, h2: Hand): Int = (strength(h1) - strength(h2)).takeIf { it != 0 }
            ?: cards(h1).indices.map { cards(h1)[it] - cards(h2)[it] }
                .firstOrNull { it != 0 } ?: 0
    }

    private open class PlainGame : Game {

        override fun cards(hand: Hand): List<Int> = hand.value.map { cardToInt(it) }
        override fun strength(hand: Hand): Int = cards(hand).groupBy { it }.let { groups ->
            when (groups.size) {
                1 -> 6
                2 -> if (groups.any { it.value.size == 4 }) {
                    5
                } else {
                    4
                }

                3 -> if (groups.any { it.value.size == 3 }) {
                    3
                } else {
                    2
                }

                4 -> 1
                else -> 0
            }
        }

        fun cardToInt(card: Char): Int = when (card) {
            'T' -> 10
            'J' -> 11
            'Q' -> 12
            'K' -> 13
            'A' -> 14
            else -> card.digitToInt()
        }
    }

    private class JokerGame : PlainGame() {
        override fun cards(hand: Hand): List<Int> = hand.value.map {
            if (it == 'J') {
                1
            } else {
                cardToInt(it)
            }
        }

        override fun strength(hand: Hand): Int = cards(hand).groupBy { it }.let { groups ->
            when (groups.getOrDefault(1, listOf()).size) {
                1 -> when (groups.size) {
                    2 -> 6
                    3 -> when {
                        groups.any { it.value.size == 3 } -> 5
                        groups.count { it.value.size == 2 } == 2 -> 4
                        groups.count { it.value.size == 2 } == 1 -> 3
                        else -> 1
                    }

                    4 -> 3
                    else -> 1
                }

                2 -> when (groups.size) {
                    2 -> 6
                    3 -> 5
                    else -> 3
                }

                3 -> when (groups.size) {
                    2 -> 6
                    else -> 5
                }

                4, 5 -> 6
                else -> super.strength(hand)
            }
        }
    }

    private data class Hand(val value: String, val bet: Int)
}
