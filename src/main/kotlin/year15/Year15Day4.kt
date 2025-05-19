package year15

import core.Day
import core.InputConverter.Companion.trimming
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import shared.md5Encode
import java.util.Queue
import java.util.concurrent.LinkedBlockingQueue

class Year15Day4(private val parallelThreads: Int = 8, private val max: Int = 10_000_000) : Day<String>(::trimming) {

    override fun part1(input: String): Int = findHexByPrefix(input, "00000")
    override fun part2(input: String): Int = findHexByPrefix(input, "000000")

    private fun findHexByPrefix(s: String, prefix: String): Int {
        val results: Queue<Int> = LinkedBlockingQueue(20)

        runBlocking {
            (0..max).chunked(max / parallelThreads).map { list ->
                async(Dispatchers.Default) {
                    for (i in list) {
                        if ("$s$i".md5Encode().startsWith(prefix)) {
                            results += i
                        }
                    }
                }
            }.awaitAll()
        }

        return results.minOf { it }
    }
}
