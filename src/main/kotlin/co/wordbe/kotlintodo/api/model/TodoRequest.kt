package co.wordbe.kotlintodo.api.model

import co.wordbe.kotlintodo.domain.TodoPriority

data class TodoRequest(
    val title: String,
    val description: String,
    val done: Boolean = false,
    val priority: TodoPriority,
)
