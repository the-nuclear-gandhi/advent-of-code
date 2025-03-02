package shared

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DirectionTest {

    @Nested
    inner class TestCompanionOf {

        @Test
        fun `produces valid directions`() {
            val upDirections = listOf('^', 'U', 'N')
            upDirections.map(Direction::of).forEach { assertEquals(Direction.UP, it) }

            val downDirections = listOf('v', 'D', 'S')
            downDirections.map(Direction::of).forEach { assertEquals(Direction.DOWN, it) }

            val leftDirections = listOf('<', 'L', 'W')
            leftDirections.map(Direction::of).forEach { assertEquals(Direction.LEFT, it) }

            val rightDirections = listOf('>', 'R', 'E')
            rightDirections.map(Direction::of).forEach { assertEquals(Direction.RIGHT, it) }
        }

        @ParameterizedTest
        @ValueSource(chars = ['F', 'B', '/', ')'])
        fun `throws exception for unknown direction characters`(directionChar: Char) {
            assertThrows<IllegalArgumentException> { Direction.of(directionChar) }
        }
    }
}
