package year15

import core.Day
import core.InputConverter.Companion.trimming
import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

class Year15Day4 : Day<String>(::trimming) {

    override fun part1(input: String): Long = findHexByPrefix(input, "00000")
    override fun part2(input: String): Long = findHexByPrefix(input, "000000")

    private fun findHexByPrefix(s: String, prefix: String): Long {
        var n = 0L
        while (!md5("$s$n").toHex().startsWith(prefix)) {
            n++
        }
        return n
    }

    private fun md5(str: String): ByteArray = MessageDigest.getInstance("MD5").digest(str.toByteArray(UTF_8))
    private fun ByteArray.toHex() = joinToString("") { "%02x".format(it) }

}
