package algorithm

/**
 * This function contains the solution to the travelling salesman problem using the Held-Karp algorithm
 *
 * Based on the Python version found in <a href="https://github.com/CarlEkerot/held-karp">https://github.com/CarlEkerot/held-karp</a>
 */
fun solveTSP(
  distanceMap: Array<IntArray>,
  withReturnToStartingPoint: Boolean = false,
  criterion: (Collection<Int>) -> Int = { collection -> collection.minOrNull() ?: 0 }
): Int {

  val pointCount = distanceMap.size

  val allPointsRange = 0 until pointCount
  val allPointsExceptStartingRange = 1 until pointCount

  /*
    The solution is calculated taking each location as starting location
  */
  return allPointsRange.map { point ->
    val distances = distancesWithStartingPoint(distanceMap, point)

    /*
      The solutionMap represents the map for intermediate solutions in the DP algorithm
      The key is the pair of values: first - set of already visited vertices, second - the last visited vertex on the
      way to the set
      The value is the distance to cover when visiting all the vertices of the set calculated according to the
      provided criterion (minimal or maximal distance)

      Initially only one vertex can be visited, so the initial distances are initialized with the distance from vertex 0
      to each respective vertex
    */
    val solutionMap = allPointsExceptStartingRange.map {
      Pair(setOf(it), it) to distances[0][it]
    }
      .toMap()
      .toMutableMap()

    /*
      Each loop increases the visited vertex set length by one
      For each such length all combinations of visited vertices will be generated and distances to these vertex
      sets will be calculated and put into the solution map to be used in the next steps
    */
    (2 until pointCount).forEach { length ->

      /*
        Generate all possible combinations of indices 1 to n (exclusive) of length equal to `length`
      */
      combinations(pointCount, length).forEach { combination ->

        /*
          For each item in the generated combination do the following:
          - consider the previously visited set to be the value of the combination excluding the selected item
          - consider each vertex in the remaining set as the second to last vertex before reaching the selected one
          - for each second to last vertex calculate the distance to the current vertex:
              solutionMap[(previousSet, secondToLastVertex)] + distance[secondToLastVertex][selectedItem]
          - the solution of this sub-problem is then taken based on the provided criterion
         */
        combination.forEach { item ->
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

    var resultVisitedSet = allPointsExceptStartingRange.toSet()

    if (withReturnToStartingPoint) {
      /*
        To get the result with the return to the starting vertex do the following:
        - consider the previously visited set to include all vertices except the starting one
        - each vertex is in turn considered to be the second to last one before going back to the starting vertex
        - for each vertex calculate the distance to the starting vertex similar to the previous calculation:
            solutionMap[(allVerticesExceptStarting, vertex)] + distance[vertex][startingPoint]
        - the solution is taken the same as previously - based on the provided criterion
      */
      val allVisitedSet = allPointsRange.toSet()
      val previousVisitedSet = allPointsExceptStartingRange.toSet()

      allPointsExceptStartingRange.forEach { vertex ->
        solutionMap[Pair(allVisitedSet, vertex)] =
          solutionMap[Pair(previousVisitedSet, vertex)]!! + distances[vertex][0]
      }

      resultVisitedSet = allVisitedSet
    }

    /*
      From the resulting solution map take all the entries with keys corresponding to all visited vertices including
      or excluding the starting vertex according to the provided condition and return the value according to the
      provided criterion
    */
    solutionMap.filterKeys { it.first == resultVisitedSet }.values.let(criterion)
  }
    .let(criterion)

  /*
    The solution is chosen based on the provided criterion out of the results calculated for every possible starting
    point
  */
}

private fun distancesWithStartingPoint(distanceMap: Array<IntArray>, startingPoint: Int): Array<IntArray> {
  /* switch rows */
  val buffer = distanceMap[startingPoint]
  distanceMap[startingPoint] = distanceMap[0]
  distanceMap[0] = buffer

  /* switch columns */
  for (row in distanceMap) {
    val distanceBuffer = row[0]
    row[0] = row[startingPoint]
    row[startingPoint] = distanceBuffer
  }

  return distanceMap
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
