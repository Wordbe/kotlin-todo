package co.wordbe.kotlintodo.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class TodoFactoryTest {

    @DisplayName("할 일 생성")
    @Test
    fun `create todo`() {
        val createdAt = LocalDateTime.now()
        val todo = TodoFactory.create(TodoPriority.HIGH, createdAt)

        assertThat(todo).isEqualTo(Todo(TodoPriority.HIGH, createdAt))
    }

    @DisplayName("우선순위 없을 때는 우선순위 낮음으로 할 일 생성")
    @Test
    fun `create todo with priority low when priority null`() {
        val createdAt = LocalDateTime.now()
        val todo = TodoFactory.create(null, createdAt)

        assertThat(todo).isEqualTo(Todo(TodoPriority.LOW, createdAt))
    }
}
