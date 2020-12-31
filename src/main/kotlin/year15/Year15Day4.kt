package year15

import shared.Day
import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

class Year15Day4 : Day {

  internal fun part1(s: String): Long = findHexByPrefix(s, "00000")
  private fun part2(s: String): Long = findHexByPrefix(s, "000000")

  private fun findHexByPrefix(s: String, prefix: String): Long {
    var n = 0L
    while (!md5("$s$n").toHex().startsWith(prefix)) {
      n++
    }
    return n
  }

  private fun md5(str: String): ByteArray = MessageDigest.getInstance("MD5").digest(str.toByteArray(UTF_8))
  private fun ByteArray.toHex() = joinToString("") { "%02x".format(it) }

  override fun solve() {
    val input = javaClass.classLoader.getResource("year15/day4.txt")!!.readText()
      .lines()[0]

    println(part1(input))
    println(part2(input))
  }
}
