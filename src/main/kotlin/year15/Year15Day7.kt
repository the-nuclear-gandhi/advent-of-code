package year15

import shared.Day

class Year15Day7 : Day<List<String>>() {

    override fun getInput(): List<String> = inputResource().asLines()

    override fun part1(input: List<String>): Int = input.associate {
        val tokens = it.split(" -> ")
        tokens[1] to tokens[0]
    }
        .toMutableMap()
        .let { getWireValue(it, "a") }

    private fun getWireValue(map: MutableMap<String, String>, wireCode: String): Int {
        val value = map[wireCode]!!

        val result = value.toIntOrNull() ?: ( run {
            val tokens = value.split(" ")
            when {
                value.contains("AND") -> (tokens.first().toIntOrNull() ?: getWireValue(
                    map,
                    tokens.first()
                )) and getWireValue(map, tokens.last())
                value.contains("OR") -> (tokens.first().toIntOrNull() ?: getWireValue(
                    map,
                    tokens.first()
                )) or getWireValue(map, tokens.last())
                value.contains("LSHIFT") -> getWireValue(map, tokens.first()) shl tokens.last().toInt()
                value.contains("RSHIFT") -> getWireValue(map, tokens.first()) shr tokens.last().toInt()
                value.contains("NOT") -> getWireValue(map, tokens.last()).inv()
                else -> getWireValue(map, tokens.first())
            }
        } and 65535 )

        map[wireCode] = result.toString()

        return result
    }

    override fun part2(input: List<String>): Int = part1(input + "${part1(input)} -> b")

}
