package year16

import core.Day
import core.InputConverter.Companion.trimming
import shared.md5

class Year16Day14 : Day<String>(::trimming) {

    override fun part1(input: String): Int = solve(input, this::simpleHash)

    override fun part2(input: String): Int = solve(input) { salt, index ->
        var hash = simpleHash(salt, index)
        repeat(2016) {
            hash = hash.md5().toHexString()
        }

        hash
    }

    private fun solve(input: String, hashFunction: (salt: String, index: Int) -> String): Int {
        var i = 0
        var foundKeys = 0
        var lastKeyIndex = 0

        val keyCandidates = mutableListOf<Pair<Int, Char>>()
        val keyConfirmations = mutableSetOf<Pair<Int, Char>>()

        while (foundKeys < 64) {
            val hash = hashFunction(input, i)

            hash.windowed(3).firstOrNull { it[1] == it[0] && it[2] == it[0] }
                ?.let { keyCandidates += i to it[0] }

            hash.windowed(5).filter { it.all { c -> c == it[0] } }
                .forEach { keyConfirmations += i to it[0] }

            keyCandidates.filter { i - it.first > 1000 }
                .map { candidate ->
                    candidate.apply {
                        keyConfirmations.firstOrNull { it.first - candidate.first in 1..1000 && it.second == candidate.second }
                            ?.let {
                                foundKeys++
                                lastKeyIndex = candidate.first
                            }
                    }
                }.run {
                    keyCandidates.removeAll(this)
                }

            i++
        }

        return lastKeyIndex
    }

    private fun simpleHash(salt: String, index: Int): String = "$salt$index".md5().toHexString()
}
