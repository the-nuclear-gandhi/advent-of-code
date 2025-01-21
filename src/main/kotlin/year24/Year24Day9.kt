package year24

import core.Day
import core.InputConverter.Companion.trimming

class Year24Day9 : Day<String>(::trimming) {

    override fun part1(input: String): Long = FileSystem.fromString(input).let {
        it.moveBits()
        it.checksum()
    }

    override fun part2(input: String): Long = FileSystem.fromString(input).let {
        it.moveFiles()
        it.checksum()
    }

    private class FileSystem private constructor(files: IntArray, spaces: IntArray) {

        private val state: IntArray = IntArray(files.size * 10)
        private val firstFileLength: Int = files[0]

        init {
            var fsId = 0

            files.indices.forEach { fileId ->
                (fsId until fsId + files[fileId]).forEach {
                    state[it] = fileId
                }
                fsId += files[fileId]

                if (fileId in spaces.indices) {
                    (fsId until fsId + spaces[fileId]).forEach {
                        state[it] = 0
                    }
                    fsId += spaces[fileId]
                }
            }
        }

        companion object {
            fun fromString(s: String): FileSystem {
                val files = s.mapIndexedNotNull { index, c -> c.digitToInt().takeIf { index.isEven() } }.toIntArray()
                val spaces = s.mapIndexedNotNull { index, c -> c.digitToInt().takeIf { !index.isEven() } }.toIntArray()

                return FileSystem(files, spaces)
            }

            private fun Int.isEven(): Boolean = this % 2 == 0
        }

        fun moveBits() {
            var spaceBit = firstFileLength
            var backwardFileBit = state.indexOfLast { it != 0 }

            while (spaceBit < backwardFileBit) {
                state[spaceBit] = state[backwardFileBit]
                state[backwardFileBit] = 0
                backwardFileBit--
                spaceBit++

                while (state[backwardFileBit] == 0) {
                    backwardFileBit--
                }

                while (state[spaceBit] != 0) {
                    spaceBit++
                }
            }
        }

        fun moveFiles() {
            var fileId = state.last { it != 0 }
            var spaces = calculateSpaces()

            while (fileId > 0) {
                val fileIndex = state.indexOf(fileId)
                val fileLength = state.count { it == fileId }

                spaces.firstOrNull { it.second >= fileLength && it.first < fileIndex }?.let {
                    (it.first until it.first + fileLength).forEach { index ->
                        state[index] = fileId
                    }

                    (fileIndex until fileIndex + fileLength).forEach { index ->
                        state[index] = 0
                    }

                    spaces = spaces.toMutableList().apply {
                        if (it.second > fileLength) {
                            val spaceIndex = this.indexOf(it)
                            this.add(spaceIndex + 1, it.first + fileLength to it.second - fileLength)
                        }

                        this -= it
                    }.toList()
                }

                fileId--
            }
        }

        fun checksum(): Long = state.mapIndexed { index, i -> index * i.toLong() }.sum()

        private fun calculateSpaces(): List<Pair<Int, Int>> = buildList {
            val maxIndex = state.indexOfLast { it != 0 }

            var spaceIndex = firstFileLength
            var length = 0

            for (i in firstFileLength..maxIndex) {
                when (state[i]) {
                    0 -> {
                        if (length == 0) {
                            spaceIndex = i
                        }
                        length++
                    }

                    else -> if (length != 0) {
                        this += spaceIndex to length
                        length = 0
                    }
                }
            }
        }
    }
}
