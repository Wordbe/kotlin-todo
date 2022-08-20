package co.wordbe.kotlintodo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinTodoApplication

fun main(args: Array<String>) {
    runApplication<KotlinTodoApplication>(*args)
}
