package co.wordbe.kotlintodo.kotlin.syntax

fun String.first(): Char {
    return this[0]
}

fun main() {
    val name = "jacob"
    val first = name.first()
    println(first)
}
