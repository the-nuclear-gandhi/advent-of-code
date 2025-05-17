package year16

import core.Day
import core.InputConverter.Companion.trimming
import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

class Year16Day5 : Day<String>(::trimming) {

    override fun part1(input: String): String {
        var password = ""
        var i = 0
        while (password.length < 8) {
            val hash = md5("$input$i").toHex()
            if (hash.startsWith("00000")) {
                password += hash[5]
            }
            i++
        }

        return password
    }

    override fun part2(input: String): String {
        val password = CharArray(8) { ' ' }
        var i = 0
        var foundChars = 0

        while (foundChars < password.size) {
            val hash = md5("$input$i").toHex()
            if (hash.startsWith("00000") && hash[5].isDigit() && hash[5].digitToInt() < password.size) {
                val index = hash[5].digitToInt()
                if (!password[index].isLetterOrDigit()) {
                    password[index] = hash[6]
                    foundChars++
                }
            }

            i++
        }

        return password.joinToString("")
    }

    private fun md5(str: String): ByteArray = MessageDigest.getInstance("MD5").digest(str.toByteArray(UTF_8))
    private fun ByteArray.toHex() = joinToString("") { "%02x".format(it) }
}
