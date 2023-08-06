package core

import shared.LineBlock
import shared.toLineBlocks

class InputConverter private constructor() {

    companion object {
        fun noOp(input: String): String = input

        fun toInts(input: String): List<Int> = toLines(input).map { it.toInt() }

        fun toLines(input: String): List<String> = input.lines().filter { it.isNotBlank() }

        fun toLineBlocks(input: String): List<LineBlock> = input.toLineBlocks()

        fun trimming(input: String): String = input.trim()
    }

}
