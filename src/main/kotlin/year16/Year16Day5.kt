package year16

import core.Day
import core.InputConverter.Companion.trimming
import shared.md5
import kotlin.experimental.and

class Year16Day5 : Day<String>(::trimming) {

    override fun part1(input: String): String {
        val generator = MD5Generator(input)
        var result = ""
        while (result.length < 8) {
            val md5 = generator.next()
            result += md5[2].toHexString()[1]
        }
        return result
    }

    override fun part2(input: String): String {
        val generator = MD5Generator(input)
        val result = CharArray(8)
        val foundChars = BooleanArray(8) { false }

        while (foundChars.any { !it }) {
            val md5 = generator.next()
            val position = (md5[2] and 0x0f.toByte()).toInt()
            if (position < 8 && !foundChars[position]) {
                result[position] = md5[3].toHexString()[0]
                foundChars[position] = true
            }
        }

        return result.joinToString("")
    }

    private class MD5Generator(val salt: String) {

        private var i = 0

        fun next(): ByteArray {
            while (true) {
                val md5 = "$salt$i".md5()
                i++
                if (md5[0] and 0xff.toByte() == 0.toByte() && md5[1] and 0xff.toByte() == 0.toByte() && md5[2] and 0xf0.toByte() == 0.toByte()) {
                    return md5
                }
            }
        }
    }
}
