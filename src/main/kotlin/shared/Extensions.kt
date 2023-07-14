package shared

/**
 * Splits a string on empty lines and returns all resulting non-empty blocks which in turn can be split into lines.
 */
fun String.toLineBlocks(): List<LineBlock> = this.split("\n\n")
    .filter { it.isNotEmpty() }
    .map { it.lines() }
