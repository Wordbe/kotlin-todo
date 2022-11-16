package co.wordbe.kotlintodo.kotlin.syntax

import java.io.File

typealias StringPredicate = (s: String) -> Boolean

fun main() {
    val isApple: StringPredicate = { it == "apple" }
    println(isApple("apple")) // true
}

typealias FileTable<K> = MutableMap<K, MutableList<File>>

typealias MyPredicate<T> = (T) -> Boolean

class MusicalInstrument {
    inner class Violin
}

typealias MIViolin = MusicalInstrument.Violin
