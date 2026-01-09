package year16

import core.Day
import core.InputConverter.Companion.trimming
import shared.toIntList

class Year16Day9 : Day<String>(::trimming) {

    override fun part1(input: String): Int = Tokenizer.tokenize(input).sumOf { it.length() }

    override fun part2(input: String): Long = Tokenizer.tokenize(input).sumOf { it.recursiveLength() }

    private class Tokenizer {

        companion object {
            fun tokenize(input: String): List<Token> {
                var i = 0
                var buffer = ""
                val result = mutableListOf<Token>()

                while (i in input.indices) {
                    if (input[i] != '(') {
                        buffer += input[i]
                        i++
                    } else {
                        if (buffer.isNotEmpty()) {
                            result += StringToken.fromString(buffer)
                            buffer = ""
                        }

                        val markerEndIndex = input.indexOf(')', i)
                        val markerHeader = input.substring(i + 1, markerEndIndex)
                        val length = markerHeader.toIntList("x")[0]
                        val markerContents = input.substring(i, markerEndIndex + 1 + length)

                        result += MarkerToken.fromString(markerContents)
                        i = markerEndIndex + 1 + length
                    }
                }

                if (buffer.isNotEmpty()) {
                    result += StringToken.fromString(buffer)
                }

                return result.toList()
            }
        }

    }

    private interface Token {
        fun length(): Int
        fun recursiveLength(): Long
    }

    private class StringToken private constructor(val content: String) : Token {

        companion object {
            fun fromString(content: String) = StringToken(content)
        }

        override fun length(): Int = this.content.length

        override fun recursiveLength(): Long = this.length().toLong()
    }

    private class MarkerToken private constructor(val content: String) : Token {

        companion object {
            fun fromString(content: String) = MarkerToken(content)
        }

        override fun length(): Int {
            val (length, times) = content.substringAfter("(")
                .substringBefore(")")
                .toIntList("x")

            return length * times
        }

        override fun recursiveLength(): Long {
            val times = content.substringAfter("(")
                .substringBefore(")")
                .toIntList("x")
                .last()

            val newContent = content.substringAfter(")")

            return times * Tokenizer.tokenize(newContent).sumOf { it.recursiveLength() }
        }
    }
}
