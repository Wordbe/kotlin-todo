package co.wordbe.kotlintodo.service

import co.wordbe.kotlintodo.api.model.TodoRequest
import co.wordbe.kotlintodo.domain.Todo
import co.wordbe.kotlintodo.domain.TodoRepository
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@Service
@Transactional(readOnly = true)
class TodoService(
    val todoRepository: TodoRepository
) {

    fun findAll(): List<Todo> = todoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))

    fun findById(id: Long): Todo =
        todoRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @Transactional
    fun create(request: TodoRequest?): Todo {
        checkNotNull(request)

        val todo = Todo(
            title = request.title,
            description = request.description,
            done = request.done,
            priority = request.priority,
            createdAt = LocalDateTime.now()
        )
        return todoRepository.save(todo)
    }

    @Transactional
    fun update(id: Long, request: TodoRequest?): Todo {
        checkNotNull(request)

        return findById(id).apply {
            update(request.title, request.description, request.done, request.priority)
        }
    }

    @Transactional
    fun delete(id: Long) = todoRepository.deleteById(id)
}
