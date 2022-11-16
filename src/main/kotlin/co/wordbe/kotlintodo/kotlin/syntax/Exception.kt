package co.wordbe.kotlintodo.kotlin.syntax

import java.nio.file.Files
import kotlin.io.path.Path

fun main() {
    val result = try {
        val path = Path("path")
        val readAllLines = Files.readAllLines(path)
        readAllLines[0]
    } catch (e: Exception) {
        val exception = throw e
        exception
    }
    println(result)


}
