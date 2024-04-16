package core

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

abstract class DayTest<INPUT, PART1, PART2>(
    private val instance: Day<INPUT>,
    private val part1Tests: List<Pair<String, PART1>>,
    private val part2Tests: List<Pair<String, PART2>>,
) {
    constructor(
        classUnderTest: Class<out Day<INPUT>>,
        part1Tests: List<Pair<String, PART1>>,
        part2Tests: List<Pair<String, PART2>>
    ) : this(classUnderTest.getDeclaredConstructor().newInstance(), part1Tests, part2Tests)

    @Test
    internal fun worksWithoutErrors() = assertDoesNotThrow {
        instance.solve(part1Tests[0].first)
    }

    @TestFactory
    @DisplayName("part1")
    internal fun part1Tests(): Collection<DynamicTest> = generateTests(part1Tests, "part1", instance::part1)

    @TestFactory
    @DisplayName("part2")
    internal fun part2Tests(): Collection<DynamicTest> = generateTests(part2Tests, "part2", instance::part2)

    private fun generateTests(
        testParameters: List<Pair<String, *>>,
        testMethodName: String,
        testMethod: (INPUT) -> Any
    ): Collection<DynamicTest> =
        testParameters.map {
            dynamicTest("${instance.javaClass.simpleName}.$testMethodName() should return ${it.second}") {
                assertEquals(it.second, testMethod(prepareInput(it.first)))
            }
        }


    @Suppress("UNCHECKED_CAST")
    private fun prepareInput(input: String): INPUT {
        val inputConverterField = instance.javaClass.superclass.getDeclaredField("inputConverter")
            .apply { trySetAccessible() }
        val inputConverterFunction = inputConverterField.get(instance) as Function1<String, INPUT>
        return inputConverterFunction.invoke(input)
    }
}
