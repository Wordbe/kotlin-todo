package co.wordbe.kotlintodo.domain.async.user

import java.time.LocalDateTime

data class User(
    val id: Long,
    val email: String,
    val createdAt: LocalDateTime
)