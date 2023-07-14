package year22

import shared.Day
import shared.InputConverter.Companion.toLines

class Year22Day7 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = parseFileSystem(input)
        .let { nodeMap ->
            nodeMap.map { nodeSize(it.value, nodeMap) }
                .filter { it < 100_000 }
                .sum()
        }

    override fun part2(input: List<String>): Int = parseFileSystem(input)
        .let { nodeMap ->
            val requiredSize = nodeMap["/"]?.let {
                30_000_000 - (70_000_000 - nodeSize(it, nodeMap))
            } ?: throw RuntimeException("No value for root node present in the node map")

            nodeMap.map { nodeSize(it.value, nodeMap) }
                .filter { it > requiredSize }
                .min()
        }

    private fun parseFileSystem(input: List<String>): Map<String, Node> {
        var currentNode: Node? = null
        val nodes = mutableMapOf<String, Node>()

        for (line in input) {
            val tokens = line.split(" ")
            when (tokens[0]) {
                "$" -> if (tokens[1] == "cd") {
                    currentNode = when (tokens[2]) {
                        "/" -> nodes.computeIfAbsent("/") { Node("/", mutableListOf(), 0) }

                        ".." -> currentNode?.let {
                            it.path.substringBeforeLast("/").ifEmpty { "/" }.let { path -> nodes[path] }
                        }

                        else -> currentNode?.let {
                            createPath(it.path, tokens[2]).let { path -> nodes[path] }
                        }
                    }
                }

                "dir" -> currentNode?.let {
                    val path = createPath(currentNode.path, tokens[1])
                    it.children += path
                    nodes[path] = Node(path, mutableListOf(), 0)
                }

                else -> currentNode?.let {
                    it.size += tokens[0].toInt()
                }
            }
        }

        return nodes
    }

    private fun createPath(vararg items: String): String = items.joinToString("/").replace("//", "/")

    private fun nodeSize(node: Node, nodes: Map<String, Node>): Int =
        node.size + node.children.mapNotNull { nodes[it] }.sumOf { nodeSize(it, nodes) }

    private data class Node(val path: String, val children: MutableList<String>, var size: Int)
}
