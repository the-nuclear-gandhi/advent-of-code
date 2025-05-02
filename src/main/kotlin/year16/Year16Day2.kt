package year16

import core.Day
import core.InputConverter.Companion.toLines
import shared.Direction
import shared.Point

class Year16Day2 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): String {
        val keyboard = arrayOf(
            arrayOf("1", "2", "3"),
            arrayOf("4", "5", "6"),
            arrayOf("7", "8", "9"),
        )

        return calculateMovement(keyboard, Point(1, 1), input)
    }

    override fun part2(input: List<String>): String {
        val keyboard = arrayOf(
            arrayOf("-1", "-1", "1", "-1", "-1"),
            arrayOf("-1", "2", "3", "4", "-1"),
            arrayOf("5", "6", "7", "8", "9"),
            arrayOf("-1", "A", "B", "C", "-1"),
            arrayOf("-1", "-1", "D", "-1", "-1"),
        )

        return calculateMovement(keyboard, Point(2, 0), input)
    }

    private fun calculateMovement(
        keyboard: Array<Array<String>>,
        startingPosition: Point,
        movements: List<String>
    ): String {
        var position = startingPosition

        return movements.joinToString("") { s ->
            s.forEach {
                val direction = Direction.of(it)
                val nextPoint = position.nextInDirection(direction)
                if (nextPoint.x in keyboard.indices && nextPoint.y in keyboard[nextPoint.x].indices && keyboard[nextPoint.x][nextPoint.y] != "-1") {
                    position = nextPoint
                }
            }

            keyboard[position.x][position.y]
        }
    }
}
