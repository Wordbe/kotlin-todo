package co.wordbe.kotlintodo.service

import co.wordbe.kotlintodo.domain.Todo
import co.wordbe.kotlintodo.domain.TodoPriority
import co.wordbe.kotlintodo.domain.TodoRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.data.repository.findByIdOrNull
import java.time.LocalDateTime

@ExtendWith(MockKExtension::class)
class TodoServiceTest {

    @InjectMockKs
    lateinit var todoService: TodoService

    @MockK
    lateinit var todoRepository: TodoRepository

    private val stub: Todo by lazy {
        Todo(
            id = 1,
            title = "테스트",
            description = "테스트 상세",
            done = false,
            priority = TodoPriority.LOW,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
        )
    }

    @DisplayName("한 개의 TODO 를 반환해야 한다")
    @Test
    fun `return a todo`() {
        every { todoRepository.findByIdOrNull(1) } returns stub

        val result = todoService.findById(1)

        assertThat(result).isNotNull
        assertThat(result).isEqualTo(stub)

        verify(exactly = 0) { todoService.findAll() }
    }
}
