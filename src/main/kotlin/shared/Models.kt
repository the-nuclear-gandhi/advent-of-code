package shared

data class Point(val x: Int, val y: Int) {
    fun neighbours(diagonal: Boolean = false): List<Point> = (x - 1..x + 1).flatMap { dx ->
        (y - 1..y + 1).mapNotNull { dy ->
            Point(dx, dy).takeUnless { it == this }.let { p ->
                if (diagonal) {
                    p
                } else {
                    p?.takeIf { p.x == this.x || p.y == this.y }
                }
            }
        }
    }
}
