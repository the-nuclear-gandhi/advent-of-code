package year22

import core.Day
import core.InputConverter.Companion.toLineBlocks
import shared.LineBlock

class Year22Day13 : Day<List<LineBlock>>(::toLineBlocks) {
    override fun part1(input: List<LineBlock>): Int = input.map { parseList(it[0]) to parseList(it[1]) }
        .mapIndexed { index, (left, right) ->
            if (left < right) {
                index + 1
            } else {
                0
            }
        }
        .sum()

    override fun part2(input: List<LineBlock>): Int = run {
        val dividerPacket1 = listOf(listOf(2))
        val dividerPacket2 = listOf(listOf(6))

        input.flatten()
            .filter { it.isNotEmpty() }
            .map { parseList(it) }
            .toMutableList()
            .apply {
                this.add(dividerPacket1)
                this.add(dividerPacket2)
            }
            .sortedWith(MultiTypeListComparator())
            .let {
                (it.indexOf(dividerPacket1) + 1) * (it.indexOf(dividerPacket2) + 1)
            }
    }

    private fun parseList(s: String): List<Any> {
        val contents = s.drop(1).dropLast(1)
        val items = mutableListOf<Any>()
        var i = 0

        while (i in contents.indices) {
            when (contents[i]) {
                '[' -> findMatchingClosingBracket(contents, i).let {
                    items.add(parseList(contents.substring(i..it)))
                    i = it
                }

                ',', ']' -> i++
                else -> findNextSeparator(contents, i).let {
                    items += contents.substring(i..<it).toInt()
                    i = it
                }
            }
        }

        return items.toList()
    }

    private fun findMatchingClosingBracket(s: String, index: Int): Int {
        var balance = 0
        for (i in index..<s.length) {
            when (s[i]) {
                '[' -> balance++
                ']' -> balance--
            }
            if (balance == 0) {
                return i
            }
        }
        throw RuntimeException("Matching closing bracket not found for index=$index in string s=$s")
    }

    private fun findNextSeparator(s: String, index: Int): Int = s.indexOf(",", index).let {
        if (it == -1) {
            s.length
        } else {
            it
        }
    }

    private operator fun List<Any>.compareTo(other: List<Any>): Int = MultiTypeListComparator().compare(this, other)

    private class MultiTypeListComparator : Comparator<List<Any>> {

        @Suppress("UNCHECKED_CAST")
        override fun compare(left: List<Any>, right: List<Any>): Int {
            val leftIterator = left.iterator()
            val rightIterator = right.iterator()

            while (leftIterator.hasNext()) {
                if (!rightIterator.hasNext()) {
                    return 1
                }

                val leftItem = leftIterator.next()
                val rightItem = rightIterator.next()

                val result = when {
                    leftItem is Int && rightItem is Int -> leftItem.compareTo(rightItem)
                    leftItem !is List<*> && rightItem is List<*> -> compare(listOf(leftItem), rightItem as List<Any>)
                    leftItem is List<*> && rightItem !is List<*> -> compare(leftItem as List<Any>, listOf(rightItem))
                    else -> compare(leftItem as List<Any>, rightItem as List<Any>)
                }

                if (result != 0) {
                    return result
                }
            }

            return if (rightIterator.hasNext()) {
                -1
            } else {
                0
            }
        }

    }
}
