package year22

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point
import shared.PointRange
import kotlin.math.abs

class Year22Day15(private val targetRow: Int = 2_000_000, private val searchZoneSize: Int = 4_000_000) :
    Day<List<String>>(::toLines) {
    override fun part1(input: List<String>): Int = inputToSensorBeaconPairs(input).let { sensorBeaconPairs ->
        sensorBeaconPairs.filter { it.distanceToTargetRow(targetRow) < it.sensor.manhattanDistance(it.beacon) }
            .flatMap {
                val spreadOnTargetRow = it.sensor.manhattanDistance(it.beacon) - it.distanceToTargetRow(targetRow)
                it.sensor.x - spreadOnTargetRow..it.sensor.x + spreadOnTargetRow
            }
            .toSet().size - sensorBeaconPairs.map { it.beacon }.filter { it.y == targetRow }.toSet().size
    }

    private fun inputToSensorBeaconPairs(input: List<String>): List<SensorBeaconPair> = input.flatMap { it.split(":") }
        .map { Point(it.substringAfter("x=").substringBefore(",").toInt(), it.substringAfter("y=").toInt()) }
        .chunked(2)
        .map { SensorBeaconPair(it[0], it[1]) }

    override fun part2(input: List<String>): Long = inputToSensorBeaconPairs(input).let { sensorBeaconPairs ->
        sensorBeaconPairs.flatMap {
            val distance = it.sensor.manhattanDistance(it.beacon) + 1
            val cornerPoints = listOf(
                Point(it.sensor.x, it.sensor.y - distance),
                Point(it.sensor.x - distance, it.sensor.y),
                Point(it.sensor.x, it.sensor.y + distance),
                Point(it.sensor.x + distance, it.sensor.y)
            )

            cornerPoints.zipWithNext().map { (p1, p2) -> PointRange(p1, p2) }
                .toMutableList()
                .apply { this += PointRange(cornerPoints.last(), cornerPoints[0]) }
        }
            .flatMap { it.values }
            .filter {
                sensorBeaconPairs.none { pair ->
                    it.manhattanDistance(pair.sensor) <= pair.sensor.manhattanDistance(pair.beacon)
                }
            }
            .first { it.x in 0..searchZoneSize && it.y in 0..searchZoneSize }
            .let { it.x * 4_000_000L + it.y }
    }

    private data class SensorBeaconPair(val sensor: Point, val beacon: Point) {
        fun distanceToTargetRow(targetRow: Int): Int = abs(sensor.y - targetRow)
    }

    private fun Point.manhattanDistance(other: Point): Int = abs(this.x - other.x) + abs(this.y - other.y)
}
