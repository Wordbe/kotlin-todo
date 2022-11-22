package co.wordbe.kotlintodo.kotlin.syntax

import java.time.LocalDateTime
import java.util.*

fun main() {
    Calendar.getInstance()
        .also {
            val localDateTime = LocalDateTime.ofInstant(it.toInstant(), it.timeZone.toZoneId())
            println(localDateTime)
        }
        .apply { add(Calendar.DAY_OF_YEAR, -7) }
        .also {
            val localDateTime = LocalDateTime.ofInstant(it.toInstant(), it.timeZone.toZoneId())
            println(localDateTime)
        }
        .let {
            LocalDateTime.ofInstant(it.toInstant(), it.timeZone.toZoneId())
        }
        .run {
            println(this)
        }
        .let {
            println(it)
        }
}
