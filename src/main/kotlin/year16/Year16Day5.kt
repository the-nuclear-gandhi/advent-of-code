package year16

import core.Day
import core.InputConverter.Companion.trimming
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import shared.md5Encode
import java.util.*
import java.util.concurrent.LinkedBlockingQueue

class Year16Day5(private val parallelThreads: Int = 8, private val max: Int = 30_000_000) : Day<String>(::trimming) {

    override fun part1(input: String): String = calculateResults(input) { it.startsWith("00000") }
        .take(8)
        .map { it.hash[5] }
        .joinToString("")

    override fun part2(input: String): String = calculateResults(input) {
        it.startsWith("00000") && it[5].isDigit() && it[5].digitToInt() < 8
    }
        .asSequence()
        .distinctBy { it.hash[5] }
        .sortedBy { it.hash[5].digitToInt() }
        .take(8)
        .map { it.hash[6] }
        .joinToString("")

    private fun calculateResults(input: String, filter: (String) -> Boolean): List<Result> {
        val queue: Queue<Result> = LinkedBlockingQueue(20)
        val numbers = 0..max

        runBlocking {
            numbers.chunked(max / parallelThreads).map { list ->
                async(Dispatchers.Default) {
                    for (i in list) {
                        val pair = i to "$input$i".md5Encode()
                        if (filter(pair.second)) {
                            queue += Result(pair.first, pair.second)
                        }
                    }
                }
            }.awaitAll()
        }

        return queue.sortedBy { it.i }
    }

    private data class Result(val i: Int, val hash: String)
}
