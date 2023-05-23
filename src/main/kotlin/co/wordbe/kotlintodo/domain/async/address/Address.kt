package co.wordbe.kotlintodo.domain.async.address

import co.wordbe.kotlintodo.domain.async.user.User

data class Address(
    val id: Long,
    val address: String,
    val user: User
)