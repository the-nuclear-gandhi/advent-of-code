package shared

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ModelsTest {

    @Nested
    inner class PointTest {

        @Test
        fun `produces valid neighbour points without diagonals`() {
            val point = Point(1, 1)
            val neighbours = point.neighbours()
            assertTrue(neighbours.isNotEmpty())
            assertEquals(4, neighbours.size)

            assertTrue(Point(0,1) in neighbours)
            assertTrue(Point(2,1) in neighbours)
            assertTrue(Point(1,0) in neighbours)
            assertTrue(Point(1,2) in neighbours)

            assertFalse(point in neighbours)
        }

        @Test
        fun `produces valid neighbour points with diagonals`() {
            val point = Point(1, 1)
            val neighbours = point.neighbours(true)

            assertTrue(neighbours.isNotEmpty())
            assertEquals(8, neighbours.size)

            assertTrue(Point(0,0) in neighbours)
            assertTrue(Point(0,1) in neighbours)
            assertTrue(Point(0,2) in neighbours)
            assertTrue(Point(1,0) in neighbours)
            assertTrue(Point(1,0) in neighbours)
            assertTrue(Point(2,0) in neighbours)
            assertTrue(Point(2,1) in neighbours)
            assertTrue(Point(2,2) in neighbours)

            assertFalse(point in neighbours)
        }
    }
}
