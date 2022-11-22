package co.wordbe.kotlintodo.kotlin.syntax

import co.wordbe.kotlintodo.domain.Todo
import co.wordbe.kotlintodo.domain.TodoPriority

object TodoFactory {
    fun create(priority: TodoPriority): Todo {
        return Todo(priority)
    }
}

fun main() {
    val todo = TodoFactory.create(TodoPriority.HIGH)
    println(todo)
}
