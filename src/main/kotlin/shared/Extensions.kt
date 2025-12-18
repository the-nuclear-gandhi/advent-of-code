package shared

import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

/**
 * Splits a string on empty lines and returns all resulting non-empty blocks which in turn can be split into lines.
 */
fun String.toLineBlocks(): List<LineBlock> = this.split("\n\n")
    .filter { it.isNotEmpty() }
    .map { it.lines() }

fun String.toIntList(separator: String = " "): List<Int> = this.toList<Int>(separator)

fun String.toLongList(separator: String = " "): List<Long> = this.toList<Long>(separator)

private inline fun <reified T : Number> String.toList(separator: String = " "): List<T> = this.split(separator)
    .filter { it.isNotEmpty() }
    .mapNotNull {
        when (T::class) {
            Int::class -> it.toIntOrNull() as T?
            Long::class -> it.toLongOrNull() as T?
            else -> throw RuntimeException("Unsupported type parameter")
        }
    }

fun String.md5(): ByteArray = MessageDigest.getInstance("MD5").digest(toByteArray(UTF_8))
