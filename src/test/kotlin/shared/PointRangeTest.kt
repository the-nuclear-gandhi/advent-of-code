package shared

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class PointRangeTest {

    @Nested
    inner class TestValues {

        @Test
        fun `should contain start and end value`() {
            val start = Point(0, 0)
            val end = Point(2, 2)
            val pointRange = PointRange(start, end)

            assertTrue(start in pointRange.values)
            assertTrue(end in pointRange.values)
        }

        @Test
        fun `should contain points in between start & end`() {
            val start = Point(0, 0)
            val end = Point(3, 3)
            val pointRange = PointRange(start, end)

            assertTrue(Point(1, 1) in pointRange.values)
            assertTrue(Point(2, 2) in pointRange.values)
        }

        @Test
        fun `should not contain points outside of the given range`() {
            val start = Point(0, 0)
            val end = Point(2, 2)
            val pointRange = PointRange(start, end)

            assertTrue(Point(-1, -1) !in pointRange.values)
            assertTrue(Point(4, 4) !in pointRange.values)
        }
    }

    @Test
    fun `should correctly tell whether the range is vertical`() {
        val pointRange = PointRange(Point(0, 0), Point(2, 2))
        assertFalse(pointRange.isVertical())

        val verticalPointRange = PointRange(Point(-3, 5), Point(3, 5))
        assertTrue(verticalPointRange.isVertical())
    }

    @Test
    fun `should correctly tell whether the range is horizontal`() {
        val pointRange = PointRange(Point(0, 0), Point(2, 2))
        assertFalse(pointRange.isHorizontal())

        val horizontalPointRange = PointRange(Point(3, 5), Point(3, -5))
        assertTrue(horizontalPointRange.isHorizontal())
    }

    @Test
    fun `should correctly calculate the size of the range`() {
        val pointRange = PointRange(Point(0, 0), Point(2, 2))
        assertEquals(3, pointRange.size)

        val horizontalPointRange = PointRange(Point(0, 0), Point(0, 5))
        assertEquals(6, horizontalPointRange.size)

        val verticalPointRange = PointRange(Point(0, 0), Point(4, 0))
        assertEquals(5, verticalPointRange.size)
    }
}
