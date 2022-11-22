package co.wordbe.kotlintodo.kotlin.syntax

import co.wordbe.kotlintodo.domain.TodoFactory
import co.wordbe.kotlintodo.domain.TodoPriority
import java.time.LocalDateTime

fun main() {
    val todo = TodoFactory.create(TodoPriority.HIGH, LocalDateTime.now())
    println(todo)
}
