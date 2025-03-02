package shared

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PointTest {

    @Nested
    inner class TestCompanionFromString {

        @Test
        fun `should produce a point from a string with default delimiter`() {
            val point = Point.fromString("1,2")
            assertEquals(1, point.x)
            assertEquals(2, point.y)
        }

        @Test
        fun `should produce a point from a string with a custom delimiter`() {
            val point = Point.fromString("1-2", "-")
            assertEquals(1, point.x)
            assertEquals(2, point.y)
        }

        @ParameterizedTest
        @ValueSource(strings = ["1,2,3", "1,a", "1"])
        fun `should throw an IllegalArgumentException for invalid strings`(s: String) {
            assertThrows<IllegalArgumentException> { Point.fromString(s) }
        }
    }

    @Nested
    inner class TestNeighbours {

        @Test
        fun `produces valid neighbour points without diagonals`() {
            val point = Point(1, 1)
            val neighbours = point.neighbours()
            assertTrue(neighbours.isNotEmpty())
            assertEquals(4, neighbours.size)

            assertTrue(Point(0, 1) in neighbours)
            assertTrue(Point(2, 1) in neighbours)
            assertTrue(Point(1, 0) in neighbours)
            assertTrue(Point(1, 2) in neighbours)

            assertFalse(point in neighbours)
        }

        @Test
        fun `produces valid neighbour points with diagonals`() {
            val point = Point(1, 1)
            val neighbours = point.neighbours(true)

            assertTrue(neighbours.isNotEmpty())
            assertEquals(8, neighbours.size)

            assertTrue(Point(0, 0) in neighbours)
            assertTrue(Point(0, 1) in neighbours)
            assertTrue(Point(0, 2) in neighbours)
            assertTrue(Point(1, 0) in neighbours)
            assertTrue(Point(1, 0) in neighbours)
            assertTrue(Point(2, 0) in neighbours)
            assertTrue(Point(2, 1) in neighbours)
            assertTrue(Point(2, 2) in neighbours)

            assertFalse(point in neighbours)
        }
    }

    @Nested
    inner class TestNextInDirection {

        @Test
        fun `produces valid horizontal next points`() {
            val point = Point(1, 1)
            val nextPointRight = point.nextInDirection(Direction.RIGHT)
            assertEquals(Point(1, 2), nextPointRight)

            val nextPointLeft = point.nextInDirection(Direction.LEFT)
            assertEquals(Point(1, 0), nextPointLeft)
        }

        @Test
        fun `produces valid vertical next points`() {
            val point = Point(1, 1)
            val nextPointUp = point.nextInDirection(Direction.UP)
            assertEquals(Point(0, 1), nextPointUp)

            val nextPointDown = point.nextInDirection(Direction.DOWN)
            assertEquals(Point(2, 1), nextPointDown)
        }
    }

}
