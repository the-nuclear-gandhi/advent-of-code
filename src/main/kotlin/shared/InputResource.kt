package shared

import java.net.URL

class InputResource private constructor(private val resource: URL) {

    companion object {
        fun forName(resourceName: String): InputResource {
            val resource = InputResource::class.java.classLoader.getResource(resourceName)
                ?: throw RuntimeException("Input Resource for name $resourceName not found")

            return InputResource(resource)
        }
    }

    fun asString(): String = resource.readText()
    fun asLines(): List<String> = asString().lines().filter { it.isNotEmpty() }
}
