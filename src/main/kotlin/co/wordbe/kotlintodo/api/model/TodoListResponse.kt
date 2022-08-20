package co.wordbe.kotlintodo.api.model

import co.wordbe.kotlintodo.domain.Todo
import com.fasterxml.jackson.annotation.JsonIgnore

data class TodoListResponse(
    val items: List<TodoResponse>
) {
    val size: Int
        @JsonIgnore
        get() = items.size

    fun get(index: Int) = items[index]

    companion object {
        fun of(todoList: List<Todo>) =
            TodoListResponse(todoList.map(TodoResponse::of))
    }
}