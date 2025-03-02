package shared

enum class Direction {
    UP, RIGHT, DOWN, LEFT;

    companion object {
        internal fun of(char: Char): Direction = when (char) {
            '^', 'U', 'N' -> UP
            '>', 'R', 'E' -> RIGHT
            'v', 'D', 'S' -> DOWN
            '<', 'L', 'W' -> LEFT
            else -> throw IllegalArgumentException("Unknown direction: $char")
        }
    }
}
