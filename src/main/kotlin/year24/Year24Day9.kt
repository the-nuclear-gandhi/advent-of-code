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
            val (spaceIndices, spaceLengths) = calculateSpaces()

            while (fileId > 0) {
                val fileIndex = state.indexOf(fileId)
                var fileLength = 0
                var fileBit = fileIndex
                while (state[fileBit] == fileId) {
                    fileLength++
                    fileBit++
                }

                spaceLengths.indexOfFirst { it >= fileLength }.takeIf { it > -1 && spaceIndices[it] < fileIndex }?.let {
                    (spaceIndices[it] until spaceIndices[it] + fileLength).forEach { index ->
                        state[index] = fileId
                    }

                    (fileIndex until fileIndex + fileLength).forEach { index ->
                        state[index] = 0
                    }

                    spaceLengths[it] -= fileLength
                    spaceIndices[it] += fileLength

                    if (spaceLengths[it] == 0) {
                        spaceIndices[it] = -1
                    }
                }

                fileId--
            }
        }

        fun checksum(): Long = state.mapIndexed { index, i -> index * i.toLong() }.sum()

        private fun calculateSpaces(): Pair<IntArray, IntArray> {
            val maxIndex = state.indexOfLast { it != 0 }

            val spaceIndices =
                state.indices.filter { it == firstFileLength || (it > firstFileLength && state[it] == 0 && state[it - 1] != 0) }
                    .filter { it <= maxIndex }
                    .toIntArray()

            val spaceLengths = spaceIndices.map {
                var length = 0
                var i = it
                while (i in state.indices && state[i] == 0) {
                    length++
                    i++
                }

                length
            }.toIntArray()

            return spaceIndices to spaceLengths
        }
    }
}
