package co.wordbe.kotlintodo.service

import co.wordbe.kotlintodo.domain.Todo
import co.wordbe.kotlintodo.domain.TodoRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.data.repository.findByIdOrNull
import java.time.LocalDateTime

@ExtendWith(MockKExtension::class)
class TodoServiceTest {

    @InjectMockKs
    lateinit var service: TodoService

    @MockK
    lateinit var repository: TodoRepository

    private val stub: Todo by lazy {
        Todo(
            id = 1,
            title = "테스트",
            description = "테스트 상세",
            done = false,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
        )
    }

    @DisplayName("한 개의 TODO 를 반환해야 한다")
    @Test
    fun `return a todo`() {
        every { repository.findByIdOrNull(1) } returns stub

        val result = service.findById(1)

        assertThat(result).isNotNull
        assertThat(result).isEqualTo(stub)
    }
}