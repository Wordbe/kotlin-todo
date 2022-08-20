package co.wordbe.kotlintodo.api

import co.wordbe.kotlintodo.api.model.TodoListResponse
import co.wordbe.kotlintodo.api.model.TodoRequest
import co.wordbe.kotlintodo.api.model.TodoResponse
import co.wordbe.kotlintodo.service.TodoService
import org.springframework.http.ResponseEntity.noContent
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/todos")
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping
    fun getAll() =
        TodoListResponse.of(todoService.findAll())

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) =
        TodoResponse.of(todoService.findById(id))

    @PostMapping
    fun create(@RequestBody request: TodoRequest) =
        TodoResponse.of(todoService.create(request))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: TodoRequest) =
        TodoResponse.of(todoService.update(id, request))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        todoService.delete(id)
        noContent().build<Unit>()
    }
}