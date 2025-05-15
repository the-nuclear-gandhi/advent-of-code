package year16

import core.Day
import core.InputConverter.Companion.toLines

class Year16Day4 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = parseRooms(input).filter(Room::isValid).sumOf { it.sectorId }

    override fun part2(input: List<String>): Int = parseRooms(input).filter(Room::isValid)
        .firstOrNull { it.getRealName().contains("northpole") }
        ?.sectorId ?: -1

    private fun parseRooms(input: List<String>): List<Room> = input.map {
        val name = it.substringBeforeLast("-")
        val sectorId = it.substringAfterLast("-").substringBefore("[").toInt()
        val checksum = it.substringAfter("[").substringBefore("]")

        Room(name, sectorId, checksum)
    }

    private data class Room(val name: String, val sectorId: Int, val checksum: String) {

        fun isValid(): Boolean {
            val groups = name.replace("-", "").groupingBy { it }.eachCount()

            val keyComparator = compareByDescending<Char> { groups.getValue(it) }.thenBy { it }

            return groups.keys.sortedWith(keyComparator).take(checksum.length).joinToString("") == checksum
        }

        fun getRealName(): String {
            var name = this.name.replace("-", " ")
            repeat(sectorId) {
                name = name.map {
                    when (it) {
                        'z' -> 'a'
                        ' ' -> ' '
                        else -> it.inc()
                    }
                }.joinToString("")
            }

            return name
        }
    }
}
