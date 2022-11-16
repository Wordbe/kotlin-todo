package co.wordbe.kotlintodo.kotlin.whykotlin.example03

import java.time.LocalDateTime
import java.time.LocalDateTime.now

fun main() {
    val name: String = "jacob.jinn"
//    name.let({name -> name.length})
//    name.map {  }
//    val names = listOf("jacob", "peter", "anne")
//    names.map {  }

//    val company = Company(1L, "kakao", now())
//    val companyName = company.let { it.name }
//    val incId = company.run { this.id + 1 }
//    val logoName = with(company) {
//        company.logo() + this.name
//    }
//    company.apply { println(createdAt) }
//    company.also { println(it) }
}

data class Company(val id: Long, val name: String, val createdAt: LocalDateTime) {
    fun logo(): String = "logo.png"
}
