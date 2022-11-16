package co.wordbe.kotlintodo.kotlin.whykotlin.example01

import java.time.LocalDateTime

class User(
    val id: Long,
    val email: String,
    val createdAt: LocalDateTime) {

    constructor(id: Long, email: String) : this(id, email, LocalDateTime.now())

    constructor(id: Long) : this(id, "-")

    constructor() : this(-1L)
}

class Team (
    var id: Long,
    var name: String,
    var createdAt: LocalDateTime,
)

class ACompanionObject() {
    companion object {
        fun print() {
            println("나는 오브젝트입니다.")
        }
    }
}

object AObject {
    fun hi() = "hi"
}

class A {
    val id: Long = 1L
    var name: String = "name"
}
