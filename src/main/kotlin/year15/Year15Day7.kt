package year15

import core.Day
import core.InputConverter.Companion.toLines

class Year15Day7 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = input.associate {
        val tokens = it.split(" -> ")
        tokens[1] to tokens[0]
    }
        .toMutableMap()
        .let { getWireValue(it, "a") }

    private fun getWireValue(map: MutableMap<String, String>, wireCode: String): Int =
        map[wireCode]?.let {
            val result = it.toIntOrNull() ?: (run {
                val tokens = it.split(" ")
                when {
                    it.contains("AND") -> (tokens.first().toIntOrNull() ?: getWireValue(
                        map,
                        tokens.first()
                    )) and getWireValue(map, tokens.last())

                    it.contains("OR") -> (tokens.first().toIntOrNull() ?: getWireValue(
                        map,
                        tokens.first()
                    )) or getWireValue(map, tokens.last())

                    it.contains("LSHIFT") -> getWireValue(map, tokens.first()) shl tokens.last().toInt()
                    it.contains("RSHIFT") -> getWireValue(map, tokens.first()) shr tokens.last().toInt()
                    it.contains("NOT") -> getWireValue(map, tokens.last()).inv()
                    else -> getWireValue(map, tokens.first())
                }
            } and 65535)

            map[wireCode] = result.toString()

            result
        } ?: throw RuntimeException("Wire with code $wireCode not found in wire map")

    override fun part2(input: List<String>): Int = part1(input + "${part1(input)} -> b")

}
