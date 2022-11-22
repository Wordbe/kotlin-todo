package co.wordbe.kotlintodo.domain

import java.time.LocalDateTime

object TodoFactory {
    fun create(priority: TodoPriority?, createdAt: LocalDateTime): Todo {
        return Todo(priority ?: TodoPriority.LOW, createdAt)
    }
}
