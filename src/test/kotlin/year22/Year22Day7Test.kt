package year22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Year22Day7Test {

    val year22Day7 = Year22Day7()
    val input = listOf(
        "$ cd /",
        "$ ls",
        "dir a",
        "14848514 b.txt",
        "8504156 c.dat",
        "dir d",
        "$ cd a",
        "$ ls",
        "dir e",
        "29116 f",
        "2557 g",
        "62596 h.lst",
        "$ cd e",
        "$ ls",
        "584 i",
        "$ cd ..",
        "$ cd ..",
        "$ cd d",
        "$ ls",
        "4060174 j",
        "8033020 d.log",
        "5626152 d.ext",
        "7214296 k"
    )

    @Nested
    inner class TestPart1 {

        @Test
        fun `should return 95437`() {
            assertEquals(95437, year22Day7.part1(input))
        }
    }

    @Nested
    inner class TestPart2 {

        @Test
        fun `should return 24933642`() {
            assertEquals(24933642, year22Day7.part2(input))
        }
    }
}
