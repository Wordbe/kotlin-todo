package co.wordbe.kotlintodo.api.model

import co.wordbe.kotlintodo.domain.Todo
import co.wordbe.kotlintodo.domain.TodoPriority
import java.time.LocalDateTime

class TodoResponse(
    val id: Long,
    val title: String,
    val description: String,
    val done: Boolean,
    val priority: TodoPriority,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
) {
    companion object {
        fun of(todo: Todo?): TodoResponse {
            checkNotNull(todo) { "Todo is null" }
            checkNotNull(todo.id) { "Todo ID is null" }

            return TodoResponse(
                id = todo.id,
                title = todo.title,
                description = todo.description,
                done = todo.done,
                priority = todo.priority,
                createdAt = todo.createdAt,
                updatedAt = todo.updatedAt
            )
        }
    }
}
