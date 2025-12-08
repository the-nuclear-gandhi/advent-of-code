package year25

import core.Day
import core.InputConverter.Companion.toLines
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

class Year25Day8(val connections: Int = 1000) : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Long = parseInput(input).let { (points, distances) ->
        var connectionGroupId = 0

        distances.entries.sortedBy { it.value }
            .take(connections)
            .map { it.key }
            .forEach { (i, j) -> connectionGroupId = createConnection(points, connectionGroupId, i, j) }

        points.groupBy { it.connectionGroup }
            .mapNotNull { entry -> entry.value.size.toLong().takeIf { entry.key != -1 } }
            .sortedDescending()
            .take(3)
            .reduce(Long::times)
    }

    override fun part2(input: List<String>): Long = parseInput(input).let { (points, distances) ->
        var connectionGroupId = 0

        var key: Pair<Int, Int>? = null
        val iterator = distances.entries.sortedBy { it.value }.iterator()
        while (points.any { it.connectionGroup == -1 } || points.map { it.connectionGroup }.distinct().size > 1) {
            key = iterator.next().key
            connectionGroupId = createConnection(points, connectionGroupId, key.first, key.second)
        }

        key?.let { (i, j) -> points[i].x.toLong() * points[j].x } ?: throw RuntimeException("No solution found")
    }

    private fun parseInput(input: List<String>): Pair<List<Point3D>, Map<Pair<Int, Int>, Double>> =
        input.map { it.toPoint3D() }
            .let { points ->
                val distances = LinkedHashMap<Pair<Int, Int>, Double>(connections)
                for (i in points.indices) {
                    val p1 = points[i]
                    for (j in i + 1 until points.size) {
                        val p2 = points[j]
                        val distance = p1.distance(p2)
                        distances[i to j] = distance
                    }
                }

                points to distances
            }

    private fun createConnection(points: List<Point3D>, currentConnectionGroupId: Int, i: Int, j: Int): Int {
        var connectionGroupId = currentConnectionGroupId
        val groupFirst = points[i].connectionGroup
        val groupSecond = points[j].connectionGroup

        when {
            groupFirst != -1 && groupSecond == -1 -> points[j].connectionGroup = groupFirst
            groupFirst == -1 && groupSecond != -1 -> points[i].connectionGroup = groupSecond

            groupFirst != -1 && groupSecond != -1 -> if (groupFirst != groupSecond) {
                val targetGroupId = min(groupFirst, groupSecond)
                val targetValue = groupFirst.takeIf { groupSecond == targetGroupId } ?: groupSecond
                points.filter { it.connectionGroup == targetValue }
                    .forEach { it.connectionGroup = targetGroupId }
            }

            else -> {
                points[i].connectionGroup = connectionGroupId
                points[j].connectionGroup = connectionGroupId
                connectionGroupId++
            }
        }

        return connectionGroupId
    }

    private fun String.toPoint3D(): Point3D = this.split(",").filter { it.isNotBlank() }
        .map(String::toInt)
        .let { Point3D(it[0], it[1], it[2]) }

    private data class Point3D(val x: Int, val y: Int, val z: Int) {

        var connectionGroup: Int = -1

        fun distance(other: Point3D): Double = sqrt(
            (this.x - other.x).toDouble().pow(2) +
                (this.y - other.y).toDouble().pow(2) +
                (this.z - other.z).toDouble().pow(2)
        )
    }
}
