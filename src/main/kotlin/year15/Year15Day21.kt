package year15

import core.Day
import core.InputConverter.Companion.toLines

class Year15Day21 : Day<List<String>>(::toLines) {

    private val weapons = listOf(
        Item(8, 4, 0),
        Item(10, 5, 0),
        Item(25, 6, 0),
        Item(40, 7, 0),
        Item(74, 8, 0),
    )

    private val armor = listOf(
        Item(13, 0, 1),
        Item(31, 0, 2),
        Item(53, 0, 3),
        Item(75, 0, 4),
        Item(102, 0, 5)
    )

    private val rings = listOf(
        Item(25, 1, 0),
        Item(50, 2, 0),
        Item(100, 3, 0),
        Item(20, 0, 1),
        Item(40, 0, 2),
        Item(80, 0, 3),
    )

    override fun part1(input: List<String>): Int = getAllGameResults(input).filter { it > 0 }.min()

    override fun part2(input: List<String>): Int = -1 * getAllGameResults(input).min()

    private fun getAllGameResults(input: List<String>): List<Int> {
        val boss = input.map {
            it.substringAfter(":").trim().toInt()
        }
            .let { (hitPoints, damage, armor) -> Boss(hitPoints, damage, armor) }

        val ringCombinations = rings.map { listOf(it) }.toMutableList()
        val ringCombinationsOfTwo = rings.mapIndexed { index, item ->
            rings.subList(index + 1, rings.size).map {
                listOf(item, it)
            }
        }.flatten()
        ringCombinations.addAll(ringCombinationsOfTwo)

        return weapons.flatMap {
            val player = Player(100, it)
            val gameResults = mutableListOf(gameResult(player, boss))
            gameResults.addAll(
                ringCombinations.map { equippedRings ->
                    gameResult(Player(100, it, rings = equippedRings), boss)
                }
            )

            armor.forEach { armor ->
                gameResults.add(gameResult(Player(100, it, armor), boss))

                gameResults.addAll(
                    ringCombinations.map { equippedRings ->
                        gameResult(Player(100, it, armor, equippedRings), boss)
                    }
                )
            }

            gameResults
        }
    }

    private fun gameResult(player: Player, boss: Boss): Int {
        val playerDamage = (player.damage() - boss.armor).takeIf { it > 0 } ?: 1
        val bossDamage = (boss.damage - player.armor()).takeIf { it > 0 } ?: 1

        val movesToKillBoss = if (boss.hitPoints % playerDamage > 0) {
            1
        } else {
            0
        } + boss.hitPoints / playerDamage

        val movesToKillPlayer = if (player.hitPoints % bossDamage > 0) {
            1
        } else {
            0
        } + player.hitPoints / bossDamage

        return if (movesToKillPlayer < movesToKillBoss) {
            -player.cost()
        } else {
            player.cost()
        }
    }

    private data class Boss(val hitPoints: Int, val damage: Int, val armor: Int)

    private data class Player(
        val hitPoints: Int,
        val weapon: Item,
        val armor: Item? = null,
        val rings: List<Item> = listOf()
    ) {
        fun damage(): Int = rings.sumOf { it.damage } + weapon.damage

        fun armor(): Int = rings.sumOf { it.armor } + (armor?.armor ?: 0)

        fun cost(): Int = weapon.cost + (armor?.cost ?: 0) + rings.sumOf { it.cost }
    }

    private data class Item(val cost: Int, val damage: Int, val armor: Int)
}
