package year15

import shared.Day

class Year15Day9 : Day<List<String>>() {

  override fun getInput(): List<String> = inputResource().asLines()

  override fun part1(input: List<String>): Int = solve(input) { collection -> collection.minOrNull() ?: 0 }

  override fun part2(input: List<String>): Int = solve(input) { collection -> collection.maxOrNull() ?: 0 }

  private fun solve(input: List<String>, criterion: (Collection<Int>) -> Int): Int {
    val locations = locations(input)

    val locationCount = locations.size

    /*
      The solution is calculated taking each location as starting location
    */
    return locations.map { location ->
      val distances = distanceMap(input, locations, location)

      /*
        The solutionMap represents the map for intermediate solutions in the DP algorithm
        The key is the pair of values: first - set of already visited vertices, second - the last visited vertex on the
        way to the set
        The value is the distance to cover when visiting all the vertices of the set calculated according to the
        provided criterion (minimal or maximal distance)

        Initially only one vertex can be visited, so the initial distances are initialized with the distance from vertex 0
        to each respective vertex
      */
      val solutionMap = (1 until locationCount).map {
        Pair(setOf(it), it) to distances[0][it]
      }
        .toMap()
        .toMutableMap()

      /*
        Each loop increases the visited vertex set length by one
        For each such length all combinations of visited vertex indices will be generated and distances to these vertex
        sets will be calculated and put into the solution map to be used in the next steps
      */
      (2 until locationCount).forEach { length ->

        /*
          Generate all possible combinations of indices 1 to n (exclusive) of length equal to `length`
        */
        combinations(locationCount, length).forEach { combination ->

          /*
            For each item in the generated combination do the following:
            - consider the previously visited set to be the value of the combination excluding the selected item
            - consider each vertex in the remaining set as the second to last vertex before reaching the selected one
            - for each second to last vertex calculate the distance to the current vertex:
                solutionMap[(previousSet, secondToLastVertex) + distance[secondToLastVertex][selectedItem]]
            - the solution of this sub-problem is then taken based on the provided criterion
           */
          combination.forEach { item ->
            run {
              val previousVisitedSet = combination.toSet() - item
              val optimalDistance = previousVisitedSet.map { vertex ->
                solutionMap[Pair(
                  previousVisitedSet,
                  vertex
                )]!! + distances[vertex][item]
              }
                .let(criterion)

              solutionMap[Pair(combination.toSet(), item)] = optimalDistance
            }
          }
        }

      }

      /*
        From the resulting solution map take all the entries with keys having n-1 vertices and return the value
        according to the criterion (min or max)
      */
      solutionMap.filterKeys { it.first == (1 until locationCount).toSet() }.values.let(criterion)

    }
      .let(criterion)
  }

  private fun locations(input: List<String>): MutableList<String> = input.map {
      val tokens = it.split(" ")
      listOf(tokens[0], tokens[2])
    }
      .flatten()
      .distinct()
      .toMutableList()

  private fun distanceMap(input: List<String>, locations: List<String>, startingLocation: String): Array<IntArray> {
    val locationsWithStartingLocation = locations.toMutableList()
    locationsWithStartingLocation[locations.indexOf(startingLocation)] = locations[0]
    locationsWithStartingLocation[0] = startingLocation

    val size = locations.size

    val distances = Array(size) { IntArray(size) }
    input.forEach {
      val origin = it.substringBefore("to").trim()
      val destination = it.substringAfter("to").substringBefore("=").trim()
      val distance = it.substringAfter("=").trim().toInt()

      val indexOfOrigin = locationsWithStartingLocation.indexOf(origin)
      val indexOfDestination = locationsWithStartingLocation.indexOf(destination)

      distances[indexOfOrigin][indexOfDestination] = distance
      distances[indexOfDestination][indexOfOrigin] = distance
    }

    return distances
  }

  private fun combinations(max: Int, length: Int): List<IntArray> {
    val combinations = mutableListOf<IntArray>()
    val combination = (1..length).toList().toIntArray()

    while (combination.last() < max) {
      combinations.add(combination.clone())
      var t = length - 1
      while (t != 0 && combination[t] == max - length + t) {
        t--
      }
      combination[t]++
      (t + 1 until length).forEach { combination[it] = combination[it - 1] + 1 }
    }

    return combinations
  }

}
