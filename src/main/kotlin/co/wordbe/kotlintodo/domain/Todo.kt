package co.wordbe.kotlintodo.domain

import java.time.LocalDateTime
import java.time.LocalDateTime.now
import javax.persistence.*

@Entity
@Table(name = "todos")
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var title: String,

    @Lob
    var description: String,

    var done: Boolean,

    @Enumerated(EnumType.STRING)
    var priority: TodoPriority,

    var createdAt: LocalDateTime,

    var updatedAt: LocalDateTime? = null,
) {
    constructor(priority: TodoPriority): this(null, "", "", false, priority, now(), null)

    fun update(title: String, description: String, done: Boolean, priority: TodoPriority) {
        this.title = title
        this.description = description
        this.done = done
        this.priority = priority
        this.updatedAt = now()
    }
}
